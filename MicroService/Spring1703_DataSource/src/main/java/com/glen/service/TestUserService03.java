package com.glen.service;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import sun.print.resources.serviceui;
import com.glen.mapper.AccountMapper;
import com.glen.mapper.UserMapper;
import com.glen.model.Account;
import com.glen.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@TransactionConfiguration(transactionManager="transactionManager") 
//@Transactional  
public class TestUserService03
{
	@Autowired
	ApplicationContext ctx;

	@Autowired
	private UserMapper userMapper;


	Logger logger = LoggerFactory.getLogger(TestUserService03.class);

	@Test
	public void initBeanTest()
	{
		System.err.println(ctx.getApplicationName());
		
		String[] beans = ctx.getBeanDefinitionNames();
		
		for (String bean :beans)
		{
			System.out.println("|--"  + bean);
		}
		
	}
	
	@Test
    @Transactional(rollbackFor={RuntimeException.class, Exception.class})
	public void addTest()
	{
		User user = new User();
		user.setName("张三");
		user.setAge(16);

		Integer id = userMapper.add(user);
		user.setId(id);
		assertNotNull(id);
		System.out.println("done --  addTest");
	}
	
	
	

}
