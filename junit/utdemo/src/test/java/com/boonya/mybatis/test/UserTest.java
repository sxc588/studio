package com.boonya.mybatis.test;

import java.io.Reader;
import java.sql.Connection;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest
{

	//private static SqlSessionFactory sqlSessionFactory;

	@BeforeClass
	public static void setUp() throws Exception
	{
		// create a SqlSessionFactory//		Reader reader = Resources.getResourceAsReader("classpath*:mybatis-config.xml");
//		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//		reader.close();
//
//		// populate in-memory database
//		SqlSession session = sqlSessionFactory.openSession();
//		Connection conn = session.getConnection();
//		reader = Resources.getResourceAsReader("classpath*:hqlbd.sql");
//		ScriptRunner runner = new ScriptRunner(conn);
//		runner.setLogWriter(null);
//		runner.runScript(reader);
//		reader.close();
//		session.close();
	}

	@Test
	public void shouldGetAUser()
	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		try
//		{
//			UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//			User user = mapper.getUser(1);
//			Assert.assertEquals("User1", user.getName());
//		}
//		finally
//		{
//			sqlSession.close();
//		}
	}

}
