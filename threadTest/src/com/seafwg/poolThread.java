package com.seafwg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * @create author: seafwg
 * @create time: 2020/7/18
 * @describe: 通过创建线程池的方法创建线程：
 * 创建步骤：
 *  1.提供固定数量的线程池
 *  2.执行指定的线程的操作，需要提供实现Runnable接口或者Callable接口实现类的对象
 *  3.关闭连接池：
 */
public class poolThread {
  public static void main(String[] args) {
    //1.提供指定线程数量的线程
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    //2.执行指定的线程操作
    executorService.execute(new Odd()); // execute()方法适用于Runnable接口中，submit()方法适用于Callable接口中。
    //3.关闭连接池：
    executorService.shutdown();

  }
}

class Odd implements Runnable{
  @Override
  public void run() {
    for (int i = 1; i <= 100; i++) {
      if(i%2==0) {
        System.out.println(i);
      }
    }
  }
}
