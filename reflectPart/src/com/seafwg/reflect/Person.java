package com.seafwg.reflect;

/**
 * @create author: seafwg
 * @create time: 2020
 * @describe: XXX
 * TODO
 **/
public class Person {
    private int age;
    public String name;
    String ID;

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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Person(int age, String name, String ID) {
        this.age = age;
        this.name = name;
        this.ID = ID;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", ID='" + ID + '\'' +
                '}';
    }
    public void eat() {
        System.out.println("eat...");
    }
}
