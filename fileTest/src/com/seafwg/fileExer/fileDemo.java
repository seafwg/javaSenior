package com.seafwg.fileExer;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/*
 * @create author: seafwg
 * @create time: 2020/8/18
 * @describe: demo
 *
 */
public class fileDemo {
//  ①：创建一个与file同目录下的另外一个文件，文件名为：haha.txt
// *[分析：]file的目录必须同时存在
  @Test
  public void test1() throws IOException {
    File file = new File("D:\\io\\io1\\hello.txt");
    File file1 = new File(file.getParent(), "haha.txt");
    boolean newFile = file1.createNewFile();
    if(newFile) {
      System.out.println("文件创建成功");
    }
  }
  /**
   * 练习②：判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
   */
  // 方法一：
  @Test
  public void test2() {
    File srcFile = new File("d:\\_stu\\javaSenior");
    String[] list = srcFile.list();
    for (String s : list) {
      if(s.endsWith(".jpg") || s.endsWith(".png")) {
        System.out.println(s);
      }
    }
  }
  // 方法二：
  @Test
  public void test3() {
    File file = new File("d:\\_stu\\javaSenior");
    File[] files = file.listFiles();

    for (File f : files) {
      if(f.getName().endsWith(".png")) { // f是路径，根据路径，通过getName获取名称
        System.out.println(f.getAbsolutePath()); // f本身是绝对路径，再次获取绝对路径还是绝对路径
        System.out.println(f.getName());
      }
    }
  }
}
