package com.usermanagersystem.Interceptor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.usermanagersystem.actions.AddAdminAction;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;
import com.usermanagersystem.entity.User;

public class GetAllUserInterceptor extends AbstractInterceptor
{

	private static Logger loger = LoggerFactory.getLogger(AddAdminAction.class);
	
	
	/**
	 * 用户登录前初始化数据
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception
	{
		
		loger.info("GetAllUserInterceptor>>intercept");
		
		// TODO Auto-generated method stub
		UserMapper interUser = new UserDao();
		List<User> alluserList = interUser.findAllUsers();	// 查询所有用户信息
		List<User> alladminList = interUser.findAllAdmins();	// 查询所有普通管理员信息

		invocation.getInvocationContext().getSession().put("alladminList", alladminList);
		invocation.getInvocationContext().getSession().put("alluserList", alluserList); // 把查询到的数据放入session
		return invocation.invoke();
	}

}
