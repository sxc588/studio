package com.boonya.mybatis.test;

public interface UserMapper
{
	User getUser(Integer id);
}


//drop table users if exists;  
//02.  
//03.create table users (  
//04.  id int,  
//05.  name varchar(20)  
//06.);  
//07.  
//08.insert into users (id, name) values(1, 'User1');  
