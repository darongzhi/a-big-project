create database gym;
use gym;

create table admins(
   id int primary key auto_increment,
   username varchar(50) not null,
   password varchar(50) not null
)default charset='utf8';
insert into admins(username,password) values('admin','123456');

create table member(
   id int primary key auto_increment,
   name varchar(20) not null,
   sex int not null default 0 comment'0男 1女',
   age int not null,
   phone varchar(20) not null,
   email varchar(30) not null,
   address varchar(30),
   starts date 
)default charset='utf8';
insert into member(name,sex,age,phone,email,address,starts) values('李明',1,23,'13879562352','18546555@qq.com','江西','2019-10-9');
insert into member(name,sex,age,phone,email,address,starts) values('王芳',0,23,'13454545451','18546666@qq.com','云南','2019-10-9');
insert into member(name,sex,age,phone,email,address,starts) values('张三',1,23,'13123454224','18546111@qq.com','四川','2019-10-9');

create table equipment(
    id int primary key auto_increment,
	name varchar(20) not null,
	states varchar(10) not null
)default charset='utf8';
insert into equipment(name,states) values('跑步机','正常');
insert into equipment(name,states) values('哑铃','正常');
insert into equipment(name,states) values('划船机','正常');

create table coach(
    id int primary key auto_increment,
	name varchar(20) not null,
	sex int not null default 0 comment'0男 1女',
	age int not null,
	phone varchar(20) not null,
	teach varchar(20) not null
)default charset='utf8';
insert into coach(name,sex,age,phone,teach) values('李关元',1,28,'13562563245','有氧搏击');
insert into coach(name,sex,age,phone,teach) values('张亮亮',1,29,'13562444444','哑铃项目');
insert into coach(name,sex,age,phone,teach) values('王立方',1,31,'13562333332','杠铃项目');