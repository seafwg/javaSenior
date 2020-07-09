package com.seafwg;

public class MyThread1 {
  public static void main(String[] args) {
    // 通过Thread类的匿名子类的对象的方式
    new Thread(){
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          if (i%2==0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
          }
        }
      }
    }.start();
    new Thread(){
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          if (i%2 != 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
          }
        }
      }
    }.start();
  }
}
