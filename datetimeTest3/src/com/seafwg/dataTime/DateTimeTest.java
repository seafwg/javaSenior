package com.seafwg.dataTime;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * @create author: seafwg
 * @create time: 2020/7/23
 * @describe: JDK8之前的日期对象：
 * 一. System类中的currentTimeMillis();返回当前时间与1970，1.1.0时0分0秒之间以毫秒为单位的时间差。时间戳。
 *
 * 二. java.util.Date类：
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
 * 三. SimpleDateFormat:对日期Date类的格式和解析：
 *    格式化：原始日期对象格式化成指定格式
 *    解析：指定格式转化成原始日期格式
 * 四. Calender:
 *  > 1.实例化：
 *    > 1.1: 创建其子类的(GregorianCalender)对象
 *    > 1.2: 调用静态方法getInstance();
 *  > 2.常用方法：
 *    >get():获取当前日历对象：
 *    >set():设置当前日历对象
 *    >add():添加当前日历对象
 *    >getTime():日历类转换为Date对象
 *    >setTime():Date对象转换为日历对象
 */
public class DateTimeTest {

  public static void main(String[] args) throws ParseException {
    long timeMillis = System.currentTimeMillis();
    System.out.println(timeMillis);

    Date date = new Date();
    System.out.println(date.toString()); // Fri Jul 24 00:00:29 CST 2020

    Date date1 = new Date(159552009484L);
    System.out.println(date1.toString());

    java.sql.Date date2 = new java.sql.Date(159552009484L);
    System.out.println(date2); //1975-01-22



    // 创建SimpleDateFormat对象：指定格式
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    //格式化：
    String format = simpleDateFormat.format(date);
    System.out.println(format);
    // 解析：
    Date date3 = simpleDateFormat.parse(format);
    System.out.println(date3);

    /**
     * 练习将"2020-07-25"转换为java.sql.date下的date:
     * 1.首先构造格式对象：
     * 2.调用对象的parse(date)进行转化：
     * 3.通过java.sql.date的构造函数进行获取：
     */
    String strDate = "2020-07-25";
    SimpleDateFormat dateFormat = new SimpleDateFormat(strDate);
    Date parseDate = dateFormat.parse(strDate);

    java.sql.Date date4 = new java.sql.Date(parseDate.getTime());
    System.out.println(date4);

    /**
     * 练习2："三天打鱼两天晒网"，1990-01-01开始，2020-07-09这一天是大于还是晒网：
     *  总天数%5 == 1，2，3：打鱼：4，0是晒网；
     * 方法一：（data1.getTime() - data2.getTime()） /  (1000 * 60 * 60 * 24) +1:加一是由于java中的整数除法都是向下取整
     */


    // Calender:
    // get();获取当前日历对象的信息
    Calendar calendar = Calendar.getInstance();
    int days = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(days);
    // 设置当前日历类的当前信息：
    calendar.set(Calendar.DAY_OF_MONTH, 22); // Calender对象是可变的,不用重新赋值给一个变量
    days = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(days);
    // add(),对日历对象的加减操作：
    calendar.add(Calendar.DAY_OF_MONTH, 3); // 可以是负数：
    days = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(days);
    // getTime():日历对象 --> Date对象：
    Date calendarTime = calendar.getTime();
    System.out.println(calendarTime);
    // setTime():Date对象 --> 日历对象：
    Date date5 = new Date();
    calendar.setTime(date5);
    days = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println(days);
  }

}
