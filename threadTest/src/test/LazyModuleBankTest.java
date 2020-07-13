package test;/*
 * @create author: seafwg
 * @create time: 2020/7/13
 * @discrable: 解决线程安全的单例模式之懒汉模式
 */

public class LazyModuleBankTest {
  public static void main(String[] args) {

  }
}

/*
* 单例下的懒汉模式：只允许创建一个实例
* */
class Bank{
  private Bank() {} // 构造函数
  private static Bank instance = null;
    /* 方式一：
    * 此方法是不安全的，instance是共享的数据，每一个没有创建的instance的实例都来访问，创建实例，会产生重复的实例
    * 可以根据线程安全的方法修改，使用synchronized关键字修饰的同步方法解决
    * 整体效率比较低，比如多个线程之间访问instance,第一个线程之外其他线程无需在访问，直接返回即可。
    */
//  public synchronized static Bank getInstance() {
//    if(instance==null) {
//      instance = new Bank();
//    }
//    return instance;
//  }
  // 方式二：同步代码块：效率同样比较低
  public static Bank getInstance() {
//    synchronized (Bank.class) {
//      if(instance == null) {
//        instance = new Bank();
//      }
//      return instance;
//    }

    /* 方式二：进行改进
     *   假如有三个线程来访问，第一个进入if，后来两个也进入，第一个先通过new创建，后面两个判断之后返回，
     *   之后访问的线程通过最外层的判断直接返回，性能效率比较好
     */
    if(instance == null) {
      synchronized (Bank.class) {
        if(instance == null) {
          instance = new Bank();
        }
      }
    }
    return instance;
  }

}