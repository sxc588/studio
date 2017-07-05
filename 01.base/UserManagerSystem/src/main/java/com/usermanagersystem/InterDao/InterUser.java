package com.usermanagersystem.InterDao;

import java.util.List;

import com.usermanagersystem.entity.User;

public interface InterUser 
{
	int addUser(User user);//管理员/用户-->注册
	boolean login(User user);//管理员/用户-->登录
	User selectUserInfo(int id);//查找个人信息
	List findAllUsers();//管理员/用户  --> 查看所有用户
    List findNewUsers();//管理员查看新增用户
    int modifyUserInfo(User user);//管理员修改用户信息
    int deleteUser(int id);//管理员删除用户
    List findAllAdmins();//管理员查看所有管理员信息
    int addAdmin(User user);//管理员-->添加管理员
    //int modifyAdmin(User user);//管理员-->修改管理员信息
   // int deleteAdmin(int id);//管理员-->删除管理员
    int getUserid(String username,String password);
    int getUserroleId(int id);
    boolean isExistUsername(String username);
    
}
