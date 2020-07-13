package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/13
 * @discrable: 使用同步方法解决线程安全问题：
 */

public class synchronizedMothedThread {
  public static void main(String[] args) {
    synchronizedMothed syncFn = new synchronizedMothed();
    Thread t1 = new Thread(syncFn);
    Thread t2 = new Thread(syncFn);
    Thread t3 = new Thread(syncFn);
    t1.setName("窗口1：");
    t2.setName("窗口2：");
    t3.setName("窗口3：");
    t1.start();
    t2.start();
    t3.start();
  }
}

class synchronizedMothed implements Runnable{
  private int tickets = 100;
  @Override
  public void run() {
    while(true) {
      synchronizedMothedFn();
    }
  }
  private synchronized void synchronizedMothedFn() { // 锁是当前对象，this
    if(tickets>0) {
      System.out.println(Thread.currentThread().getName()+",卖票，票号为："+tickets);
      tickets--;
    }
  }
}