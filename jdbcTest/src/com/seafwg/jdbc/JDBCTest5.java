package com.seafwg.jdbc;

import com.seafwg.domain.Emp;
import com.seafwg.utils.JDBCUtils1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 * 定义一个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 **/
public class JDBCTest5 {
    public static void main(String[] args) {
        //创建对象并调用查询方法：
        List<Emp> list = new JDBCTest5().findAll();
        System.out.println("list: "+list);
        System.out.println("list size: "+list.size());
    }

    /**
     * 定义查询所有数据的方法：
     * @return 查询的数据集合
     */
    public List<Emp> findAll() {
        Connection conn =null;
        Statement stmt = null;
        ResultSet rst = null;

        //封装对象，装载集合：
        Emp emp = null;
        List<Emp> list = new ArrayList<>();
        //使用JDBCUtils连接数据库：
        try {
            //①连接数据库
            conn = JDBCUtils1.getConnection();
            //②定义sql
            String sqlStr = "SELECT * FROM emp";
            //③获取执行sql对象，执行sql
            stmt = conn.createStatement();
            rst = stmt.executeQuery(sqlStr);
            //④处理查询结果集：
            while (rst.next()) {
                int id = rst.getInt("id");
                String name = rst.getString("name");
                String gender = rst.getString("gender");
                int salary = rst.getInt("salary");
                Date join_date = rst.getDate("join_date");
                int dept_id = rst.getInt("dept_id");

                //创建emp对象，并赋值：
                emp = new Emp();
                emp.setId(id);
                emp.setName(name);
                emp.setGender(gender);
                emp.setSalary(salary);
                emp.setJoin_date(join_date);
                emp.setDept_id(dept_id);
                //装载集合
                list.add(emp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils1.close(rst, stmt, conn);
        }

        return list;
    }
}

