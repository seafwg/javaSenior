package com.seafwg.dataTime;

import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

//
/*
 * @create author: seafwg
 * @create time: 2020/7/26
 * @describe: jdk8的事件对象：LocalDate,LocalTime,LocalDateTime类的使用：
 */
public class jdk8DateTest {

  /**
   * LocalDate,LocalTime,LocalDateTime:
   * 1.now(): 实例化：调用静态方法：
   * 2.of(): 通过静态方设置格式：
   * 3.getXXX(): 获取当前的时间对象：
   * 4.withXXX(): 设置当前的对象，不可变性
   * 5.plusXXX(): 加法操作：
   * 6.minusXXX(): 减法操作：
   */

  @Test
  public void test() {
    // 1: now():
    LocalDate now1 = LocalDate.now();
    LocalTime now2 = LocalTime.now();
    LocalDateTime now = LocalDateTime.now();
    System.out.println(now);
    System.out.println(now1);
    System.out.println(now2);
    // 2 of();
    LocalDateTime time = LocalDateTime.of(2020, 10, 28, 12, 8);
    System.out.println(time);


    // 3 getXXX
    int dayOfMonth = now.getDayOfMonth();
    System.out.println(dayOfMonth);

  }
}
