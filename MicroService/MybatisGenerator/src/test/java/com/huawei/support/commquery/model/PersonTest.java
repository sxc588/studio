package com.huawei.support.commquery.model;

import org.junit.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.support.commquery.model.Person;

public class PersonTest
{

	@Test
	public void writeJson() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		Person case1 = new Person();
		case1.setName("zhangsan ");

		case1.setSex("male");
		case1.setAge(13);
		case1.setId(13000);

		String jsonStr = mapper.writeValueAsString(case1);

		System.out.println("JSON:" + jsonStr);
	}

}
