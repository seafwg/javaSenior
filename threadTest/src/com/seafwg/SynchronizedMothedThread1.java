package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/13
 * @discrable: 使用同步方法解决继承Thread的多线程：
 */

public class SynchronizedMothedThread1 {
  public static void main(String[] args) {
    SynchronizedFn synchronizedFn1 = new SynchronizedFn();
    SynchronizedFn synchronizedFn2 = new SynchronizedFn();
    SynchronizedFn synchronizedFn3 = new SynchronizedFn();
    synchronizedFn1.setName("窗口一");
    synchronizedFn2.setName("窗口二");
    synchronizedFn3.setName("窗口三");
    synchronizedFn1.start();
    synchronizedFn2.start();
    synchronizedFn3.start();
  }
}

class SynchronizedFn extends Thread{
  private static int tickets = 100;

  @Override
  public void run() {
    while(true) {
      syncFn();
    }
  }
  private static synchronized void syncFn() { // 不安全，锁是三个对象,在同步方法是静态方法：监视器是SynchronizedFn.class
    if(tickets>0) {
      System.out.println(Thread.currentThread().getName()+"卖票，票号"+tickets);
      tickets--;
    }
  }
}