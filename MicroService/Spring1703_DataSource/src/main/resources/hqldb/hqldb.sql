drop table users if exists;

create table t_user
(  
id integer primary key,  
name varchar(256),  
age integer  
); 

insert into t_user (id, name,age) values(1, 'User1',100);
insert into t_user (id, name,age) values(2, 'User2',200);