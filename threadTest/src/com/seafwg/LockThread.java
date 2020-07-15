package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/15
 * @discrable: 解决死锁方式三：Lock
 * 步骤：1.创建一个私有的ReentrantLock类的实例
 *      2.把线程的同步操作使用try{}finally{}包裹
 *        2.1 try首先执行添加锁：创建的实例对象调用lock()方法
 *        2.2 在finally解锁：调用unlock();
 * Lock与synchronized的区别：
 * 相同点：都能解决线程安全问题；
 * 不同点：synchronized的机制自行同步代码的同时，自动地释放监视器。
 *       Lock的方式需要手动的启动和结束[lock(),unlock()]
 *
 *
 *
 */

import java.util.concurrent.locks.ReentrantLock;

public class LockThread {
  public static void main(String[] args) {
    LockThreadClass lockThreadClass = new LockThreadClass();
    Thread t1 = new Thread(lockThreadClass);
    Thread t2 = new Thread(lockThreadClass);
    Thread t3 = new Thread(lockThreadClass);

    t1.setName("窗口1：");
    t2.setName("窗口2：");
    t3.setName("窗口3：");

    t1.start();
    t2.start();
    t3.start();
  }
}

class LockThreadClass implements Runnable{
  private int tickets = 100;
  // 1.实例化一个ReentrantLock对象：
  private ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    while(true) {
      // 2.给共享数据添加lock方法：
      try{
        lock.lock();
        if(tickets>0) {
          System.out.println(Thread.currentThread().getName()+",卖票，票号为："+tickets);
          tickets--;
        }else{
          break;
        }
      }finally {
        // 3.数据操作完之后解锁：unlock
        lock.unlock();
      }
    }
  }
}
