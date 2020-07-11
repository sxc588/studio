package com.github.cbb.es211;

import java.io.IOException;
import java.util.List;

import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
 
/**
 * 
 * @Description:简单添加索引  简单查找索引
 * @author:yzxia
 * @time:2016-5-24 下午4:03:11
 */
@Service
public class SearchService {
 
	@Autowired
	private JestClient jestClient;
	int num = 100000;
	String indexName= "news";
 
	/**
	 * 
	 * @Description:批量插入索引
	 * void
	 * @exception:
	 * @author: yzxia
	 * @time:2016-5-24 下午4:03:31
	 */
	public void builderSearchIndex() {
 
		long start = System.currentTimeMillis();
		try {
			// 如果索引存在,删除索引
			IndicesExists indicesExists = new IndicesExists.Builder(indexName).build();
			JestResult isIndexExist = jestClient.execute(indicesExists);
			if (isIndexExist != null && !isIndexExist.isSucceeded()) {
				System.out.println("===索引不存在");
				//不存在 不处理
			}else{
				DeleteIndex index = new DeleteIndex.Builder(indexName).build();
				JestResult result = jestClient.execute(index);
				System.out.println("===索引删除成功");
			}
 
			//创建索引
			JestResult result = jestClient.execute(new CreateIndex.Builder(indexName).build());
			if (result == null || !result.isSucceeded()) {
				throw new Exception(result.getErrorMessage() + "创建索引失败!");
			}
			Bulk.Builder bulk = new Bulk.Builder();
			// 添加添加100万条假数据去服务端(ES)
			for (int i = 0; i < num; i++) {
				News news = new News();
				news.setId(i + 1);
				news.setTitle("你好啊" + (i + 1));
				news.setContent("你好吗?噢噢噢噢哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦哦"
						+ (i + 1));
				 Index index = new Index.Builder(news).index(indexName)
	                     .type(indexName).build();
				 bulk.addAction(index);
			}
			
			jestClient.execute(bulk.build());
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println("创建索引时间:数据量是  " + num + "记录,共用时间 -->> " + (end - start) + " 毫秒");
	}
 
	/**
	 * 搜索新闻
	 * 
	 * @param param
	 * @return
	 */
	public List<News> searchsNews(String param) {
		try {
			long start = System.currentTimeMillis();
			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
			searchSourceBuilder.query(QueryBuilders.queryStringQuery(param));
 
			Search search = new Search.Builder(searchSourceBuilder.toString())
			// multiple index or types can be added.
			.addIndex("news")
			.addIndex("news")
			.build();
			JestResult result = jestClient.execute(search);
			long end = System.currentTimeMillis();
			System.out.println("在" + num + "条记录中,搜索新闻,共用时间 -->> " + (end - start) + " 毫秒");
			return result.getSourceAsObjectList(News.class);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
