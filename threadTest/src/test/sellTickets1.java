package test;/*
 * @create author: seafwg
 * @create time: 2020/7/12
 * @discrable: 利用多线程是先买票功能：三个窗口售票100张：
 */

public class sellTickets1 {
  public static void main(String[] args) {
    sellTicketsThread sellTicket1 = new sellTicketsThread();
    Thread thread1 = new Thread(sellTicket1);
    thread1.setName("窗口1：");
    thread1.start();
    Thread thread2 = new Thread(sellTicket1);
    thread2.setName("窗口2：");
    thread2.start();
    Thread thread3 = new Thread(sellTicket1);
    thread3.setName("窗口3：");
    thread3.start();
  }
}


class sellTicketsThread implements Runnable{
  /*
  * 实现Runnable接口的方式，由于创建了一个线程对象，线程对象中的遍历是Thread的对象所共享的，
  * 无需添加static修饰：
  * */
  private int totalTickets = 100;
//  private static int totalTickets = 100;

  @Override
  public void run() {
    while(true) {
      if(totalTickets>0) {
        System.out.println(Thread.currentThread().getName()+":卖票，票号为"+totalTickets);
        totalTickets--;
      }else{
        break;
      }
    }
  }
}