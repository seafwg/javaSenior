show create database seafwg;
use seafwg;
select database();
CREATE TABLE stu
(
    ID   int,
    age  int,
    name varchar(10),
    sex  varchar(10)
);
show tables;

-- 查看数据库
show databases;
-- 查看当前使用数据库
select database();
-- 使用数据库
use seafwg;

-- CRUD:(Create,Retrieve,Update,Delete)增，查，改，删
-- 数据库基本操作SQL分类：
-- -- DDL（Data Definition Language）数据定义语言：操作数据库，数据库表，以及列
-- -- DML（Data Manipulation Language）数据库操作语言：对表进行：增，删，改
-- -- DQL（Data Query Language）数据查询语言：对表的查询[最重要]
-- -- DCL（Data Control Language）数据控制语言：定义数据库访问权限问题


-- DDL（Data Definition Language）数据定义语言，用来定数数据库对象：数据库，表，列等。
-- 关键字：create:创建,show:查看,alter:修改,drop:删除

-- 数据库操作：CRUD
-- -- C 1.创建数据库：并设置字符集: create
create database if not exists db2 character set utf8;
-- -- R 2.查询数据库：查询数据库的字符集: show
show databases;
show create database db2;
-- -- U 3.修改数据库: alter
alter database db2 character set gbk;
-- -- D 4.删除数据库: drop
drop database if exists db2;
-- -- 5.使用数据库：use,select
-- -- 查看当前使用的数据库：
select database();
-- -- 使用数据库
use db2;

-- 数据库表操作：CRUD，[前提使用一个当前数据库]
-- -- C 1.创建表：create
create table test
(
    ID     int,
    name   varchar(20),
    age    int,
    score  double(5, 2), -- 几位数，小数保留几位
    gender varchar(10)
);
-- -- R 2.查询表：show,desc
-- -- 查询当前使用的数据库的所有表
show tables;
-- -- 查询某一张表格结构
desc stu;
-- -- 查询当前使用数据库中一个表的字符集
show create table stu;
-- -- U 3.修改表结构：alter
-- -- 3.1 修改表名; rename to
alter table stu1 rename to student;
-- -- 3.2 修改表的字符集：character set 字符集编码
alter table stu
    character set gbk;
-- -- 3.3 添加新的一列：add 列名 数据类型
alter table test
    add level int;
-- -- 3.4 修改列名称，类型：
alter table test
    modify name varchar(50); -- modify修改列表名称的字符类型，无法修改字段，只修改字段名称的类型
alter table test
    change gender sex varchar(10);
-- change可以修改字段和字段类型
-- -- D 删除表：
drop table if exists stu;

# [总结] DDL操作时，删除，创建都要先判断是否存在。if not exists/if exists

-- DML（Data Manipulation Language）数据操作语言[操作对象为记录]：基本的CUD
-- -- C 1.增加一条数据：insert into
insert into test (ID, name, age, score, gender)
values (1, 'seafwg', 23, 99.00, '男');
-- -- U 2.修改数据：update
update test
set name='assassin',
    score=89
where ID = 1;
-- -- D 3.删除表中的记录：delete
delete
from test
where ID = 1;



show databases;
use seafwg;
select database();
show tables;

select *
from test;

select database();
show tables;
drop table if exists tab_category;

/*
-- 数据库设计demo:
    分析：
        ①旅游路线分类表和旅游路线是一对多的关系与多对一的关系;
        ②用户表和路线表的关系是多对多的关系；➡ 设置收藏表：用户表，路线表的主键是收藏表的外键。
*/

/*
-- 创建旅游线路分类表 tab_category
     cid 旅游线路分类主键，自动增长
     cname 旅游线路分类名称非空，唯一，字符串 100
*/
CREATE TABLE tab_category(
     cid INT PRIMARY KEY, -- 主键非空且唯一
     cname VARCHAR(100) NOT NULL UNIQUE
);

/*
-- 创建旅游线路表 tab_route
    rid 旅游线路主键，自动增长
    rname 旅游线路名称非空，唯一，字符串 100
    price 价格
    rdate 上架时间，日期类型
    cid 外键，所属分类
*/
CREATE TABLE tab_route(
  rid INT PRIMARY KEY AUTO_INCREMENT,
  rname VARCHAR(100) NOT NULL UNIQUE,
  price INT,
  rdate date,
  cid INT,
  FOREIGN KEY (cid) REFERENCES tab_category(cid) -- 外键定义：列字段定义，列定义尾部添加约束：foreign key (字段) references 其他表(字段)
);

/*
-- 创建用户表 tab_user
    uid 用户主键，自增长
    username 用户名长度 100，唯一，非空
    password 密码长度 30，非空
    name 真实姓名长度 100
    birthday 生日
    sex 性别，定长字符串 1
    telephone 手机号，字符串 11
    email 邮箱，字符串长度 100
*/
CREATE TABLE tab_user(
     uid INT PRIMARY KEY AUTO_INCREMENT,
     username VARCHAR(100) NOT NULL UNIQUE,
     password VARCHAR(30) NOT NULL,
     name VARCHAR(100),
     birthday DATETIME,
     sex VARCHAR(2),
     telephone VARCHAR(11),
     email VARCHAR(100)
);

/*
-- 创建收藏表 tab_favorite：
    分析：收藏表为
    rid 旅游线路 id，外键
    date 收藏时间
    uid 用户 id，外键
    rid 和 uid 不能重复，设置复合[联合]主键，同一个用户不能收藏同一个线路两次
*/
CREATE TABLE tab_favorite(
     rid INT,
     uid INT,
     date DATETIME,
     PRIMARY KEY (rid,uid),-- 创建联合主键
     FOREIGN KEY (rid) REFERENCES tab_route(rid),
     FOREIGN KEY (uid) REFERENCES tab_user(uid)
);
