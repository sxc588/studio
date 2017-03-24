package com.github.support.cbb.utils.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Base64;

// java base64编码和解码
// 第一种方式：
// 通过反射使用java 中不对外公开的类：
public class Base64Util
{

	/***
	 * encode by Base64
	 */
	public static String encodeBase64(byte[] input) throws Exception
	{
		Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("encode", byte[].class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, new Object[]{input});
		return (String) retObj;
	}

	/***
	 * decode by Base64
	 */
	public static byte[] decodeBase64(String input) throws Exception
	{
		Class clazz = Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");
		Method mainMethod = clazz.getMethod("decode", String.class);
		mainMethod.setAccessible(true);
		Object retObj = mainMethod.invoke(null, input);
		return (byte[]) retObj;
	}

	// 第二种方式：
	// 使用commons-codec.jar

	/**
	 * @param bytes
	 * @return
	 */
	public static byte[] decode(final byte[] bytes)
	{
		return Base64.getDecoder().decode(bytes);
	}

	/**
	 * 二进制数据编码为BASE64字符串
	 * 
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(final byte[] bytes)
	{
		return new String(Base64.getEncoder().encode(bytes));
	}

	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode3(byte[] bstr)
	{
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static byte[] decode3(String str)
	{
		byte[] bt = null;
		try
		{
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		return bt;
	}

}
