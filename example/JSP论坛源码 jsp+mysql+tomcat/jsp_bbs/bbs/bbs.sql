drop database if exists db_luntan;
create database db_luntan;
use db_luntan;
#表bbs
create table tb_bbs(
bbs_id int not null auto_increment primary key,
bbs_boardID int not null,
bbs_title varchar(70),
bbs_content varchar(2000),
bbs_sender varchar(20),
bbs_sendTime datetime,
bbs_face varchar(10),
bbs_opTime datetime,
bbs_isTop varchar(1),
bbs_toTopTime datetime,
bbs_isGood varchar(1),
bbs_toGoodTime datetime
)engine=InnoDB default charset=gb2312;
#表bbsAnswer
create table tb_bbsAnswer(
bbsAnswer_id int not null primary key,
bbsAnswer_rootID int,
bbsAnswer_title varchar(70),
bbsAnswer_content varchar(2000),
bbsAnswer_sender varchar(20),
bbsAnswer_sendTime datetime,
bbsAnswer_face varchar(10)
)engine=InnoDB default charset=gb2312;
#表board
create table tb_board(
board_id int not null primary key,
board_classID smallint,
board_name varchar(40),
board_master varchar(20),
board_pcard varchar(200)
)engine=InnoDB default charset=gb2312;
#表class
create table tb_class(
class_id smallint not null primary key,
class_name varchar(40),
class_intro varchar(200)
)engine=InnoDB default charset=gb2312;
#表user
create table tb_user(
id smallint not null auto_increment primary key,
user_name varchar(20),
user_password varchar(20),
user_face varchar(11),
user_sex varchar(2),
user_phone varchar(12),
user_OICQ varchar(14),
user_email varchar(100),
user_from varchar(200),
user_able varchar(1)
)engine=InnoDB default charset=gb2312;




#表bbs

insert into tb_bbs values(1,1,"java开发中的三层构架?","请问各位，在Java开发中三层构架指的是？","cy","2009-10-31 10:31:10","face3.gif","2009-10-31 10:31:10",0,"2009-11-2 11:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(2,1,"异常问题?","请问，在Java中如何解决异常问题？？谢谢！！","cy","2009-10-30 11:31:10","face11.gif","2009-10-31 12:31:10",0,"2009-11-2 14:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(3,1,"开发JSP程序通常使用哪些框架？","请问，开发JSP程序比较常用和流行的开发框架有哪些？？","高飞","2009-11-2 8:37:15","face3.gif","2009-11-3 12:31:10",1,"2009-11-3 12:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(4,2,"what are you","what what？？","王勇","2009-11-2 8:37:15","face0.gif","2009-11-4 12:31:10",0,"2009-11-5 12:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(5,19,"随时回答你的问题","如果你有什么问题或者疑问可随时发帖子给我，我会及时给您回复．","王勇","2009-11-2 8:37:15","face0.gif","2009-11-5 12:31:10",1,"2009-11-5 12:36:09",0,"1999-1-1 0:00:00");
insert into tb_bbs values(6,1,"随时回答你的问题","如果你有什么问题或者疑问可随时发帖子给我，我会及时给您回复．","cy","2009-11-3 8:37:15","face0.gif","2009-11-3 12:31:10",1,"2009-11-4 12:36:09",0,"1999-1-1 0:00:00");

#表bbsAnswer

insert into tb_bbsAnswer values(6,2,"yrtyyrtyrty","<font color=blue>ytryrtytrytrytr</font>",0,"2009-11-1 12:09:30","face0.gif");

#表board

insert into tb_board values(1,1,"JSP开发","高飞","欢迎进入 WEB开发/JSP开发 版面！");
insert into tb_board values(2,1,"PHP开发","cy","欢迎进入 WEB开发/PHP开发 版面！");
insert into tb_board values(3,1,"Ajax技术","cy","欢迎进入 WEB开发/Ajax技术 版面！");
insert into tb_board values(4,2,"Oracle开发","cy","欢迎进入 数据库开发/Oracle开发 版面！！");
insert into tb_board values(5,2,"其他","cy","欢迎进入 数据库开发/其他版面！");
insert into tb_board values(6,3,"Java技术","高飞","欢迎进入 软件开发/Java技术 版面！");
insert into tb_board values(7,3,".NET技术","cy","欢迎进入 软件开发/.NET技术 版面！");
insert into tb_board values(8,1,".NET/ASP开发","高飞","欢迎进入 .NET/ASP开发 版面！");
insert into tb_board values(9,3,"VB技术","cy","欢迎进入 软件开发/VB技术 版面！");
insert into tb_board values(10,3,"C/C++技术","cy","欢迎进入 软件开发/C/C++技术 版面！");
insert into tb_board values(11,3,"其他","cy","欢迎进入 软件开发/其他 版面！");
insert into tb_board values(12,4,"汇编语言","wl","欢迎进入 硬件开发/汇编语言 版面！");
insert into tb_board values(13,4,"单片机","cy","欢迎进入 硬件开发/单片机 版面！");
insert into tb_board values(14,4,"硬件设计","cy","欢迎进入 硬件开发/硬件设计 版面！");
insert into tb_board values(15,4,"其他","cy","欢迎进入 硬件开发/其他 版面！");
insert into tb_board values(16,1,"其他","cy","欢迎进入 WEB开发/其他 版面！");
insert into tb_board values(17,2,"MS-SQL Server开发","姜跃华","欢迎进入 数据库开发/MS-SQL Server开发 版面！");
insert into tb_board values(18,2,"PowerBuilder开发","姜跃华","欢迎进入 数据库开发/PowerBuilder开发 版面！");
insert into tb_board values(19,5,"问候","王勇","请不要乱写内容");
insert into tb_board values(20,5,"关怀","王勇","写下你的祝福");


#表class

insert into tb_class values(1,"WEB开发","欢迎进入“WEB开发”世界，互相交流、互相学习！");
insert into tb_class values(2,"数据库开发","欢迎进入“数据库开发”世界，互相交流、互相学习！");
insert into tb_class values(3,"软件开发","欢迎进入“软件开发”世界，互相交流、互相学习！");
insert into tb_class values(4,"硬件开发","欢迎进入“硬件开发”世界，互相交流、互相学习！");
insert into tb_class values(5,"关爱","欢迎您的访问！");


#表user


insert into tb_user values(1,"cy","123","user11.gif","女","135****1102","10500646A","cy@***.com.cn","河南省郑州市",2);
insert into tb_user values(2,"姜跃华","123","user4.gif","女","137****3309","10500646A","cy@***.com.cn","河南省郑州市",1);
insert into tb_user values(3,"李阳","123","user15.gif","男","155****1108","10500646A","cy@***.com.cn","河南省郑州市",1);
insert into tb_user values(4,"王勇","123","user18.gif","男","134****4783","10500646A","cy@***.com.cn","河南省郑州市",1);
insert into tb_user values(5,"高飞","123","user5.gif","女","136****4534","10500646A","cy@***.com.cn","河南省郑州市",1);
insert into tb_user values(6,"王丽","123","user6.gif","女","150****4768","123456","86@88.com.cn","河南省洛阳市",1);




















