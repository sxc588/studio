package com.github.cbb.es211;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
 
/**
 * 
 * @Description:构造jestClient配置
 * @author:yzxia
 * @time:2016-5-24 下午1:53:02
 */
@Configuration
public class SpringConfiguration {
//202.105.136.18  SpringConfiguration
	public @Bean HttpClientConfig httpClientConfig() {
		String connectionUrl = "http://127.0.0.1:9200";
		HttpClientConfig httpClientConfig = new HttpClientConfig.Builder(connectionUrl).multiThreaded(true).build();
		return httpClientConfig;
	}
 
	public @Bean JestClient jestClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(httpClientConfig());
		return factory.getObject();
	}
}