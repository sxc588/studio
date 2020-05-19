package com.github.support.ccb.es;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Assert;
import org.junit.Test;

public class EsSender {

	private static  RestHighLevelClient client =null;
	
	
	static {
		   RestClient lowLevelRestClient = RestClient.builder(
	                new HttpHost("192.168.208.129", 9200, "http")).build(); 
	        //High Level Client init
	         client =
	                new RestHighLevelClient(lowLevelRestClient);

	}
	@Test
	public void vlid() {
		// TODO Auto-generated method stub
 Assert.assertNotNull(client);
	}
	
	
}
