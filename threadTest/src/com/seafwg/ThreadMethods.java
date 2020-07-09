package com.seafwg;
/*
* 常用Thread的方法：
* 1.start(): 启动当前线程；调用当前线程的run()方法：
* 2.run(): 通常需要重写Thread类中的此方法，将创建的线程要执行的操作申明在此方法中
* 3.currentThread(): 静态方法，返回执行当前代码的线程
* 4.getName(): 获取当前线程的名字
* 5.setName(): 设置当前线程的名字
*   5.1 可以重写线程类的带参构造方法，来修改名称
* 6.yeild(): 释放当前cpu的执行权
* 7.join(): 在线程a中调用线程b的join方法，此时线程a就进入阻塞状态，直到b线程执行完成以后a才结束阻塞状态
* 8.stop(): 强制结束此线程[已经废弃]
* 9.sleep(1000ms): 当前线程"睡眠",在指定的时间内当前线程是阻塞状态
* 10.isAlive(): 判断当前线程是否存活
*
* 线程的优先级：从概率上将优先执行[高概率的抢占cpu]
* 1. MAX_PRIORITY:10
*    MIN_PRIORITY:1
*    NORM_PRIORITY:5
* 2.获取和设置当前线程的优先级：
*   getPriority();
*   setPriority(int p);
* */

public class ThreadMethods {
  public static void main(String[] args) {
    testTread tread = new testTread("线程12：");
//    tread.setName("线程1");
    tread.start();
  }
}

class testTread extends Thread{
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      if(i%2==0) {
        System.out.println(Thread.currentThread().getName() + ":" + i);
      }
    }
  }

  //通过构造函数传参修改线程名：
  public testTread(String name) {
    super(name);
  }
}