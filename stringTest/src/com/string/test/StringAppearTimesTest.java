package com.string.test;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/24
 * @describe: 统计一段字符串在一个字符串中出现的次数
 */
public class StringAppearTimesTest {
  /*
   * 获取一个字符串在另一个字符串中出现的次数，eg:获取“ab”,"acabjkljlsdfsdfabnnabbbaabjlkjlkab";
   */

  /**
   * 获取subStr在mainStr中的次数：
   * @param mainStr:
   * @param subStr
   * @return count
   */
  public int getStrAppearTimes1(String mainStr, String subStr) {
    int count = 0, mainStrLen = mainStr.length(), subStrLen = subStr.length(), index;
    if(mainStr == null || mainStrLen == 0 || subStr == null || subStrLen == 0 || subStrLen > mainStrLen) return 0;
    // 截取子串，剩余字符串中又去截取，截取字串后剩余字符串的开始位置以返回子串的位置+子串的长度
    while((index = mainStr.indexOf(subStr)) != -1) {
      count ++;
      mainStr = mainStr.substring(index + subStrLen); // 需要不断地截取字符串效率比较低
    }
    return count;
  }

  /**
   * @param mainStr
   * @param subStr
   * @return
   */
  public int getStrAppearTimes2(String mainStr, String subStr) {
    int count = 0,mainStrLen = mainStr.length(),subStrLen = subStr.length(),index=0;
    if(mainStr == null || subStr == null || mainStrLen < 0 || subStrLen < 0 || mainStrLen < subStrLen) return 0;
    // 使用indexOf(str, index);指定的位置开始查找：不断地修改index,不用不断地去截取字符串
    while((index = mainStr.indexOf(subStr, index)) != -1) {
      count++;
      index += subStrLen;
    }
    return count;
  }

  @Test
  public void test() {
    System.out.println(getStrAppearTimes1("acabjkljlsdfsdfabnnabbbaabjlkjlkab", "ab"));
    System.out.println(getStrAppearTimes2("acabjkljlsdfsdfabnnabbbaabjlkjlkab", "ab"));
  }
}
