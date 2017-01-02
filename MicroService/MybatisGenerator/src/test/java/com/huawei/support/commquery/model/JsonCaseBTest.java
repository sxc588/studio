package com.huawei.support.commquery.model;

import java.io.IOException;
import org.junit.Test;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.github.support.commquery.model.JsonCaseB;
import com.github.support.commquery.model.Person;

public class JsonCaseBTest
{

	@Test
	public void testRootNode() throws JsonProcessingException
	{
		JsonCaseB caseb = new JsonCaseB();

		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);

		caseb.setAge(123);
		caseb.setSex("Boy");

		String jsonStr = mapper.writeValueAsString(caseb);

		System.out.println("JSON:" + jsonStr);
	}
	@Test
	public void testReadJson() throws JsonParseException, JsonMappingException, IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		String inputjsonstr = "{\"name\":\"BeiJing\",\"age\":\"16\",\"sex\":\"male\"}";

		Person readcase = mapper.readValue(inputjsonstr, Person.class);

		String jsonStr = mapper.writeValueAsString(readcase);

		System.out.println("object info:" + jsonStr);
	}
}
