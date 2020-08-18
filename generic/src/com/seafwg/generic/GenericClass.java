package com.seafwg.generic;

import java.util.ArrayList;
import java.util.List;

/*
 * @create author: seafwg
 * @create time: 2020/8/12
 * @describe: 定义泛型类：
 */
public class GenericClass<T> {
  String name;
  int id;
  // 内部属性使用泛型
  T genericT;

  public GenericClass(String name, int id, T genericT) {
    this.name = name;
    this.id = id;
    this.genericT = genericT;
  }

  public GenericClass() {
    // 编译不通过：T代表了一个变量，还未指定类型，无法使用关键字new创建
//    T[] arr= new T[10];
    // ? 什么操作：声明一个Object数组，进行强转成T类型数组
    T[] arr = (T[]) new Object[10];
  }
  //并不是一个泛型方法：只是在方法中使用了泛型，是一个泛型类的普通方法，只不过返回值是声明泛型类声明过的泛型类型
  public T getGenericT() {
    return genericT;
  }

  public void setGenericT(T genericT) {
    this.genericT = genericT;
  }

  // 定义泛型方法：
  // 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
  // 即使静态方法要使用泛型类中已经声明过的泛型也不可以,static方法要使用泛型，就必须使其成为泛型方法。
  /**
   * ① 只有声明了<T>的方法才是泛型方法，泛型类中使用了泛型的成员方法并不是泛型方法
   * ② <T>表明该方法将使用泛型类型T,也就是修饰符和返回值之间使用<T>修饰才是一个泛型方法
   * ③ 静态方法与泛型：在类中的静态方法使用泛型时，需要额外的泛型声明，即：静态方法要使用泛型类型的话，必须要声明成泛型方法。
   *
   * @param arr
   * @param <T>
   * @return
   */
  public static <T> List<T> copyFromArrayToList(T[] arr) {
    ArrayList<T> list = new ArrayList<>();
    for (T t : arr) {
      list.add(t);
    }
    return list;
  }
}
