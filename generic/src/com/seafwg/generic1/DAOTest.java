package com.seafwg.generic1;

import java.util.List;

/*
 * @create author: seafwg
 * @create time: 2020/8/17
 * @describe:
 */
public class DAOTest {
  public static void main(String[] args) {
    DAO<User> dao = new DAO<>();

    dao.save("1000",new User(1000,23,"小王"));
    dao.save("1001",new User(1001,23,"小李"));
    dao.save("1002",new User(1002,23,"小武"));
    dao.save("1003",new User(1003,23,"小赵"));

    dao.update("1002",new User(1002,30,"大武"));

    dao.delete("1003");

    List<User> list = dao.list();
    list.forEach(System.out::println);
  }
}
