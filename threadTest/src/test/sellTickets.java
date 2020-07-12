package test;
/*
* Demo: testJava:窗口销售100张票：
* */

public class sellTickets {
  public static void main(String[] args) {
    sellTicketsWindow sellT1 = new sellTicketsWindow();
    sellTicketsWindow sellT2 = new sellTicketsWindow();
    sellTicketsWindow sellT3 = new sellTicketsWindow();
    sellT1.start();
    sellT2.start();
    sellT3.start();
  }
}

class sellTicketsWindow extends Thread{
  // totalTickets总票数的变量必须是static修饰，因为静态变量产生的每个对象共享的，如果不用static修饰，每一个对象下都有一个变量totalTickets
  public static int totalTickets = 100;
  @Override
  public void run() {
    while(true) {
      if(totalTickets>0) {
        System.out.println(getName()+":卖票，票号为："+totalTickets);
        totalTickets--;
      }else{
        break;
      }
    }
  }
}