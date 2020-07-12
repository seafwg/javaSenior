package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/12
 * @discrable:解决线程安全问题1-同步代码块1
 */

public class synchronizedThread1 {
  public static void main(String[] args) {
    SyncThread syncThread1 = new SyncThread();
    syncThread1.setName("窗口1：");
    syncThread1.start();

    SyncThread syncThread2 = new SyncThread();
    syncThread2.setName("窗口2：");
    syncThread2.start();

    SyncThread syncThread3 = new SyncThread();
    syncThread3.setName("窗口3：");
    syncThread3.start();
  }
}

class SyncThread extends Thread{
  private static int tickets = 100;
  private static Object obj = new Object();
  // static 修饰

  @Override
  public void run() {
    while (true) {
      synchronized(obj) {
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