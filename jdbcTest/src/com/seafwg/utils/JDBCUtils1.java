package com.seafwg.utils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: 抽取JDBC工具类:
 * TODO
 * ①抽取注册驱动
 * ②抽取一个方法获取连接数据库对象
 * ③抽取一个方法释放资源[]
 *
 * [出现的问题：]连接的数据库URL,USER,PASSWORD书写在代码中，修改时非常不便。
 *  改进：采用配置文件的形式：
 **/
public class JDBCUtils1 {
    //定义属性：
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    //静态代码块中读取文件：
    static {
        /*try {
            url="jdbc:mysql://localhost:3306/seafwg";
            user="root";
            password="root";
            Class.forName("com.jdbc.mysql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        try {
            //①读取资源文件，获取值。
            Properties pro = new Properties();
            //获取src路径下的文件的方式--->ClassLoader 类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();//获取工具类[本类]的加载器
            URL resURL = classLoader.getResource("jdbc.properties");//通过本类进行获取配置文件的路径
            System.out.println("resURL:" + resURL);
            // resURL: file:/D:/_stu/jaPro/javaSenior/out/production/jdbcTest/jdbc.properties
            String path = resURL.getPath();
            System.out.println("path: " + path);
            // path: /D:/_stu/jaPro/javaSenior/out/production/jdbcTest/jdbc.properties

            //②加载文件：
            pro.load(new FileReader(path));

            //③获取配置信息：
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            //④注册驱动
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
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
