package com.github.support.entitlement.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import com.github.support.entitlement.entity.User;

@WebService(targetNamespace = "http://jdk.study.hermit.org/client")
public interface UserServiceWs
{
	@WebMethod(operationName = "Insert")
	public void insert(@WebParam(name = "userId")
	String userid, @WebParam(name = "userName")
	String username, @WebParam(name = "userEmail")
	String useremail, @WebParam(name = "userAge")
	int userage);

	@WebMethod(operationName = "GetUserById")
	@WebResult(name = "result")
	public User getUserById(@WebParam(name = "userid")
	String userid);

	@WebMethod(operationName = "GetAllUsers")
	@WebResult(name = "result")
	public List<User> getAllUsers();
}