package com.seafwg.jdbc;

import java.sql.*;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JDBC TEST4
 * TODO
 * 查询出emp中所有的人员信息，并封装成一个集合：
 **/
public class JDBCTest4 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        ResultSet rst = null;
        try {
            //①...
            //②注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //③连接数据库
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seafwg", "root", "root");
            //④定义sql
            String sqlStr = "SELECT * FROM emp";
            //⑤获取sql执行对象
            state = conn.createStatement();
            //⑥执行sql
            rst = state.executeQuery(sqlStr);
            //⑦处理结果：ResultSet使用迭代器遍历
            while (rst.next()) { //循环判断游标是否是最后一行末尾。
                //获取数据：
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String gender = rst.getString("gender");
                int salary = rst.getInt("salary");
                Date join_date = rst.getDate("join_date");
                int dept_id = rst.getInt("dept_id");

                System.out.println(id+"----"+name+"----"+gender+"----"+salary+"----"+join_date+"----"+dept_id);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //⑧释放资源[从里向外，三个资源]
            if (rst != null) {
                try {
                    rst.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (state != null) {
                try {
                    state.close();
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
    }
}
