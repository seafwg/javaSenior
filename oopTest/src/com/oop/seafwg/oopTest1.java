package com.oop.seafwg;


import org.testng.annotations.Test;

/*
 * @create author: seafwg
 * @create time: 2020/7/28
 * @describe: 方法的重载，方法的重写，构造器之间的关系：
 */
public class oopTest1 {
  /**
   * 1.方法的重载：【在同一个类中】，允许存在一个以上的同名的方法，只要他们的参数个数或者参数类型不同即可；
   *    优点：根据不同参数的个数或者类型可以实现类似的功能。
   *
   * 2.方法的重写：【子类中出现和父类中】一模一样的方法(包括返回值类型,方法名,参数列表)
   *    2.1 注意事项：
   *      2.1.1 重写的方法必须要和父类一模一样(包括返回值类型,方法名,参数列表)
   *      2.1.2 重写的方法可以使用@Override注解来标识
   *      2.1.3 子类中重写的方法的访问权限不能低于父类中方法的访问权限：public > protected > default > private
   *      2.1.4 两个不能大于：子类的返回值类型不能大于父类重写方法的返回值类型；子类抛出的异常不能大于父类重写方法的异常
   *    2.2 使用场合：父类方法无法满足子类的需求,有自己特定的功能。
   *
   * 3.构造器：【类的成员三】[成员变量，成员方法，构造函数]
   *   3.1 构造器的特征：
   *      1. 和类具有相同的名称：
   *      2. 不声明返回值类型，不能有return语句。
   *      3. 不能被static, final, synchronized, abstract, native修饰
   *   3.2 构造器的作用：创建对象，给对象进行初始化：
   *
   *  this:
   *  它在方法内部使用，即这个方法所属对象的引用；
   *  它在构造器内部使用，表示该构造器正在初始化的对象。
   *  1. 在任意方法或构造器内，如果使用当前类的成员变量或成员方法可以在其前面添加this，增强程序的阅读性。不过，通常我们都习惯省略this。
   *  2. 当形参与成员变量同名时，如果在方法内或构造器内需要使用成员变量，必须添加this来表明该变量是类的成员变量
   *  3. 使用this访问属性和方法时，如果在本类中未找到，会从父类中查找
   *
   *  权限修饰符：public > protected > default > private
   *  工程范围：整个项目 > 不同包下的子类 > 同包下的子类 > 类的内部
   *
   *  public: 整个项目下都可以访问。
   *  protected: 不同包下的子类都可以访问。
   *  default: 同包下的子类都可以访问。
   *  private: 同类下的内部访问。
   *
   *  [class 权限修饰]只能用public,default
   *  1.public类可以被任何地方被访问
   *  2.default只能被同一个包内部的类方访问
   */
  @Test
  public void test() {
    Person person = new Person(23, "seafwg", 'M');
    System.out.println(person.name);
    System.out.println(person.age);
    System.out.println(person.sex);
  }

  @Test
  public void test1() {
    People people = new People(20, "smallSeaf", 'M',"coder");
    System.out.println(people.name);
    System.out.println(people.age);
    System.out.println(people.sex);
    System.out.println(people.major);
    people.setMoney(20000);
    int money = people.getMoney();
    System.out.println(money);
  }
  
}

class Person{
  int age;
  String name;
  char sex;
  private int money;

  public int getMoney() {
    return money;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  // 构造器：alt+insert:创建对象并进行实例化
  public Person(int age, String name, char sex) {
    this.age = age;
    this.name = name;
    this.sex = sex;
  }

  public Person() {} //使用了有参数的构造参数时，必须要有一个无参的构造函数：

  // 成员方法：
  public void action() {
    System.out.println("study");
  }
  public void speak() {
    System.out.println("speak");
    this.action();
    action();
  }
  private void fff() {}
}

class People extends Person{
  String major;

  public People(int age, String name, char sex, String major) {
    super(age, name, sex);
    this.major = major;
  }

  public People() {}

  @Override
  public int getMoney() {
    return super.getMoney();
  }

  @Override
  public void setMoney(int money) {
    super.setMoney(money);
  }
}