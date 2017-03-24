package com.github.support.entitlement.ws.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import com.github.support.cbb.utils.JSONUtil;
import com.github.support.entitlement.entity.User;
import com.github.support.entitlement.ws.UserServiceWs;
/**
 * CXF 提供了三种 REST 客户端，下面将分别进行展示。
 * 第二种：JAX-RS 2.0 时代的客户端
 *
 * <dependency>
 * <groupId>org.apache.cxf</groupId>
 * <artifactId>cxf-rt-rs-client</artifactId>
 * <version>${cxf.version}</version>
 * </dependency>
 *
 */
public class UserServiceWsImpl20Test
{

	@Test
	public void test()
	{
		String baseAddress = "http://localhost:7050/rest/v1/entitlement";


		JacksonJsonProvider jsonProvider = new JacksonJsonProvider();

		List productList = ClientBuilder.newClient()
			.register(jsonProvider)
			.target(baseAddress)
			.path("/userservicews/users")
			.request(MediaType.APPLICATION_JSON)
			.get(List.class);
		for (Object product : productList) {
			System.out.println("--"+product);
			
			
		}
	}

}
