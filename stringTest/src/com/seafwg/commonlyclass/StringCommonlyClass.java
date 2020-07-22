package com.seafwg.commonlyclass;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/20
 * @describe: 字符串常用方法测试
 */
public class StringCommonlyClass {

  @Test
  public void test() {
    String str0 = "hello world";
    String str01 = new String("hello world");
    String str = new String("Hello wOrld");
    System.out.println(str.length());
    System.out.println("===="+str.charAt(5)+"====");
    String str1 = str01.toUpperCase();
    System.out.println(str1);
    System.out.println(str);
    System.out.println(str01.equals(str0));
  }
  /**
   * 判断一个字符串是否为回文：
   * 新字符串传递给新创建的StringBuffer或者StringBuild的实例，
   * 实例调用reverse()方法进行反转，之后对比是否相等即可
   */
  @Test
  public void test1() {
    String str = "abaseafwg";
    StringBuilder stringBuilder = new StringBuilder(str);
    StringBuffer stringBuffer = new StringBuffer(str);
    stringBuffer.reverse();
    System.out.println(stringBuffer);
    stringBuilder.reverse();
    System.out.println(stringBuilder.toString().equals(str));
  }

  @Test
  public void test2() {
    String str = "hello";
    String str1 = new String("hello");
    str1.intern();

    System.out.println(str == str1);          //false  str1字符串具有不可变性
    System.out.println(str == str1.intern()); //true   str1.intern()，通过调用intern()方法强制到字符串常量池
  }
}
