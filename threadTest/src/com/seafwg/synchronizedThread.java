package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/12
 * @discrable: 解决线程安全问题1-同步代码块
 */

public class synchronizedThread {
  public static void main(String[] args) {
    MyThread3 myThread3 = new MyThread3();
    Thread t1 = new Thread(myThread3);
    t1.setName("窗口1：");
    t1.start();

    Thread t2 = new Thread(myThread3);
    t2.setName("窗口2：");
    t2.start();

    Thread t3 = new Thread(myThread3);
    t3.setName("窗口3：");
    t3.start();
  }
}

class MyThread3 implements Runnable{
  private static int tickets = 100;
//  private Object obj = new Object();
  @Override
  public void run() {
    while (true) {
//    synchronized(obj) {
    // this代表MyThread3创建的对象，唯一，但是继承Thread的方式创建线程不能使用this[线程对象不唯一]（MyThread3.class访问可以，类的.class）
      synchronized(this) {
        if (tickets > 0) {
          System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + tickets);
          tickets--;
        } else {
            break;
        }
      }
    }
  }
}