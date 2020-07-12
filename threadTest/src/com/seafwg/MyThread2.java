package com.seafwg;
/*
 * 实现多线程的方式2：通过实现Runnable接口实现多线程
 * 步骤：
 *   1.创建一个线程类实现Runnable接口
 *   2.线程类中实现Runnable中的抽象方法：run();
 *   3.创建实现类的对象
 *   4.将创建的对象传递到Thread类的构造器中，创建Tread类的对象
 *   5.通过Tread类的对象调用start()方法:①：启动线程；②调用当前线程的run方法;
 * 【问题：】
 *  ①step5:创建了Thread类调用了thread的start(),run方法的調用?
 *    调用了Runnable类型的target【形参】的run(),
 *
 * 【两种方式的比较：】
 *  开发中优先选择实现Runnable接口的方式：
 *  原因：1.实现的方式没有类单继承性的限制[创建线程的类很有可能要实现自身父类的水星和方法]
 *       2.实现的方式更适合来处理多个数据的共享
 *  联系：Thread的类也是实现了Runnable
 *  相同点：两种方法都要重写run()方法，将自己现成的逻辑声明在run方法中。
 * */

public class MyThread2 {
  public static void main(String[] args) {
    // step3:创建线程类的对象
    MyThreadTest2 myThreadTest2 = new MyThreadTest2();
    // step4:创建Thread对象，并将线程对象传递到Thread类的构造器中
    Thread thread = new Thread(myThreadTest2);
    // step5:创建的对象调用start()方法
    thread.setName("线程1：");
    thread.start();
    //? 创建线程2：
    Thread thread1 = new Thread(myThreadTest2);
    thread1.setName("线程2：");
    thread1.start();
  }
}


// step1:创建线程类并实现Runnable接口
class MyThreadTest2 implements Runnable{
  // step2:实现Runnable中的run()方法
  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      if(i%2==0) {
        System.out.println(Thread.currentThread().getName()+":"+i);
      }
    }
  }
}
