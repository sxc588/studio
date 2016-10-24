package com.glen.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import com.glen.mapper.AccountMapper;
import com.glen.model.Account;

public class TestAccountService
{

	Logger logger = LoggerFactory.getLogger(TestAccountService.class);

	AccountService service = null;

	@Test
	public void initContext ()
	{
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		AccountService service = (AccountService) ctx.getBean("accountService");
		assertNotNull(service);
	}

	@Test
	public void initBeanTest()
	{
		ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		AccountService service = (AccountService) ctx.getBean("accountService");
		assertNotNull(service);
		this.service = service;
		
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		assertNotNull(dataSource);

		DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) ctx.getBean("transactionManager");
		assertNotNull(transactionManager);

		
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) ctx.getBean("sqlSessionFactory");
		assertNotNull(sqlSessionFactory);

		AccountService accountService = (AccountService) ctx.getBean("accountService");
		assertNotNull(accountService);
		
		AccountMapper accountMapper = (AccountMapper) ctx.getBean("accountMapper");
		assertNotNull(accountMapper);

		System.out.println("done --  initBeanTest");
	}
}
