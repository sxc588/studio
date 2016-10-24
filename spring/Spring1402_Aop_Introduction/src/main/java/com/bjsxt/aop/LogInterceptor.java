package com.bjsxt.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


/**
 * 实现动态代理：
 *  --方法1：jdk proxy （必须实现了某个个接口）
 *  --方法2：实现InvocationHandler
 * http://wwyu8901.iteye.com/blog/846919
 *
 */
public class LogInterceptor implements InvocationHandler
{
	public void beforMethod(Method m){
		System.out.println("beforMethod->" +m.getName() + " start.");
	}
	
	public void endMethod(Method m){
		System.out.println("endMethod->" +m.getName() + " end.");
	}
	
	 private Object target;
	 public LogInterceptor(Object target){
		 
	  //①target为目标的业务类
	  this.target = target;
	 }
	 
	 
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		beforMethod(method);
		Object obj = method.invoke(target, args);//②通过反射方法调用目标业务类的业务方法
		endMethod(method);
		return obj;
	}

}
