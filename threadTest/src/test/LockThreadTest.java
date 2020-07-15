package test;/*
 * @create author: seafwg
 * @create time: 2020/7/15
 * @discrable: [匿名函数]演示有可能死锁的情况：
 * 有可能先执行第一个线程，也有可能先执行第二个线程，也有可能出现死锁现象[概率比较小而已]
 * 死锁的理解：不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁。
 * 说明：
 *  1.出现死锁后不会抛出异常，不会报错，线程之间堵塞，程序无法继续运行。
 *  2.我们使用同步时要避免死锁。
 */

public class LockThreadTest {
  public static void main(String[] args) {
    StringBuffer s1 = new StringBuffer();
    StringBuffer s2 = new StringBuffer();

    new Thread(){
      @Override
      public void run() {
        synchronized(s1) {
          s1.append("a");
          s2.append("1");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized(s2) {
            s1.append("b");
            s2.append("2");
            System.out.println(s1);
            System.out.println(s2);
          }
        }
      }
    }.start();
    new Thread(new Runnable() {
      @Override
      public void run() {
        synchronized (s2) {
          s1.append("c");
          s2.append("3");
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
          synchronized(s1) {
            s1.append("d");
            s2.append("4");
            System.out.println(s1);
            System.out.println(s2);
          }
        }
      }
    }).start();
  }
}
