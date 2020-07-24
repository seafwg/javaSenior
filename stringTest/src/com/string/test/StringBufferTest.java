package com.string.test;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/24
 * @describe:
 */
public class StringBufferTest {
  @Test
  public void test() {
    String str = null;
    StringBuffer buffer = new StringBuffer();
    buffer.append(str);

    System.out.println(buffer.length()); //4 源码添加了“null”
    System.out.println(buffer); //null

    StringBuffer buffer1 = new StringBuffer(str); // java.lang.NullPointerException
    // 源码：super(str.length() + 16); str为null空指针
    System.out.println(buffer1); // 没执行到
  }
}
