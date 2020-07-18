package com.seafwg;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * @create author: seafwg
 * @create time: 2020/7/18
 * @describe: jdk5.0新增创建线程的方式三：实现callable接口：
 * 步骤：
 *   1.实现Callable类
 *   2.重写call方法：在call方法中百年写自己的线程处理
 *   3.创建线程类的对象
 *   4.新创建FutureTask对象，并把线程对象传递给FutureTask类的构造器中
 *   5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法；
 *   6.调用get()方法：返回值为我们重写的call()方法：
 * callable为何比Runnable强大？
 *   1.call()方法有返回值
 *   2.call()方法可以抛出异常，被外面的操作捕获，获取异常信息
 *   3.Callable是支持泛型的
 */
public class jdk5newThread {
  public static void main(String[] args) {
    // 3.创建线程类的对象
    MyCallableThread myCallableThread = new MyCallableThread();
    // 4.新创建FutureTask对象，并把线程对象传递给FutureTask类的构造器中
    FutureTask futureTask = new FutureTask(myCallableThread);
    // 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法；
    new Thread(futureTask).start();
    // 6.调用get()方法：返回值为我们重写的call()方法：
    try {
      Object sum = futureTask.get();
      System.out.println(sum);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
  }
}


// 1.实现Callable类
class MyCallableThread implements Callable {
  // int不是Object的子类，int是基本数据类型，Object是类层面的两者没有继承关系，
  // 返回值的类型是Object,但返回的是Object自动装箱了，返回的是interage
  int sum = 0;
  // 2.重写call方法：在call方法中百年写自己的线程处理
  @Override
  public Object call() throws Exception {
    for (int i = 1; i <= 100 ; i++) {
      if(i % 2 == 0) {
        System.out.println(i);
        sum+=i;
      }
    }
    return sum;
  }
}