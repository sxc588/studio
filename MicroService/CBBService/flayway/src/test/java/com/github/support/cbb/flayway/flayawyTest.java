package com.github.support.cbb.flayway;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{"classpath:spring/cbb-flayway-spring-test.xml"})
public class flayawyTest
{

	@Autowired
	ApplicationContext ctx;

	@Test
	public void testPrintBeans()
	{
		String[] beanNames = ctx.getBeanDefinitionNames();

		for (String name : beanNames)
		{
			System.err.println("----" +name);
		}

	}

}
