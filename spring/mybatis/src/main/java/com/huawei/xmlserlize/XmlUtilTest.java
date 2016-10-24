package com.huawei.xmlserlize;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mysql.jdbc.log.Log;

public class XmlUtilTest
{
	
	private static Logger Log = LoggerFactory.getLogger(XmlUtilTest.class);

	@Test
	public void test()
	{
		  ClassB classB = new ClassB();
	        classB.setClassBId(22);
	        classB.setClassBName("B2");

	        ClassA classA = new ClassA();
	        classA.setClassAId(11);
	        classA.setClassAName("A1");
	        classA.setClassB(classB);

	      //  System.out.println(XmlUtil.toXML(classA));
	        Log.info(XmlUtil.toXML(classA));
	}

}
