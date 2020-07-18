package test;
/*
 * @create author: seafwg
 * @create time: 2020/7/18
 * @discrable: 生产者与消费者的关系：
 *   生产者（productor）将产品交给店员(clerk)，消费者（customer）从店员处取走产品，店员一次只能持有固定的数量（20），如果生产者试图生产更多
 *   的产品叫停生产者，如果有空位放置一些产品店员通知生产者继续生产；如果点中没有产品了店员会通知消费者等一下，如果有产品了店员会通知消费者取产品。
 * 分析：
 * 1.是否为多线程？是，生产者，消费者。
 * 2.是否有共享数据？是，店员(或者产品)
 * 3.如何解决（如何解决线程安全问题）？同步机制，三种方法：
 * 4.是否涉及线程通信？是
 *
 */

public class ProductorAndCustomer {
  public static void main(String[] args) {
    Clerk clerk = new Clerk();
    Productor productor = new Productor(clerk);
    Customer customer = new Customer(clerk);

    productor.setName("生产者：");
    customer.setName("消费者");

    productor.start();
    customer.start();
  }
}

class Clerk{ // 店员，或者数据也就是要操作的共享数据：
  /*
  * 店员是共享数据：店员中有两个方法，两个方法是提供给线程访问操作的，两个方法之间是同步的不能异步，不然会影响数据，一个是减减操作，一个是加加操作。
  * 解决同步的方法--同步代码块synchronized，当生产者操作产品数量的时候，消费者是无法操作产品数量，添加了同步锁，对象都是店员。
  * */
  private int productCount = 0;

  //生产产品
  public synchronized void productorProduct() {
    if(productCount < 20) {
      productCount++;
      System.out.println(Thread.currentThread().getName()+":开始生产第"+productCount+"个产品");
      notify(); // 只要生产一个产品就去唤醒消费者
    }else{
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  // 消费产品
  public synchronized void customerProduct() {
    if(productCount > 0) {
      System.out.println(Thread.currentThread().getName()+"开始消费第"+productCount+"个产品");
      productCount--;
      notify();// 只要消费一个产品就去唤醒生产者
    }else{
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

class Productor extends Thread{ // 生产者：
  private Clerk clerk;
  // 构造函数
  public Productor(Clerk clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    // 生产者只提供生产：
    System.out.println(getName()+":开始生产产品...");
    while(true) {
      clerk.productorProduct();
    }
  }
}

class Customer extends Thread{ // 消费者
  private Clerk clerk;

  public Customer(Clerk clerk) {
    this.clerk = clerk;
  }

  @Override
  public void run() {
    // 消费者只提供消费
    System.out.println(getName()+":开始消费了...");
    while(true) {
      clerk.customerProduct();
    }
  }
}

