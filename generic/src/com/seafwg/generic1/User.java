package com.seafwg.generic1;

/*
 * @create author: seafwg
 * @create time: 2020/8/17
 * @describe:
 * 定义一个 User 类：该类包含：private成员变量（int类型） id，age；（String 类型）name。
 */
public class User {
  private int id;
  private int age;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public User() {
  }

  @Override
  public String toString() {
    return "User: {" +
        "id:" + id +
        ", age:" + age +
        ", name:" + name +
        '}';
  }
  @Override
  public boolean equals(Object obj) {
    if(this == obj) return true;
    if(obj == null || getClass() !=obj.getClass()) return false;
    User user = (User) obj;

    if(id != user.id) return false;
    if(age != user.age) return false;

    return name != null ? name.equals(user.name) : user.name == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + age;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }
}
