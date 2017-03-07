package com.github.support.demo;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import com.github.support.entitlement.entity.User;

@WebService(serviceName = "HelloWorld", targetNamespace = DemoConstants.WS_NAMESPACE)
public interface HelloWorld
{
	@WebMethod
	public String say(@WebParam(name = "name")
	String name);

	@WebMethod
	public String sayHello(@WebParam(name = "user")
	User user);

	@WebMethod
	public List<User> getList(Long id);
}
