package commonlyclass;

/*
 * @create author: seafwg
 * @create time: 2020/7/19
 * @describe:
 */
public class Demo {
  public static void main(String[] args) {
    System.out.println("hello world");
    String s1 = "abc";
    String s2 = "abc";

    String s3 = new String("abc");
    String s4 = new String("abc");
    System.out.println(s1==s2); // true, s1,s2都在常量池中，常量池中存放唯一的值。
    System.out.println(s1==s3); // false
    System.out.println(s1==s4); // false s1,常量池中的值，s3,s4是堆空间中的值(value的属性值为常量池中的地址)
    System.out.println(s3==s4); // false s3,s4两者都是新的对象

    String str1 = "javaEE";
    String str2 = "hadoop";

    String str3 = "javaEEhadoop";
    String str4 = "javaEE"+"hadoop";
    String str5 = str1 + "hadoop";
    String str6 = "javaEE" + str2;
    String str7 = str1 + str2;

    String str8 = str5.intern();

    System.out.println(str3 == str4); // true 字符串连接，字面量式创建都在常量池中
    System.out.println(str3 == str5); // false
    System.out.println(str3 == str6); // false
    System.out.println(str3 == str7); // false
    System.out.println(str5 == str6); // false
    System.out.println(str5 == str7); // false 只要出现变量的连接都在堆空间开辟。变量相当于new出来的对象存放在堆内存中，堆内存存储常量池的地址值。

    System.out.println(str3 == str8); // true
    /*
    * 结论：
    * 1.常量与常量的拼接结果都在常量池中，且常量池中不会存放相同的内容。
    * 2.只要其中有一个变量，结果就在堆中。
    * */
  }
}
