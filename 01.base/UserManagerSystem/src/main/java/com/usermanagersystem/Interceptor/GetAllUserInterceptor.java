package com.usermanagersystem.Interceptor;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;

public class GetAllUserInterceptor extends AbstractInterceptor {

	/**
	 * 用户登录前初始化数据
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		InterUser interUser=new ImplUser();
		List alluserList=interUser.findAllUsers();//查询所有用户信息
		List alladminList=interUser.findAllAdmins();//查询所有普通管理员信息
		
		invocation.getInvocationContext().getSession().put("alladminList",alladminList);
		invocation.getInvocationContext().getSession().put("alluserList",alluserList);//把查询到的数据放入session
		return invocation.invoke();
	}

}
