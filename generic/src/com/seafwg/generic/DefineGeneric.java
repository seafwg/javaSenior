package com.seafwg.generic;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/*
 * @create author: seafwg
 * @create time: 2020/8/12
 * @describe: 自定义泛型：
 * 自定义泛型类，泛型接口；泛型方法：
 * 【注意】：泛型类型不同的引用之间不能互相赋值。
 */
public class DefineGeneric {


  @Test
  public void test() {
    GenericClass genericClass = new GenericClass("seafwg",666,"seafwg");

    // 初始化泛型类：
    GenericClass<String> genericClass1 = new GenericClass<>("seafwg",999,"1234");
    System.out.println(genericClass1.getGenericT());
  }

  @Test
  public void test1() {
    // 实例化子类继承泛型父类：
    GenericClass1 genericClass1 = new GenericClass1();
    genericClass1.setGenericT(666); // 继承时规定了类型；

    // 实例化泛型子类继承泛型父类：需要指明泛型类型
    GenericClass2<String> genericClass2 = new GenericClass2<>();
    genericClass2.setGenericT("seafwg");

    GenericClass2<Integer> genericClass21 = new GenericClass2<>();
    genericClass21.setGenericT(123123);
  }

  @Test
  public void test2() {
    ArrayList<String> list1 = new ArrayList<>();
    ArrayList<Integer> list2 = new ArrayList<>();
//    泛型类型不同的引用不能互相赋值：
//    list1 = list2;
  }

  @Test
  public void test3() {
    GenericClass<String> generic = new GenericClass<>();
//    Integer[] integers = {1, 2, 3, 4, 5, 6};
    Integer[] integers = new Integer[]{1,2,3,4};
    System.out.println("integers:"+integers);
    List<Integer> list = generic.copyFromArrayToList(integers);

    System.out.println("list:"+list);
  }


}
