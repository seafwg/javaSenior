package com.seafwg.utils;

import java.sql.*;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 抽取JDBC工具类:
 * TODO
 * ①抽取注册驱动
 * ②抽取一个方法获取连接数据库对象
 * ③抽取一个方法释放资源[]
 **/
public class JDBCUtils {
    //定义属性：
    private static String url;
    private static String user;
    private static String password;

    //静态代码块中读取文件：
    static {
        try {
            url="jdbc:mysql://localhost:3306/seafwg";
            user="root";
            password="root";
            Class.forName("com.jdbc.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源：DDl,DML
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt, Connection conn) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 释放资源：DQL
     * @param stmt
     * @param conn
     * @param rest
     */
    public static void close(ResultSet rest, Statement stmt, Connection conn) {
        if(rest != null) {
            try {
                rest.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
