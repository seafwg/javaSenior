package com.seafwg.commonlyclass;

/*
 * @create author: seafwg
 * @create time: 2020/7/20
 * @describe: 字符串常用算法test
 */
public class StringTest {
  public static void main(String[] args) {
    String str = "hello world";
    String str1 = "aba";
    System.out.println(isPalindrome(str));
    System.out.println(isPalindromeString(str1));
  }
  /**
   * 判断一个字符串是否为回文：方法一：
   * 创建stringBuffer或者StringBuild对象，调用reverse()方法进行反转，
   * 反转后toString()和str进行equals比较。
   */
  public static boolean isPalindrome(String str) {
    if(str == null) return false;
    StringBuilder stringBuilder = new StringBuilder(str);
    stringBuilder.reverse();
    // stringBuilder:不是String类型，StringBuild类型，要转换成String类型;
    return stringBuilder.toString().equals(str);
  }
  /**
   * 判断回文：方法二：
   * 通过字符串的方法不要借助其它类实现：
   * 把字符串对半分割，遍历字符串，调用字符串的charAt(startIndex)和charAt(endIndex)的值是否相等
   */
  public static boolean isPalindromeString(String str) {
    if(str == null) return false;
    int _len = str.length();
    for (int i = 0; i < _len/2; i++) {
      if(str.charAt(i) != str.charAt(_len-i-1)) return false;
    }
    return true;
  }
}
