show create database seafwg;
use seafwg;
select database();
CREATE TABLE stu(
    ID int,
    age int,
    name varchar(10),
    sex varchar(10)
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
create table test(
    ID int,
    name varchar(20),
    age int,
    score double(5,2), -- 几位数，小数保留几位
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
alter table stu character set gbk;
-- -- 3.3 添加新的一列：add 列名 数据类型
alter table test add level int;
-- -- 3.4 修改列名称，类型：
alter table test modify name varchar(50); -- modify修改列表名称的字符类型，无法修改字段，只修改字段名称的类型
alter table test change gender sex varchar(10); -- change可以修改字段和字段类型
-- -- D 删除表：
drop table if exists stu;

# [总结] DDL操作时，删除，创建都要先判断是否存在。if not exists/if exists

-- DML（Data Manipulation Language）数据操作语言[操作对象为记录]：基本的CUD
-- -- C 1.增加一条数据：insert into
insert into test (ID,name,age,score,gender) values (1,'seafwg',23,99.00,'男');
-- -- U 2.修改数据：update
update test set name='assassin',score=89 where ID = 1;
-- -- D 3.删除表中的记录：delete
delete from test where ID=1;




show databases;
use seafwg;
select database();
show tables;

select * from test;




