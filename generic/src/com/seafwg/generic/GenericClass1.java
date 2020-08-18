package com.seafwg.generic;

import java.util.ArrayList;
import java.util.List;

/*
 * @create author: seafwg
 * @create time: 2020/8/12
 * @describe: 定义类继承泛型类，它本身不是泛型类：
 */
public class GenericClass1 extends GenericClass<Integer> { // GenericClass1不是泛型类：
  public static <E> List<E> copyFromArrayToList(E[] arr) {
    ArrayList<E> list = new ArrayList<>();
    for (E e : list) {
      list.add(e);
    }
    return list;
  }
}
