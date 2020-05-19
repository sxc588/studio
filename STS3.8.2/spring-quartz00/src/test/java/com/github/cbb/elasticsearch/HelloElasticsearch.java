package com.github.cbb.elasticsearch;

import java.net.InetAddress;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

/**
 * 
 * 使用查询的方式，先简单测试一下是否连通es集群，和对比查询的数据是否一致。
 *
 */
public class HelloElasticsearch {

	public static void main(String[] args) {
		try {
			// 设置集群名称elasticsearch,Settings设置es的集群名称,使用的设计模式，链式设计模式、build设计模式。
			Settings settings = Settings.builder().put("cluster.name", "elasticsearch").build();
			// 读取es集群中的数据,创建client。
			@SuppressWarnings("resource")
			TransportClient client = new PreBuiltTransportClient(settings).addTransportAddresses(
					// 用java访问ES用的端口是9300。es的9200是restful的请求端口号
					// 由于我使用的是伪集群,所以就配置了一台机器,如果是集群方式,将竞选主节点的加进来即可。
					// new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"),
					// 9300),
					// new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"),
					// 9300),
					new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"), 9300));
			// 搜索数据(.actionGet()方法是同步的，没有返回就等待)
			// 方式是先去索引里面查询出索引数据,再去文档里面查询出数据。
			GetResponse response = client.prepareGet("news", "fulltext", "2").execute().actionGet();
			// 输出结果
			System.out.println(response);
			// 关闭client
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}