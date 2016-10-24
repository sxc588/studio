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
import com.glen.model.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
@TransactionConfiguration(transactionManager="transactionManager") 
@Transactional  
public class TestAccountService03
{
	@Autowired
	ApplicationContext ctx;

	@Autowired
	AccountService accountService;

	Logger logger = LoggerFactory.getLogger(TestAccountService03.class);

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
//	@Rollback(true) 
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
	
	
	@Test
//	@Rollback(true) 
	public void getAllAccount()
	{

		List<Account>  lst = accountService.getAllAccount();
		
		
		for (Account account :lst)
		{
			System.out.println("|--"  + account.toString());
		}

	}
	
	
	
	@Test
//	@Rollback(true) 
	public void batchAdd()
	{

		
		
	Account lisi = new Account();
		
	lisi.setAccountId(new Random().nextInt(999999));
		lisi.setUsername("李四");
		lisi.setPassword("lisi");
		lisi.setCreateTime(new Date());

		Account wangwu = new Account();
		wangwu.setAccountId(new Random().nextInt(999999));
		wangwu.setUsername("王五");
		wangwu.setPassword("wangwu");
		wangwu.setCreateTime(new Date());

		List<Account>  lst = new ArrayList<Account>();
		lst.add(lisi);
		lst.add(wangwu);
		Integer a= accountService.batchAdd(lst);

		assertEquals(new Integer(2),a);
	
	}

}
