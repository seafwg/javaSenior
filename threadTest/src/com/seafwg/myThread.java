package com.seafwg;
/*
* 创建线程的步骤：
* 1.创建一个线程类继承Thread类
* 2.重写Tread父类的run的方法，
* 3.创建子线程对象
* 4.创建的对象调用start()方法
*
* */

public class myThread {
  public static void main(String[] args) {
    // 3.创建子类的对象
    myThreadTest thread = new myThreadTest();
    // 4.对象调用start();必须调用start方法，不能直接调用run方法[调用run方法相当于普通的方法，没有事启动线程]
    // start()的作用：a.启动当前线程，b.调用当前线程的run方法：
    thread.start();
    for (int i = 0; i < 100; i++) {
      if (i%2 != 0) {
        System.out.println(thread.currentThread().getName()+":"+i+"***********main()************");
      }
    }
  }
}


// 1.创建myThread类
class myThreadTest extends Thread{
  // 2.重写run方法：
  @Override
  public void run() {
    //书写自己的逻辑
    for (int i = 0; i < 100; i++) {
      if(i%2==0) {
        System.out.println(i);
      }
    }
  }
}