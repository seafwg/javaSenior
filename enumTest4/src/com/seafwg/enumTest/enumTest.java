package com.seafwg.enumTest;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/28
 * @describe:
 * 一 枚举类的使用：
 *    1.枚举的理解：类的对象有限个，确定的。
 *    2.需要定义一组常量时，强烈建议使用枚举。
 *    3.如果枚举中只有一个对象，则可以作为单例模式的实现方式。
 *
 * 二 如何定义枚举类：
 *  1.jdk5.0之前，自定义枚举类：
 *    步骤：
 *     1.声明Season对象的属性：private final 修饰
 *     2.私有化类的构造器，并给对象赋值：
 *     3.提供当前类的多个对象：public static final 修饰：
 *     4.1 其他诉求1：获取枚举类对象的属性：
 *     4.2 toString():提供toString方法：
 *  2.jdk5.0之后，使用关键字enum定义枚举类：默认继承于class java.lang.Enum
 *     1.提供当前枚举类对象：
 *     2.声明Season1对象属性：private final
 *     3.私有化类的构造器，并初给对象属性赋值
 *     4.1 其他需求：
 *     4.2 提供toString方法：
 *
 * 三 Enum类的常用方法：
 *    1. values():返回枚举类型的对象数组，可以很方便的遍历所有的枚举值。
 *    2. valueOf(String str):指定的字符串转化为对应的枚举类对象，字符串必须是枚举对象类型字符串,如果没有找到会抛出异常
 *    3. toString():返回当前枚举类对象常量的名称
 *
 * 四 使用关键enum定义的枚举类实现接口的情况：
 *    1.实现接口，在枚举类中实现抽象方法
 *    2.让枚举类的每一个对象分别实现接口中的抽象方法
 */
public class enumTest {

  @Test
  public void test() {
    Season spring = Season.SPRING;
    Season autumn = Season.AUTUMN;
    System.out.println(spring.getSeasonDesc());
  }

  @Test
  public void testEnum() {
    Season1 spring = Season1.SPRING;
    System.out.println(spring);
    System.out.println(Season1.class.getSuperclass());//查看enum类的父类：class java.lang.Enum
    System.out.println("======================");
    Season1[] values = Season1.values();
    for (int i = 0; i < values.length; i++) {
      System.out.println(values[i]);
    }
    Season1 winter = Season1.valueOf("WINTER");
    System.out.println(winter);
  }

}


class Season{
  // 1.声明Season对象的属性：private final 修饰
  private final String seasonName; // final修饰必须赋值，有三种赋值：1.声明时赋值，2.构造器赋值，3.代码块赋值
  private final String seasonDesc;
//  2.私有化类的构造器，并给对象赋值：
  private Season(String seasonName, String seasonDesc) {
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }
//  3.提供当前类的多个对象：public static final 修饰：
  public static final Season SPRING = new Season("春天", "春暖花开");
  public static final Season SUMMER = new Season("夏天", "烈日炎炎");
  public static final Season AUTUMN = new Season("春天", "秋高气爽");
  public static final Season WINTER = new Season("冬天", "大雪纷飞");
//  4.1 其他诉求1：获取枚举类对象的属性：
  public String getSeasonName() {
    return seasonName;
  }

  public String getSeasonDesc() {
    return seasonDesc;
  }
//  4.2 toString():提供toString方法：
  @Override
  public String toString() {
    return "Season{" +
        "seasonName='" + seasonName + '\'' +
        ", seasonDesc='" + seasonDesc + '\'' +
        '}';
  }
}

/**
 * 使用关键字enum定义枚举类：
 * 使用enum关键字定义枚举类时，和自定义枚举类的不同之处：
 * 自定义枚举类的第三步提供当前类的对象作为enum关键字的第一步，写法上极大程度低简化。提供当前枚举类的对象。
 */
enum Season1{
//  1.提供当前枚举类对象：
  SPRING("春天","春暖花开"),SUMMER("夏天","烈日炎炎"),AUTUMN("秋天","秋高气爽"),WINTER("冬天","大雪纷飞");
//  2.声明Season1对象属性：private final
  private final String seasonName;
  private final String seasonDesc;
//  3.私有化类的构造器，并初给对象属性赋值
  private Season1(String seasonName, String seasonDesc) {
    this.seasonName = seasonName;
    this.seasonDesc = seasonDesc;
  }
//  4.其他需求：
  public String getSeasonName() {
    return seasonName;
  }

  public String getSeasonDesc() {
    return seasonDesc;
  }
//  4.2 提供toString方法：
//  toString()方法：enum关键字定义枚举时，默认提供了toString方法，但访问的时当前枚举对象名。
//  @Override
//  public String toString() {
//    return "Season1{" +
//        "seasonName='" + seasonName + '\'' +
//        ", seasonDesc='" + seasonDesc + '\'' +
//        '}';
//  }
}

// 505 6：00