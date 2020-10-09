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
 * emp 修改记录 [update] 小龙女dept_id = 1
 **/
public class JDBCTest3 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement state = null;
        try {
            //②注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //③获取数据库的连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/seafwg", "root", "root");
            //④定义sql
            String sqlStr = "update emp set dept_id = 1 where id = 4";
            //⑤获取sql执行对象
            state = conn.createStatement();
            //⑥执行sql
            int exeReult = state.executeUpdate(sqlStr);
            //⑦处理结果
            if (exeReult > 0) {
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            //⑧释放资源
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
