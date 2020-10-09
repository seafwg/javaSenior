package com.seafwg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: jdbc test
 * TODO
 * emp表中添加一条记录 insert 语句
 *  * 		1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
 *  * 			1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
 *  * 			2.右键-->Add As Library
 *  * 		2. 注册驱动
 *  * 		3. 通过DriverManager的getConnection方法,获取数据库连接对象
 *  * 		4. 定义sql
 *  * 		5. 通过数据库连接对象.createStatement()获取Statement对象，获取执行sql语句的对象 Statement
 *  * 		6. 执行sql，接受返回结果
 *  * 		7. 处理结果
 *  * 		8. 释放资源
 **/
public class JDBCTest2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            //①导入jar包
            //②注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //③获取连接对象
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/seafwg", "root", "root");
            //④定义sql
            String sqlStr = "insert into emp values(8,'杨康','男',5000,'2020-10-01',2)";
            //⑤获取执行sql对象[]
            stmt = con.createStatement();
            //⑥执行sql
            int exeResult = stmt.executeUpdate(sqlStr);
            //⑦处理结果
            if (exeResult>0) {
                System.out.println("添加成功");
            } else {
                System.out.println("添加失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //⑧释放资源[由里向外]
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

    }
}
