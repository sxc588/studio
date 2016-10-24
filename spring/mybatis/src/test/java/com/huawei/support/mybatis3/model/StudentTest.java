package com.huawei.support.mybatis3.model;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

@SuppressWarnings("restriction")
public class StudentTest
{

	@Test
	public void test() throws JAXBException
	{

		JAXBContext context = JAXBContext.newInstance(Student.class);

		Marshaller marshaller = context.createMarshaller();
		// Unmarshaller unmarshaller = context.createUnmarshaller();

		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

		Student stu = new Student("defautlName", 10);
		stu.setId(1);
		marshaller.marshal(stu, System.out);
		System.out.println();

		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息

		// String xml = "<SystemConfig><name>David</name></SystemConfig>";
		// SystemConfig boy2 = (SystemConfig) unmarshaller.unmarshal(new
		// StringReader(xml));
		// System.out.println(boy2.getName());
	}

	public static String toXML(Object obj)
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance(obj.getClass());

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //编码格式
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// 是否格式化生成的xml串
			marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// 是否省略xm头声明信息
			StringWriter writer = new StringWriter();
			marshaller.marshal(obj, writer);
			return writer.toString();
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T fromXML(String xml, Class<T> valueType)
	{
		try
		{
			JAXBContext context = JAXBContext.newInstance(valueType);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (T) unmarshaller.unmarshal(new StringReader(xml));
		} catch (Exception e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
}
