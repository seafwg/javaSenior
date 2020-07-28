package com.seafwg.dataTime;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/28
 * @describe: Java的对象只能比较==，!=,不能使用>或者<。使用Comparable或者Comparator接口可以实现两个对象的比较。
 *
 * 1.Comparable接口的使用举例：
 *  1.1 String，包装类实现了Comparable接口，重写了CompareTo(obj)方法
 *  1.2 String,包装类重写了CompareTo()方法以后进行了从小到大的排列
 *  1.3 重写CompareTo()方法的规则：
 *    1 如果当前对象this大于形参对象obj，返回正整数。
 *    2 如果当前对象this小于形参对象obj，返回负整数。
 *    3 如果当前对象this等于形参对象obj,返回零。
 */
public class ComparableTest {

  @Test
  public void test() {

  }
}
