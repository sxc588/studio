package com.github.support.clients.es;


import java.io.IOException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;

	/**
	 * @author huangfox
	 * @date 2014年2月10日 下午3:27:43
	 *
	 */
	public interface ESClientIndex {
	 
		void create();
		void update();
		void delete();

	}
