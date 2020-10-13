package com.seafwg.jdbc;

import com.seafwg.utils.JDBCUtils1;

import java.sql.*;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: JDBCUtils1Test
 * TODO
 * 查询出emp中所有的人员信息：
 **/
public class JDBCUtilsTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rst = null;
        try {
            //①注册驱动和②获取连接对象
            conn = JDBCUtils1.getConnection();
            //③定义sql
            String sqlStr = "SELECT * FROM emp";
            //④获取执行sql对象
            stmt = conn.createStatement();
            //⑤执行sql
            rst = stmt.executeQuery(sqlStr);
            //⑥处理resultSet结果集对象
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String gender = rst.getString("gender");
                int salary = rst.getInt("salary");
                Date join_date = rst.getDate("join_date");
                int dept_id = rst.getInt("dept_id");

                System.out.println("{"+"id:"+id+",name:"+name+",gender:"+gender+",salary:"+salary+",join_date:"+join_date+",dept_id:"+dept_id+"}");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils1.close(rst, stmt, conn);
        }
    }
}
