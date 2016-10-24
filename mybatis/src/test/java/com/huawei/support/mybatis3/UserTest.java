package com.huawei.support.mybatis3;

import java.io.InputStream;
import java.io.InputStreamReader;
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

import com.boonya.mybatis.test.User;
import com.boonya.mybatis.test.UserMapper;  
  
public class UserTest  
{  
  
    private static SqlSessionFactory sqlSessionFactory;  
  
    @BeforeClass  
    public static void setUp() throws Exception  
    {  
        // create a SqlSessionFactory
        Reader reader = Resources.getResourceAsReader("config/mybatis-config.xml"); 
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);  
        reader.close();  
  
        // populate in-memory database  
        SqlSession session = sqlSessionFactory.openSession();  
        Connection conn = session.getConnection();  
    	InputStream in = Resources.getResourceAsStream("config/hqldb.sql");
        reader = new InputStreamReader(in);  
        ScriptRunner runner = new ScriptRunner(conn);  
        runner.setLogWriter(null);  
        runner.runScript(reader);  
        reader.close();  
        session.close();  
    }  
  
    @Test  
    public void shouldGetAUser()  
    {  
        SqlSession sqlSession = sqlSessionFactory.openSession();  
        try  
        {  
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);  
            User user = mapper.getUser(1);  
            Assert.assertEquals("User1", user.getName());
            System.out.println(user.getName());
        } finally  
        {  
            sqlSession.close();  
        }  
    }  
  
}  
