drop database if exists db_luntan;
create database db_luntan;
use db_luntan;
#��bbs
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
#��bbsAnswer
create table tb_bbsAnswer(
bbsAnswer_id int not null primary key,
bbsAnswer_rootID int,
bbsAnswer_title varchar(70),
bbsAnswer_content varchar(2000),
bbsAnswer_sender varchar(20),
bbsAnswer_sendTime datetime,
bbsAnswer_face varchar(10)
)engine=InnoDB default charset=gb2312;
#��board
create table tb_board(
board_id int not null primary key,
board_classID smallint,
board_name varchar(40),
board_master varchar(20),
board_pcard varchar(200)
)engine=InnoDB default charset=gb2312;
#��class
create table tb_class(
class_id smallint not null primary key,
class_name varchar(40),
class_intro varchar(200)
)engine=InnoDB default charset=gb2312;
#��user
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




#��bbs

insert into tb_bbs values(1,1,"java�����е����㹹��?","���ʸ�λ����Java���������㹹��ָ���ǣ�","cy","2009-10-31 10:31:10","face3.gif","2009-10-31 10:31:10",0,"2009-11-2 11:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(2,1,"�쳣����?","���ʣ���Java����ν���쳣���⣿��лл����","cy","2009-10-30 11:31:10","face11.gif","2009-10-31 12:31:10",0,"2009-11-2 14:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(3,1,"����JSP����ͨ��ʹ����Щ��ܣ�","���ʣ�����JSP����Ƚϳ��ú����еĿ����������Щ����","�߷�","2009-11-2 8:37:15","face3.gif","2009-11-3 12:31:10",1,"2009-11-3 12:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(4,2,"what are you","what what����","����","2009-11-2 8:37:15","face0.gif","2009-11-4 12:31:10",0,"2009-11-5 12:36:09",1,"1999-1-1 0:00:00");
insert into tb_bbs values(5,19,"��ʱ�ش��������","�������ʲô����������ʿ���ʱ�����Ӹ��ң��һἰʱ�����ظ���","����","2009-11-2 8:37:15","face0.gif","2009-11-5 12:31:10",1,"2009-11-5 12:36:09",0,"1999-1-1 0:00:00");
insert into tb_bbs values(6,1,"��ʱ�ش��������","�������ʲô����������ʿ���ʱ�����Ӹ��ң��һἰʱ�����ظ���","cy","2009-11-3 8:37:15","face0.gif","2009-11-3 12:31:10",1,"2009-11-4 12:36:09",0,"1999-1-1 0:00:00");

#��bbsAnswer

insert into tb_bbsAnswer values(6,2,"yrtyyrtyrty","<font color=blue>ytryrtytrytrytr</font>",0,"2009-11-1 12:09:30","face0.gif");

#��board

insert into tb_board values(1,1,"JSP����","�߷�","��ӭ���� WEB����/JSP���� ���棡");
insert into tb_board values(2,1,"PHP����","cy","��ӭ���� WEB����/PHP���� ���棡");
insert into tb_board values(3,1,"Ajax����","cy","��ӭ���� WEB����/Ajax���� ���棡");
insert into tb_board values(4,2,"Oracle����","cy","��ӭ���� ���ݿ⿪��/Oracle���� ���棡��");
insert into tb_board values(5,2,"����","cy","��ӭ���� ���ݿ⿪��/�������棡");
insert into tb_board values(6,3,"Java����","�߷�","��ӭ���� �������/Java���� ���棡");
insert into tb_board values(7,3,".NET����","cy","��ӭ���� �������/.NET���� ���棡");
insert into tb_board values(8,1,".NET/ASP����","�߷�","��ӭ���� .NET/ASP���� ���棡");
insert into tb_board values(9,3,"VB����","cy","��ӭ���� �������/VB���� ���棡");
insert into tb_board values(10,3,"C/C++����","cy","��ӭ���� �������/C/C++���� ���棡");
insert into tb_board values(11,3,"����","cy","��ӭ���� �������/���� ���棡");
insert into tb_board values(12,4,"�������","wl","��ӭ���� Ӳ������/������� ���棡");
insert into tb_board values(13,4,"��Ƭ��","cy","��ӭ���� Ӳ������/��Ƭ�� ���棡");
insert into tb_board values(14,4,"Ӳ�����","cy","��ӭ���� Ӳ������/Ӳ����� ���棡");
insert into tb_board values(15,4,"����","cy","��ӭ���� Ӳ������/���� ���棡");
insert into tb_board values(16,1,"����","cy","��ӭ���� WEB����/���� ���棡");
insert into tb_board values(17,2,"MS-SQL Server����","��Ծ��","��ӭ���� ���ݿ⿪��/MS-SQL Server���� ���棡");
insert into tb_board values(18,2,"PowerBuilder����","��Ծ��","��ӭ���� ���ݿ⿪��/PowerBuilder���� ���棡");
insert into tb_board values(19,5,"�ʺ�","����","�벻Ҫ��д����");
insert into tb_board values(20,5,"�ػ�","����","д�����ף��");


#��class

insert into tb_class values(1,"WEB����","��ӭ���롰WEB���������磬���ཻ��������ѧϰ��");
insert into tb_class values(2,"���ݿ⿪��","��ӭ���롰���ݿ⿪�������磬���ཻ��������ѧϰ��");
insert into tb_class values(3,"�������","��ӭ���롰������������磬���ཻ��������ѧϰ��");
insert into tb_class values(4,"Ӳ������","��ӭ���롰Ӳ�����������磬���ཻ��������ѧϰ��");
insert into tb_class values(5,"�ذ�","��ӭ���ķ��ʣ�");


#��user


insert into tb_user values(1,"cy","123","user11.gif","Ů","135****1102","10500646A","cy@***.com.cn","����ʡ֣����",2);
insert into tb_user values(2,"��Ծ��","123","user4.gif","Ů","137****3309","10500646A","cy@***.com.cn","����ʡ֣����",1);
insert into tb_user values(3,"����","123","user15.gif","��","155****1108","10500646A","cy@***.com.cn","����ʡ֣����",1);
insert into tb_user values(4,"����","123","user18.gif","��","134****4783","10500646A","cy@***.com.cn","����ʡ֣����",1);
insert into tb_user values(5,"�߷�","123","user5.gif","Ů","136****4534","10500646A","cy@***.com.cn","����ʡ֣����",1);
insert into tb_user values(6,"����","123","user6.gif","Ů","150****4768","123456","86@88.com.cn","����ʡ������",1);




















