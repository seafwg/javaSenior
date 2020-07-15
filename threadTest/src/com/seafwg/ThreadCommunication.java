package com.seafwg;/*
 * @create author: seafwg
 * @create time: 2020/7/16
 * @discrable: 线程之间的通信：
 * @eg: 两个线程交替的打印1-100之间的数：
 *  说明：在操作数结束的时候添加wait()方法，使得当前线程为堵塞，在操作数开始的时候使用notify()方法，
 *   三个方法：
 *   1.wait：堵塞当前线程，并释放同步监视器
 *   2.notify:方法启用线程唤醒wait()方法堵塞的线程，如果有多个线程被wait()唤醒优先级高的
 *   3.notifyAll:唤醒所有wait()的线程。
 */

public class ThreadCommunication {
  public static void main(String[] args) {
    ThreadCommunicate threadCommunicate = new ThreadCommunicate();
    Thread t1 = new Thread(threadCommunicate);
    Thread t2 = new Thread(threadCommunicate);

    t1.setName("线程1：");
    t2.setName("线程2：");

    t1.start();
    t2.start();
  }
}

class ThreadCommunicate implements Runnable{
  private int number = 1;

  @Override
  public void run() {
    while(true) {
      synchronized (this) { // 解决线程安全问题
        if(number<=100) {
          notify(); // notify()方法启用线程唤醒wait()方法堵塞的线程，如果有多个线程被wait()唤醒优先级高的
          System.out.println(Thread.currentThread().getName()+"--"+number);
          number++;
          try {
            wait(); // 堵塞当前线程，并释放同步监视器
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }else{
          break;
        }
      }
    }
  }
}