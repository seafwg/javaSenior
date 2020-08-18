package com.collection.test;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

/*
 * @create author: seafwg
 * @create time: 2020/8/2
 * @describe: collection:
 * collection:
 *  |--List:有序，可重复
 *    |--ArrayList：底层数据结构是数组，查询快，增删慢。线程不安全，效率高。
 *    |--LinkedList：底层数据结构是链表，查询慢，增删快。线程不安全，效率高。
 *    |--Vector：底层数据结构是数组，查询快，增删慢。线程安全，效率底。
 *  |--Set：无序，唯一，不可重复
 *    |--HashSet：
 *    |--LinkedHashSet
 *    |--TreeSet
 * Map：Map用于保存具有映射关系的数据，Map里保存着两组数据：key和value，它们都可以使任何引用类型的数据，但key不能重复。所以通过指定的key就可以取出对应的value。
 *    |--HashMap
 *    |--LinkedHashMap
 *    |--TreeMap
 *    |--Hashtable
 *
 *
 *
 *
 *  collection:通用方法：
 *  1.add(Object obj):添加任意对象
 *  2.addAll(Collection coll):将指定的集合添加到集合中
 *
 *  3.remove(Object obj):删除指定的对象
 *  4.removeAll(Collection coll):指定的集合元素删除
 *  5.clear():清空集合中所有的元素
 *
 *  6.isEmpty():判断集合是否为空
 *  7.contains(Object obj):判断集合中是否包含指定对象
 *  8.containsAll(Collection coll):判断集合中是否包含指定集合
 *
 *  9.int size():返回集合容器的大小
 *  10.toArray():将集合转换为数组
 *
 *  11.retainAll(collection coll):获取当前集合和指定集合的交集
 *  12.equals(Object obj)
 *  13.hashCode():返回当前对象的哈希值
 *  14.iterator():返回iterator()接口的实例，用于遍历集合
 *    hasNext():是否有下一个迭代对象
 *    next():进行下一个迭代对象
 */
public class collectionTest1 {

  @Test
  public void test() {
    ArrayList arrayList = new ArrayList();
    arrayList.add("seafwg");
    arrayList.add(123);
    arrayList.add("assassion");
    arrayList.add(890);
//    增强for循环：
    for (Object obj : arrayList) {
      System.out.println("for(:)"+obj);
    }

    Iterator iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      Object it = iterator.next();
      System.out.println("iterator:"+it);
    }
//    iterator 迭代器的使用
    Iterator it = arrayList.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }

//    System.out.println(arrayList);
  }
}
