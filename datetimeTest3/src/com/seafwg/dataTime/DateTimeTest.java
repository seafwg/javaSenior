package com.seafwg.dataTime;

import org.junit.Test;

import java.util.Date;

/*
 * @create author: seafwg
 * @create time: 2020/7/23
 * @describe: Date对象是在Sytem类下。
 *            System类中的currentTimeMillis();返回当前时间与1970，1.1.0时0分0秒之间以毫秒为单位的时间差。时间戳。
 *
 * java.util.Date类：
 *    | --- java.sql.Data类：
 *
 * java.util.Date类：
 * 1.两个构造器：
 *    > Date():创建一个对应当前时间的Date对象
 *    > Date(毫秒数)：创建指定时间毫秒数的Date对象
 * 2.两个方法的使用：
 *    > toString(),显示当前的年，月，日，时，分，秒
 *    > getTime():获取当前Date对象对应的毫秒数。（时间戳）
 * 3.java.sql.Date:对应着数据库中的日期对象；
 *    > 如何实例化：new java.sql.Date(毫秒数L);
 *
 */
public class DateTimeTest {

  public static void main(String[] args) {
    long timeMillis = System.currentTimeMillis();
    System.out.println(timeMillis);

    Date date = new Date();
    System.out.println(date.toString()); // Fri Jul 24 00:00:29 CST 2020

    Date date1 = new Date(159552009484L);
    System.out.println(date1.toString());

    java.sql.Date date2 = new java.sql.Date(159552009484L);
    System.out.println(date2); //1975-01-22

  }

  @Test
  private void test() {

  }
}