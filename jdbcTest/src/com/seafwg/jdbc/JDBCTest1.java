package com.seafwg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JDBC:
 * JDBC:Java DataBase Connectivity Java数据库连接[java语言操作数据库]
 * JDBC的本质: 官方定义的一套Java操作所有关系型数据库的规则，即接口。各个数据库公司实现这套接口，提供数据库驱动jar包。
 *            我们可以使用这套接口[JDBC]编程，真正执行的代码是驱动jar包中的实现类。典型的多态性。
 *
 * TODO
 *
 * 步骤：
 * 		1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
 * 			1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
 * 			2.右键-->Add As Library
 * 		2. 注册驱动
 * 		3. 通过DriverManager的getConnection方法,获取数据库连接对象
 * 		4. 定义sql
 * 		5. 通过数据库连接对象.createStatement()获取Statement对象，获取执行sql语句的对象 Statement
 * 		6. 执行sql，接受返回结果
 * 		7. 处理结果
 * 		8. 释放资源
 **/
public class JDBCTest1 {
    public static void main(String[] args) throws Exception {
        //①导入jar包
        //②注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //③获取数据库连接对象
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seafwg", "root", "root");
        //④定义sql
        String strSQL = "insert into test (ID,name,age,score,gender) values (4,'seafwg4',23,99.00,'男');";
        //⑤获取sql执行对象 Statement
        Statement state = con.createStatement();
        //⑥执行sql
        boolean exe = state.execute(strSQL);
        //⑦处理结果
        System.out.println(exe);
        //⑧关闭资源
        state.close();
        con.close();
    }
}
/** 总结：
 * 注册驱动➡获取数据库连接对象➡获取执行sql对象➡定义sql➡执行sql返回结果➡处理结果➡释放资源
 *
 */