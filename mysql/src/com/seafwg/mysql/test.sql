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

/*
-- 创建部门dept和员工表emp：
  dept:包含id-主键,name-非空，唯一
*/
-- 创建dept：
CREATE TABLE IF NOT EXISTS dept(
                                   id INT PRIMARY KEY AUTO_INCREMENT,
                                   name VARCHAR(20) NOT NULL UNIQUE
);
# INSERT INTO dept (NAME) VALUES ('开发部'),('市场部'),('财务部');
INSERT INTO dept (id,name) VALUES (1,'英雄派'),(2,'小人派'),(3,'大师派');
# INSERT INTO dept (name) VALUES ('英雄派'),('小人派'),('大师派');
show create table dept;
select * from dept;

# 创建员工表
/*
id,name,gender,salary,join_date,dept_id
*/
CREATE TABLE emp(
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(30),
                    gender VARCHAR(2),
                    salary INT,
                    join_date DATE,
                    dept_id INT,
                    FOREIGN KEY (dept_id) REFERENCES dept (id) -- 员工的外键id
);
select * from emp;
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('郭靖','男',8000,'2010-10-1',1);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('杨过','男',9000,'2030-10-1',1);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('赵志敬','男',6000,'2030-10-1',2);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('小龙女','女',80000,'2030-10-1',3);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('黄蓉','女',80000,'2020-10-1',1);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('洪七公','男',0,'2010-10-1',3);
INSERT INTO emp (name,gender,salary,join_date,dept_id) VALUES ('欧阳锋','男',18000,'2010-10-1',2);

/**
  多表查询练习：
 */
-- 笛卡尔积：select * from dept,emp;把两个表的数据以乘积的形式组合查出来，需要条件消除无用的数据
SELECT * FROM dept,emp;

-- demo:查询所有员工信息和对应部门的信息：
-- 解决笛卡尔积的造成无用的数据：
-- 1.内连接查询：
--  1.1 隐式内连接：增加条件判断where
SELECT * FROM dept,emp WHERE dept.id = emp.dept_id;
SELECT
    t2.id ID, -- 标准写法，写注释，字段的注释：
    t2.name '姓名',
    t2.gender '性别',
    t2.salary '薪资',
    t1.id '派别'
FROM
    dept t1,
    emp t2
WHERE       -- where隐式内联接：
            t1.id = t2.dept_id;
-- 1.2 显式内联接：关键字：[inner] join on
-- 语法：select 字段列 from 表名1 [inner] join 表名2 on 条件;
-- 表名1 join 表名2 on xxx;
SELECT
    t1.id '派别',
    t2.id 'ID',
    t2.name '姓名',
    t2.gender '性别',
    t2.salary '薪资'
FROM
    dept t1
        JOIN
    emp t2
    ON
            t1.id = t2.dept_id;

-- 2.外连接查询：
-- 2.1 左外连接：关键字：left join on
-- 格式：select 字段列 from 表名1 left [outer]join 表名2 on 条件;
-- 缩写：t1 left join t2 on xxx;
SELECT
    t1.id 派系,
    t2.id 员工ID,
    t2.name 员工姓名,
    t2.gender 员工性别,
    t2.salary 员工薪资,
    t2.join_date 员工加入时间
FROM
    dept t1
        RIGHT JOIN
    emp t2
    ON t1.id = t2.id;
-- 总结：查询的是左表所有数据以及其交集部分。交集：
-- 左外连接和右外连接的不同：
-- 左外连接主键不可以相同，上述中派系有相同不可以，只查出三条数据。
-- 右外连接主键也是不可以相同但是可以显示，主键相同的呈现NULL


-- 3.子查询：查询中嵌套查询：
-- demo:
-- 1 查询工资最高的员工信息
-- ①查询最高的工资是多少
SELECT MAX(salary) FROM emp;
-- ②根据这个条件查询他的信息：
SELECT * FROM emp WHERE salary = 80000;
-- ③使用一条sql数据查询：把第一条查询的结果作为第二条查询的条件
SELECT * FROM emp WHERE emp.salary = (SELECT MAX(salary) FROM emp);

-- 2 查询'英雄派'和'大师派'所有的员工信息
# SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE NAME = '财务部' OR NAME = '市场部');
SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE name = '英雄派' OR name = '大师派');
SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE name IN ('英雄派','大师派'));

-- 3 查询员工入职日期是2010-10-01日之后的员工信息和部门信息
select * from emp;
-- 普通查询：
SELECT * FROM emp t1,dept t2 WHERE t1.dept_id = t2.id AND t1.join_date > '2010-10-01';
-- 多表子查询：
SELECT * FROM dept t1 ,(SELECT * FROM emp WHERE emp.`join_date` > '2010-10-01') t2 WHERE t1.id = t2.dept_id;
-- 子查询的结果是多行多列，查询出来后作为一张虚拟的表，再次的参与查询
SELECT
    *
FROM
    dept t1,
    (SELECT * FROM emp t3 WHERE t3.join_date > '2010-10-01') t2 -- 作为一张虚拟的表再次查询
WHERE
        t1.id = t2.dept_id;
/** 总结：子查询的结果分类：
  ①子查询结果为单行单列：eg:1.查询工资最高的员工信息。子查询[工资最高]可以作为条件，使用运算符去判断。 运算符： > >= < <= =
  ②子查询结构为多行单列：eg:2.查询'英雄派'和'大师派'所有的员工信息。子查询['英雄派'和'大师派']可以作为条件，使用运算符in来判断
  ③子查询结果为多行多列：eg:3.查询员工入职日期是2010-10-01日之后的员工信息和部门信息。
                          子查询[员工入职日期是2010-10-01日之后]可以作为一张虚拟表参与查询
 */


