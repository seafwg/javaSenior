package com.seafwg.generic;


import org.testng.annotations.Test;

import java.util.*;

/*
 * @create author: seafwg
 * @create time: 2020/8/11
 * @describe: 574
 * * 泛型的使用
 * 1.jdk 5.0新增的特性
 *
 * 2.在集合中使用泛型：
 *  总结：
 *  ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *  ② 在实例化集合类时，可以指明具体的泛型类型
 *  ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构（比如：方法、构造器、属性等）
 *	    使用到类的泛型的位置，都指定为实例化的泛型类型。
 *      比如：add(E e)  --->实例化以后：add(Integer e)
 *  ④ 注意点：泛型的类型必须是类，不能是基本数据类型。需要用到基本数据类型的位置，拿包装类替换
 *  ⑤ 如果实例化时，没有指明泛型的类型。默认类型为java.lang.Object类型。
 */
public class GenericTest {

  @Test
  public void test() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(123);
    list.add(789);
    list.add(67);

    Iterator<Integer> iterator = list.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    // 增强for循环的类型可以是包装类型，也可以是基本类型：
    for (int num : list) {
      System.out.println(num);
    }

    ArrayList<String> list1 = new ArrayList<>();
    list1.add("seafwg");
    list1.add("assassin");
    list1.add("haifu");
    for (String s : list1) {
      System.out.println(s);
    }
    Iterator<String> iterator1 = list1.iterator();
    while(iterator1.hasNext()) {
      System.out.println(iterator1.next());
    }
  }

  @Test
  public void test1() {
    //定义：学习成绩：
    HashMap<String, Integer> hashMap = new HashMap<>();
    hashMap.put("数学", 99);
    hashMap.put("语文", 98);
    hashMap.put("英语", 90);
    // 泛型的嵌套：
    Set<Map.Entry<String,Integer>> entry = hashMap.entrySet();
    Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();

    while(iterator.hasNext()){
      Map.Entry<String, Integer> e = iterator.next();
      String key = e.getKey();
      Integer value = e.getValue();
      System.out.println(key + "----" + value);
    }
  }
}
