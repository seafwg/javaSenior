package com.seafwg.generic1;

import java.util.*;

/**
 *
 * DAO层叫数据访问层，全称为data access object，
 * 属于一种比较底层，比较基础的操作，具体到对于某个表、某个实体的增删改查。也就是说某个DAO一定是和数据库的某一张表一一对应的，
 * 其中封装了增删改查基本操作，建议DAO只做原子操作，增删改查。
 *
 * service层：service层叫服务层，被称为服务，肯定是相比之下比较高层次的一层结构，相当于将几种操作封装起来。
 * 粗略的理解就是对一个或多个DAO进行的再次封装，封装成一个服务，所以这里也就不会是一个原子操作了，需要事物控制。
 *
 * Controller负责请求转发，接受页面过来的参数，传给Service处理，接到返回值，再传给页面。
 */

/*
 * @create author: seafwg
 * @create time: 2020/8/17
 * @describe: 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *
 *   public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
     public T get(String id)：从 map 中获取 id 对应的对象
     public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
     public List<T> list()：返回 map 中存放的所有 T 对象
     public void delete(String id)：删除指定 id 对象
 */
public class DAO<T>{
  private Map<String, T> map = new HashMap<>(); // Map结构的申明以HashMap为例：
  // public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
  public void save(String id, T entity) {
    map.put(id, entity);
  }
  // public T get(String id)：从 map 中获取 id 对应的对象
  public T get(String id) {
    return map.get(id);
  }
  // public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
  public void update(String id, T entity) {
    if(map.containsKey(id)) {
//      map.put(id, entity);
      this.save(id, entity);
    }
  }
  // public List<T> list()：返回 map 中存放的所有 T 对象
  public List<T> list() {
    ArrayList<T> list = new ArrayList<>(); // 创建list
    Collection<T> values = map.values();   // 获取Map集合的value集合
    for (T t : values) {
      list.add(t);
    }
    return list;
  }
  // public void delete(String id)：删除指定 id 对象
  public void delete(String id) {
    map.remove(id);
  }

}





//public class DAO<T> {
//  private Map<String,T> map = new HashMap<>();
//  //保存T类型的对象到Map成员变量中
//  public void save(String id,T entity) {
//    map.put(id,entity);
//  }
//  // 从map中获取id对应的对象：
//  public T get(String id) {
//    return map.get(id);
//  }
//  // 替换map中key为id的内容，改为id的内容，改为entity对象
//  public void update(String id,T entity) {
//    if(map.containsKey(id)) {
//      map.put(id,entity);
//    }
//  }
//  //返回map中存放的所有T对象：
//  public List<T> list() {
//    ArrayList<T> list = new ArrayList<>();
//    Collection<T> values = map.values();
//
//    for(T t:values) {
//      list.add(t);
//    }
//    return list;
//  }
//
//  //删除指定id对象：
//  public void delete(String id) {
//    map.remove(id);
//  }
//}
