package com.github.support.cbb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 使用Jackson进行Java对象与JSON的互相转换
 * @author Administrator
 *
 */
public abstract class JSONUtil
{
	private static ObjectMapper mapper = new ObjectMapper();

	// Convert object to JSON string
	public static String toJson(Object obj) throws JsonProcessingException
	{
		String Json = mapper.writeValueAsString(obj);
		return Json;
	}

	// Convert object to JSON string
	public static <T> T fromJson(String json, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException
	{
		@SuppressWarnings("unchecked")
		T bj2 = (T) mapper.readValue(json, Class.class);
		return bj2;
	}
	//
	public static <T> List<T> toMap(String json, Class<T> type) throws JsonParseException, JsonMappingException, IOException
	{
		JavaType javaType = getCollectionType(HashMap.class, type);
		@SuppressWarnings("unchecked")
		List<T> lst = (List<T>) mapper.readValue(json, javaType);
		return lst;
	}

	public static <T> List<T> toList(String json, Class<T> type) throws JsonParseException, JsonMappingException, IOException
	{
		JavaType javaType = getCollectionType(ArrayList.class, type);
		@SuppressWarnings("unchecked")
		List<T> lst = (List<T>) mapper.readValue(json, javaType);
		return lst;
	}

	/**
	 * 获取泛型的Collection Type
	 * 
	 * @param collectionClass
	 *            泛型的Collection
	 * @param elementClasses
	 *            元素类
	 * @return JavaType Java类型
	 * @since 1.0
	 */
	private static JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses)
	{
		return mapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
	}

	// Convert object to JSON string
	// public static <T> T fromJson (String json,Class<T> valueType )
	// {

	// Convert object to JSON string
	// T bj2 = (T) mapper.readValue(json, Class.class);
	// System.out.println(bj2);
	// System.out.println("Change Object to JSON String: " + bj2);
	// return bj2;
	// }

	// Convert Json string to Object
	// Student student2 = mapper.readValue(Json, Student.class);
	// System.out.println(student2);
	//
	// // Create a student list add it to Bj
	// Student student3 = new Student();
	// student3.setId(5117);
	// student3.setName("saiya");
	// student3.setBirthDay(new Date());
	//
	// List<Student> stuList = new ArrayList<Student>();
	// stuList.add(student1);
	// stuList.add(student3);
	//
	// Class bj = new Class();
	// bj.setCname("五年二班");
	// bj.setMembers(stuList);
	//
	// String json2 = mapper.writeValueAsString(bj);
	// System.out.println("The JSON from Class is: " + json2);
	//
	// Class bj2 = mapper.readValue(json2, Class.class);
	// System.out.println(bj2);

}
