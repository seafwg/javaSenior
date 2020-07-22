package commonlyclass;

/*
 * @create author: seafwg
 * @create time: 2020/7/19
 * @describe: String类型不可变性的一道题：
 */
public class StringImmutable {
  String str = new String("seafwg");
  char[] ch = {'t','e','s','t'};
  /*
   * @param:str:类型是不可变性，传递的地址：
   * @param:ch：并没有不可变性
   */
  public void change(String str, char ch[]){
    str = "change string";
    ch[0] = 'b';
  }

  public static void main(String[] args) {
    StringImmutable stringImmutable = new StringImmutable();
    stringImmutable.change(stringImmutable.str,stringImmutable.ch);

    System.out.println(stringImmutable.str); // seafwg
    System.out.println(stringImmutable.ch);  // best
  }

}
