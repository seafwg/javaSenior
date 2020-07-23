package commonlyclass;

import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/23
 * @describe: StringBuffer和StringBuilder:
 * String,StringBuffer,StringBuilder三者的区别：
 * String：不可变的字符序列[操作一个str必须要赋值给一个变量不然不会发生变化]，底层使用char[]存储
 * StringBuffer：可变的字符序列，线程安全，效率低下,底层使用char[]存储
 * StringBuilder:可变的字符序列，线程不安全，效率高效，底层使用char[]存储
 *
 * 源码分析：String,StringBuffer结构分析：
 * String str = new String(); // char[] value = new char[0];
 * String str1 = new String("abc"); // char[] value = new char[]{'a','b','c'};
 *
 * 问题：
 *    1.底层默认长度默认16，只是容器的大小，但实际字符串的长度以实际为准。
 *    2.扩容问题：如果添加的数据大于底层数组的大小，那就需要扩容：
 *        默认情况：扩容为原来的2倍+2，同时将原有的数组复制到新的数组中。
 * 建议：开发中使用：StringBuffer(int capacity)或者StringBuilder(int capacity);固定容器的大小
 *
 * StringBuffer和StringBuilder的常用方法：
 * 增：append(XXX)
 * 删：delete(int startIndex,int endIndex);左开右闭
 * 改：setCharAt(int n, char ch) / replace(int start,int end,String str);
 * 查：chart(int n);
 * 插：insert(int offset, xxx);
 * 长度：length();
 * 遍历：for + charAt() / toString()查看
 *
 * ## 三者的效率：String < StringBuffer < StringBuilder
 */
public class StringBufferBuilder {

  @Test
  public void test() {
    String str = new String(); // char[] value = new char[0];
    String str1 = new String("abc"); // char[] value = new char[]{'a','b','c'};

    StringBuffer sb = new StringBuffer(); // char[] value = new char[16];创建时默认长度为16
    StringBuffer sb1 = new StringBuffer("abc");//char[] value = new char["abc".length()+16];
  }
}
