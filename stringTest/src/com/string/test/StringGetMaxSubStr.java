package com.string.test;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/24
 * @describe: 获取两个字符串中最大相同子串：eg: str1 = "sjdkfjsldfjlkjhelloajslajlksjlj", str2 = "dshshhelloksjdk";
 */
public class StringGetMaxSubStr {

  /**
   * 以小的子串去查找大的子串：
   * @param str1
   * @param str2
   * @return
   */
  public String getMaxSameStr(String str1, String str2) {
    if(str1 == null && str2 == null) return null;
    int str1Len = str1.length(), str2Len = str2.length();
    String maxStr = (str1Len > str2Len) ? str1 : str2;
    String minStr = (str1Len <= str2Len) ? str1 : str2;
    int minLen = str2Len;
    /**
     * 循环小串，第一层for循环控制整体的轮数，第二层for循环控制两头的截取掉的子串，
     */
    for (int i = 0; i < minLen; i++) {
      for (int j = 0, k = minLen - i; k <= minLen; j++,k++) {
        // 开始截取字符串
        String subStr = minStr.substring(j, k);
        if(maxStr.contains(subStr)) {
          return subStr;
        }
      }
    }
    return null; // 循环完了没有找到
  }

  @Test
  public void test() {
    System.out.println(getMaxSameStr("sjdkfjsldfjlkjhello12ajslajlksjlj", "dshshhello12ksjdk"));
  }
}
