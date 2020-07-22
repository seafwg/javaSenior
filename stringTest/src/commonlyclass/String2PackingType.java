package commonlyclass;

/*
 * @create author: seafwg
 * @create time: 2020/7/19
 * @describe: String类型与包装类型的互相转化：
 * String --> 基本数据类型，包装类型：调用包装类型的静态方法.parseXXX(str);
 * 基本类型，包装类型 --> String: 调用String重载的valueOf(xxx);
 */
public class String2PackingType {
  public static void main(String[] args) {
    String str = "123";
    int num = Integer.parseInt(str);

    System.out.println(str);
    System.out.println(num);

    String str1 = String.valueOf(num); // 方法一：
    String str2 = num+"";  // 方法二：

    System.out.println(str == str1); // false str是在常量池中，
    System.out.println(str2 == str1); //false str1
    System.out.println(str == str2); // false str2是在堆中
  }
}
