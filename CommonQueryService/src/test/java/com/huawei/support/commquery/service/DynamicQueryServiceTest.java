package com.huawei.support.commquery.service;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import com.huawei.support.commquery.service.DynamicQuery;
import com.huawei.support.commquery.service.DynamicQueryService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DynamicQuery.class)
// We prepare the DynamicQuery for test because the static method is normally
// not mockable
public class DynamicQueryServiceTest
{
	// 数据库的连接驱动，一般是不需要变的
	String driver = "com.mysql.jdbc.Driver";
	// 数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
	String URL = "jdbc:mysql://localhost:3306/test";
	// 登录账户
	String username = "root";
	// 登录的密码
	String password = "root";
	String sql = "select count(*) as cnt  from account where 1=1";
	String sql2 = "select count(*) as cnt  from account where 1=1 offset 0 limit 10";

	@Test
	public void testExecuteQuery() throws SQLException
	{
		List<Map<String, String>> expectedValue = new ArrayList<Map<String, String>>();

		// PowerMockito.mockStatic(PropertyApplicationContext.class);// 3
		// PowerMockito.mockStatic(WebChatUtil.class);

		PowerMockito.mockStatic(DynamicQuery.class);
		/*
		 * Setup the expectation using the standard Mockito syntax,
		 * generateNewId() will now return 2 everytime it's invoked in this
		 * test.
		 */
		PowerMockito.when(DynamicQuery.executeQuery(driver, URL, username, password, sql2)).thenReturn(expectedValue);

		List<Map<String, String>> actualValue = DynamicQueryService.executeQuery(driver, URL, username, password, sql,
				0, 10);

		// Optionally verify that the static method was actually called
		PowerMockito.verifyStatic();

		assertEquals(expectedValue, actualValue);
	}

}
