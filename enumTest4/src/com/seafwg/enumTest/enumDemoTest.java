package com.seafwg.enumTest;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/29
 * @describe: enumDemo:
 * 使用枚举定义四季：（分别使用jdk5.0前后的两种方法）
 * 1.jdk5.0以前：自定义枚举类：【和定义普通类相似】
 *  1.1 声明Season类的属性：使用private final 关键字修饰
 *  1.2 私有化类的构造器，并给对象赋值
 *  1.3 提供当前类的多个对象：public static final 修饰
 *  1.4.1 获取枚举类的对象的属性
 *  1.4.2 提供toString()方法：
 *
 * 2.jdk5.0以后：使用enum关键字定义枚举类：
 *  2.1 提供当前类的多个对象【简写对象】
 *  2.2 声明对象的私有final属性
 *  2.3 是优化类的构造器，并给对象赋值
 *  2.4.1 获取枚举类对象的属性
 *  2.4.2 提供toString()方法
 */
public class enumDemoTest {

  @Test
  public void test() {
    SeasonTest spring = SeasonTest.SPRING;
    System.out.println(spring.getSeasonTestName());
    System.out.println(spring.getSeasonTestDesc());
  }
  @Test
  public void test1() {
    SeasonDemo autumn = SeasonDemo.AUTUMN;
//    System.out.println(autumn.getSeasonTestName());
//    迭代枚举类
    for (SeasonDemo seasonDemo : SeasonDemo.values()) {
      System.out.println(seasonDemo.getSeasonTestName()+"--"+seasonDemo.getSeasonTestDesc());
    }
  }
}

class SeasonTest{
//  1.声明枚举类的私有final属性
  private final String SeasonTestName;
  private final String SeasonTestDesc;
//  2.私有花蕾的构造器，并初初始化对象

  public SeasonTest(String seasonTestName, String seasonTestDesc) {
    this.SeasonTestName = seasonTestName;
    this.SeasonTestDesc = seasonTestDesc;
  }
//  3.提供当前类的多个对象
  public static final SeasonTest SPRING = new SeasonTest("春天","春暖花开");
  public static final SeasonTest SUMMER = new SeasonTest("夏天","夏日炎炎");
  public static final SeasonTest AUTUMN = new SeasonTest("秋天","秋高气爽");
  public static final SeasonTest WINTER = new SeasonTest("冬天","大雪纷飞");
// 4.1 获取枚举类对象的属性：

  public String getSeasonTestName() {
    return SeasonTestName;
  }

  public String getSeasonTestDesc() {
    return SeasonTestDesc;
  }
//  4.2 提供toString方法：

  @Override
  public String toString() {
    return "SeasonTest{" +
        "SeasonTestName='" + SeasonTestName + '\'' +
        ", SeasonTestDesc='" + SeasonTestDesc + '\'' +
        '}';
  }
}

enum SeasonDemo{
//  1 提供枚举类的多个固定的对象：
  SPRING("春天","春暖花开"),SUMMER("夏天","夏日炎炎"),AUTUMN("秋天","秋高气爽"),WINTER("冬天","大雪纷飞");
//  2 声明对象的私有final属性
  private final String SeasonTestName;
  private final String SeasonTestDesc;
//  3 优化类的构造器，并复制

  SeasonDemo(String seasonTestName, String seasonTestDesc) {
    this.SeasonTestName = seasonTestName;
    this.SeasonTestDesc = seasonTestDesc;
  }
//  4 提供外部访问的方法：
  public String getSeasonTestName() {
    return SeasonTestName;
  }

  public String getSeasonTestDesc() {
    return SeasonTestDesc;
  }
//  4.2 提供toString()方法：

  @Override
  public String toString() {
    return "SeasonDemo{" +
        "SeasonTestName='" + SeasonTestName + '\'' +
        ", SeasonTestDesc='" + SeasonTestDesc + '\'' +
        '}';
  }
}