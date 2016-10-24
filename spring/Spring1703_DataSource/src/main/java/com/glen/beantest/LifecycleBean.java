package com.glen.beantest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


//<bean id="lifeCycleBean" class="org.xrq.bean.lifecycle.LifecycleBean">
//<property name="lifeCycleBeanName" value="lifeCycleBean" />
//</bean>
public class LifecycleBean implements InitializingBean, DisposableBean
{
	  @SuppressWarnings("unused")
	    private String    lifeCycleBeanName;
	    
	    public void setLifeCycleBeanName(String lifeCycleBeanName)
	    {
	        System.out.println("Enter LifecycleBean.setLifeCycleBeanName(), lifeCycleBeanName = " + lifeCycleBeanName);
	        this.lifeCycleBeanName = lifeCycleBeanName;
	    }

	    @Override
	    public void destroy() throws Exception
	    {
	        System.out.println("Enter LifecycleBean.destroy()");
	    }

	    @Override
	    public void afterPropertiesSet() throws Exception
	    {
	        System.out.println("Enter LifecycleBean.afterPropertiesSet()");
	    }
	    
	    public void beanStart()
	    {
	        System.out.println("Enter LifecycleBean.beanStart()");
	    }
	    
	    public void beanEnd()
	    {
	        System.out.println("Enter LifecycleBean.beanEnd()");
	    }
}
