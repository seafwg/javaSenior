package com.string.test;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/24
 * @describe: 字符串常用算法:一个字符串中指定字符串的反转
 */
public class StringReverseTest {

  /**
   * 将一个字符串反转，将字符串中指定的字符进行反转，eg:"abcdefg" => "abfedcg";
   * 方法一：转换为char[]数组：toCharsArray(); ====> myReverse1
   * 方法二：划分为三部分截取，第一段截取substring()，第二段中间的反着循环拼接+=str.charAt(i);i--;，第三段str.substring(endIndex+1)
   * 方法三：使用StringBuffer或者stringBuilder重写方法二：效率大大提高。
   */

  // 方法一：
  public String myReverse1(String str, int startIndex, int endIndex) {
    if(str == null || str.length() == 0) return null;
    char[] charsArr = str.toCharArray();
    for (int i = startIndex, j = endIndex; i < j; i++, j--) {
      char temp = charsArr[i];
      charsArr[i] = charsArr[j];
      charsArr[j] = temp;
    }
    return new String(charsArr);
  }

  // 方法二：性能不太好 => 使用StringBuffer或者StringBuilder
  public String myReverse2(String str, int startIndex, int endIndex) {
    if(str == null || str.length() == 0) return null;
    // 第一段字符串：截取0-startIndex个字符串
    String strTemp = str.substring(0,startIndex);
    // 第二段字符串：循环，从末尾开始循环，i=endIndex,i>=startIndex,i--,charAt(i)拼接在strTemp中：
    for (int i = endIndex; i >= startIndex; i--) {
      strTemp += str.charAt(i);
    }
    // 第三段字符串：拼接剩下的字符串：
    strTemp += str.substring(endIndex + 1);
    return strTemp;
  }

  // 方法三：使用StringBuilder实现方法二：
  public String myReverse3(String str, int startIndex, int endIndex) {
    if(str == null || str.length() == 0) return null;
    // 创建一个字符串长度的StringBuilder字符串
    StringBuilder builder = new StringBuilder(str.length());
   // 第一段字符按：
    builder.append(str.substring(0, startIndex));
    // 第二段字符：
    for (int i = endIndex; i >= startIndex; i--) {
      builder.append(str.charAt(i));
    }
    // 第三段字符串：
    builder.append(str.substring(endIndex+1));

    return builder.toString();
  }

  @Test
  private void test() {
    System.out.println(myReverse1("abcdefg", 2, 5));
    System.out.println(myReverse2("abcdefg", 2, 5));
    System.out.println(myReverse3("abcdefg", 2, 5));
  }

}
