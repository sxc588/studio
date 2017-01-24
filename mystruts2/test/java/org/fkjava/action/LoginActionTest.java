package org.fkjava.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:spring/spring.xml"})
public class LoginActionTest
{
	@Autowired
	ApplicationContext ctx;
	
	@Autowired
	LoginAction  loginAction;

	@Test
	public void testPrintBeans()
	{
		String[] beanNames = ctx.getBeanDefinitionNames();

		for (String name : beanNames)
		{
			System.err.println("==>" +name);
		}
	}
	
	@Test
	public void testExecute() throws Exception
	{
		System.err.println(loginAction.execute());
	}
}