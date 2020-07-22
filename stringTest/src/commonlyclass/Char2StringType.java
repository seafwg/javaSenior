package commonlyclass;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
 * @create author: seafwg
 * @create time: 2020/7/22
 * @describe: String类型转换为char[]：
 * String --> char[] 调用String的toCharArray()方法;
 * char[] --> String 调用String的构造器：
 *
 * // String与byte[]字节数组之间的转换
 * 编码：String ---> byte[]: 调用String的getBytes();
 * 解码：byte[] ---> String: 调用String的构造器
 *
 * 编码：字符串 ---> 字节 （看得懂 ---> 看不懂的二进制数据）
 * 解码：编码的过程 ---> 字符串 （看不懂的二进制数据 ---> 看得懂）
 *
 * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。
 */
public class Char2StringType {

  // String类型转换为char[]：
  // String --> char[]
  @Test
  public void test() {
    String str = "hello123";
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      System.out.println(chars[i]);
    }
  }

  // char[] --> String
  @Test
  public void test1() {
    char[] chars = new char[]{'s', 'e', 'a', 'f', 'w', 'g'};
    String str = new String(chars);
    System.out.println(str);
  }

  // String与byte[]字节数组之间的转换
  // String ---> byte[]:调用String的getBytes();
  @Test
  public void test2() {
    String str = "hello中国";
    byte[] strBytes = str.getBytes(); // 默认为utf-8,汉字为三个字节
    System.out.println(Arrays.toString(strBytes));

    try {
      byte[] gbks = str.getBytes("gbk"); // gbk汉字默认两个字节
      System.out.println(Arrays.toString(gbks));

      String s1 = new String(gbks, "gbk");
      System.out.println(s1);
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    // byte[] ---> String:调用String的构造器

    String s = new String(strBytes);
    System.out.println(s);

  }

}
