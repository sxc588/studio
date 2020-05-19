package com.github.cbb.elasticsearch;

import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequestBuilder;
import org.elasticsearch.client.AdminClient;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * 4、如何使用java api创建索引Index、类型Type、以及指定字段，是否创建索引，是否存储，是否即分词，
 * 又建立索引（analyzed）、是否建索引不分词（not_analyzed）等等。
 *
 */
public class AdminAPI {

    private TransportClient client = null;

    // 在所有的测试方法之前执行
    @SuppressWarnings("resource")
    @Before
    public void init() throws Exception {
        // 设置集群名称elasticsearch
        Settings settings = Settings.builder().put("cluster.name", "elasticsearch")
                // 自动感知的功能(可以通过当前指定的节点获取所有es节点的信息)
                .put("client.transport.sniff", true).build();
        // 创建client
        client = new PreBuiltTransportClient(settings).addTransportAddresses(
                // new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"),
                // 9300),
                // new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"),
                // 9300),
                // 建议指定2个及其以上的节点。
                new InetSocketTransportAddress(InetAddress.getByName("192.168.208.129"), 9300));
    }

    /**
     * 
     * AdminClient创建索引,并配置一些参数,用来指定一些映射关系等等
     * 
     * 这里创建一个索引Index,并且指定分区、副本的数量
     * 
     */
    @Test
    public void createIndexWithSettings() {
        // 获取Admin的API
        AdminClient admin = client.admin();
        // 使用Admin API对索引进行操作
        IndicesAdminClient indices = admin.indices();
        // 准备创建索引
        indices.prepareCreate("food")
                // 配置索引参数
                .setSettings(
                        // 参数配置器
                        Settings.builder()// 指定索引分区的数量。shards分区
                                .put("index.number_of_shards", 5)
                                // 指定索引副本的数量(注意：不包括本身,如果设置数据存储副本为1,实际上数据存储了2份)
                                // replicas副本
                                .put("index.number_of_replicas", 1))
                // 真正执行
                .get();
    }

    /**
     * 你可以通过dynamic设置来控制这一行为,它能够接受以下的选项： true：默认值。
     * 
     * 动态添加字段 false：忽略新字段
     * 
     * strict：如果碰到陌生字段,抛出异常
     * 
     * 给索引添加mapping信息(给表添加schema信息)
     * 
     * @throws IOException
     */
    @Test
    public void elasticsearchSettingsMappings() throws IOException {
        // 1:settings
        HashMap<String, Object> settings_map = new HashMap<String, Object>(2);
        // shards分区的数量4
        settings_map.put("number_of_shards", 4);
        // 副本的数量1
        settings_map.put("number_of_replicas", 1);

        // 2:mappings(映射、schema)
        // field("dynamic", "true")含义是动态字段
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("dynamic", "true")
                // 设置type中的属性
                .startObject("properties")
                // id属性
                .startObject("id")
                // 类型是integer
                .field("type", "integer")
                // 不分词,但是建索引
                .field("index", "not_analyzed")
                // 在文档中存储
                .field("store", "yes").endObject()
                // name属性
                .startObject("name")
                // string类型
                .field("type", "string")
                // 在文档中存储
                .field("store", "yes")
                // 建立索引
                .field("index", "analyzed")
                // 使用ik_smart进行分词
                .field("analyzer", "ik_smart").endObject().endObject().endObject();

        CreateIndexRequestBuilder prepareCreate = client.admin().indices().prepareCreate("computer");
        // 管理索引（user_info）然后关联type（user）
        prepareCreate.setSettings(settings_map).addMapping("xiaomi", builder).get();
    }

    /**
     * index这个属性,no代表不建索引
     * 
     * not_analyzed,建索引不分词
     * 
     * analyzed 即分词,又建立索引
     * 
     * expected [no],[not_analyzed] or [analyzed]。即可以选择三者任意一个值
     * 
     * @throws IOException
     */

    @Test
    public void elasticsearchSettingsPlayerMappings() throws IOException {
        // 1:settings
        HashMap<String, Object> settings_map = new HashMap<String, Object>(2);
        // 分区的数量4
        settings_map.put("number_of_shards", 4);
        // 副本的数量1
        settings_map.put("number_of_replicas", 1);

        // 2:mappings
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()//
                .field("dynamic", "true").startObject("properties")
                // 在文档中存储、
                .startObject("id").field("type", "integer").field("store", "yes").endObject()
                // 不分词,但是建索引、
                .startObject("name").field("type", "string").field("index", "not_analyzed").endObject()
                //
                .startObject("age").field("type", "integer").endObject()
                //
                .startObject("salary").field("type", "integer").endObject()
                // 不分词,但是建索引、
                .startObject("team").field("type", "string").field("index", "not_analyzed").endObject()
                // 不分词,但是建索引、
                .startObject("position").field("type", "string").field("index", "not_analyzed").endObject()
                // 即分词,又建立索引、
                .startObject("description").field("type", "string").field("store", "no").field("index", "analyzed")
                .field("analyzer", "ik_smart").endObject()
                // 即分词,又建立索引、在文档中存储、
                .startObject("addr").field("type", "string").field("store", "yes").field("index", "analyzed")
                .field("analyzer", "ik_smart").endObject()

                .endObject()

                .endObject();

        CreateIndexRequestBuilder prepareCreate = client.admin().indices().prepareCreate("player");
        prepareCreate.setSettings(settings_map).addMapping("basketball", builder).get();
    }
}