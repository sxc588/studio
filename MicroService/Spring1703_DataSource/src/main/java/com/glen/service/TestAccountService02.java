package com.glen.service;

import static org.junit.Assert.assertNotNull;
import java.util.Date;
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
import com.glen.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@TransactionConfiguration(transactionManager="transactionManager") 
@Transactional  
public class TestAccountService02
{
	@Autowired
	ApplicationContext ctx;

	@Autowired
	AccountService accountService;

	Logger logger = LoggerFactory.getLogger(TestAccountService02.class);

	@Test
	public void initBeanTest()
	{
		AccountService service = (AccountService) ctx.getBean("accountService");
		assertNotNull(service);

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
	
	@Test
	@Rollback(true) 
	public void addTest()
	{
		
		Account account = new Account();
		
		account.setAccountId(new Random().nextInt(999999));
		account.setUsername("张三");
		account.setPassword("zhangsang");
		account.setCreateTime(new Date());

		Integer id = accountService.add(account);
		assertNotNull(id);

		System.out.println("done --  addTest");
	}

}
