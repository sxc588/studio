package com.github.support.entitlement.ws.impl;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import org.apache.cxf.jaxrs.client.JAXRSClientFactory;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import com.github.support.cbb.utils.JSONUtil;
import com.github.support.entitlement.entity.User;
import com.github.support.entitlement.ws.UserServiceWs;
/**
 * CXF 提供了三种 REST 客户端，下面将分别进行展示。
 * 第一种：JAX-RS 1.0 时代的客户端
 *
 * <dependency>
 * <groupId>org.apache.cxf</groupId>
 * <artifactId>cxf-rt-rs-client</artifactId>
 * <version>${cxf.version}</version>
 * </dependency>
 *
 */
public class UserServiceWsImpl10Test
{

	@Test
	public void test()
	{
		String baseAddress = "http://localhost:7050/rest/ws/entitlement";

		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		UserServiceWs productService = JAXRSClientFactory.create(baseAddress, UserServiceWsImpl10.class, providerList);
		List<User> productList = productService.getAllUsers();
		for (User product : productList) {
		    System.out.println(JSONUtil.toJson(product));
		}
	}

}
