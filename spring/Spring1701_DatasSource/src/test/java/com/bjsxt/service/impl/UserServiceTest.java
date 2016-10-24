package com.bjsxt.service.impl;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import javax.sql.DataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.bjsxt.model.User;
import com.bjsxt.service.UserService;

/**
 * 1.权限， 2.日志效率检查 3.事务，try-异常管理 3.随时可去 4.spring 实现 jdk 动态代理 概念：JoinPoint
 * PointCut aspect
 * 
 * 数据库连接池：1。c3p0 2.dbcp 3.proxxool
 */
public class UserServiceTest
{
	static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void setUp() throws Exception
	{

		ctx = new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");

		DataSource dataSource = (DataSource) UserServiceTest.getCtx().getBean("dataSource");

		// populate in-memory database
		Connection conn = dataSource.getConnection();
		InputStream in = Resources.getResourceAsStream("hqldb/hqldb.sql");
		Reader reader = new InputStreamReader(in);
		ScriptRunner runner = new ScriptRunner(conn);
		runner.setLogWriter(null);
		runner.runScript(reader);
		reader.close();
	}

	private static ClassPathXmlApplicationContext getCtx()
	{
		return ctx;
	}

	private static <T> T getBean(Class<T> tclass)
	{
		return ctx.getBean(tclass);
	}

	@Test
	public void testSave()
	{
		UserService service = UserServiceTest.getBean(UserServiceImpl.class);
		User user = new User();
		service.save(user);
	}
}
