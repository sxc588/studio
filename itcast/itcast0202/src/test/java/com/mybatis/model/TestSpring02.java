package com.mybatis.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mybatis.service.UserService;

public class TestSpring02
{

	@Test
	public void test()
	{
		        //通过spring.xml配置文件创建Spring的应用程序上下文环境
		ClassPathXmlApplicationContext  ac = new ClassPathXmlApplicationContext("classpath:/spring/spring.xml");
		        //从Spring的IOC容器中获取bean对象
		        UserService userService = (UserService) ac.getBean("userService");
		        //执行测试方法
		        int acture = userService.test();
		        assertEquals(123,acture);
		        ac.close();

	}
}
