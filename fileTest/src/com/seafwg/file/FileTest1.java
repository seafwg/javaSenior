package com.seafwg.file;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/*
 * @create author: seafwg
 * @create time: 2020/8/18
 * @describe: File类的使用：
 * ① File类的一个对象，代表一个文件或者一个文件目录（俗称：文件夹）
 * ② File类声明在java.io包下
 * ③ File类涉及到关于文件或者文件目录操作的创建，删除，重命名，修改时间，文件等方法，
 * 并涉及到写入或读写文件内容的操作。如果需要读取或者写入文件内容，必须使用IO流来完成
 * ④ 后续涉及File类的对象常会作为参数传递到流的构造器中，指明读取或者写入的“终点”。
 */
public class FileTest1 {
  /**
   * ①：创建File类的实例
   *    File(String filePath)
   *    File(String parentPath, String childPath)
   *    File(File parentFile, String childPath)
   * ②：相对路径：相较于某个路径下，指明的路径。
   *     绝对路径：包含盘符在内的文件活文件目录的路径
   *
   * ③：路径分隔符：
   *    windows:\\
   *    unix:/
   */

  @Test
  public void test1() {
    // 构造器1：
    File file1 = new File("hello.txt");
    File file2 = new File("D:\\hello.txt");

    System.out.println(file1);
    System.out.println(file2);
    // 构造器2：
    File file3 = new File("D:\\_stu", "hello.txt");
    System.out.println(file3);
    // 构造器3：
    File file4 = new File(file3, "hi.txt");
    System.out.println(file4);
  }
  /**
   * public String getAbsolutePath(): 获取绝对路径：
   * public String getPath(): 获取路径
   * public String getName(): 获取名称
   * public String getParent(): 获取上层文件目录路径，如无返回null
   * public long length(): 获取文件长度(即字节数)。不能获取目录的长度
   * public long lastModified(): 获取最后一次修改的时间，返回毫秒数
   * 以下两个方法适用于文件目录：
   * public String[] list(): 获取指定目录下所有文件或者文件目录的名称数组
   * public File[] listFiles(): 获取指定目录下所有文件或者文件目录的File数组
   */
  @Test
  public void test2() {
    File file1 = new File("helloWorld.txt");
    File file2 = new File("D:\\helloWorld.txt");

    System.out.println(file1.getAbsolutePath()); // 获取绝对路径
    System.out.println(file1.getPath()); // 获取路径
    System.out.println(file1.getName()); // 获取名称
    System.out.println(file1.getParent()); // 获取上层文件路径：无返回null:
    System.out.println(file2.getParent()); // 获取上层文件路径：
    System.out.println(file1.length());
    System.out.println(file1.lastModified());
  }

  @Test
  public void test3() {
    File file = new File("D:\\_stu\\javaSenior");
    String[] list = file.list(); // 获取指定目录下所有文件或者文件目录的名称数组
    for (String s : list) {
      System.out.println(s);
    }
    System.out.println("====");
    File[] listFiles = file.listFiles(); // 获取指定目录下所有文件或者文件夹目录的路径File数组
    for (File f : listFiles) {
      System.out.println(f);
    }
  }
  /**
   * public boolean renameTo(File dest):把文件重命名为指定的文件路径：
   * 比如：file1.renameTo(file2)为例：想要返回true,需要file1在硬盘中是存在的，且file2不能在硬盘中存在。
   */
  @Test
  public void test4() {
    File file = new File("hello.text");
    File file1 = new File("D:\\io\\hi.txt");

    boolean renameTo = file1.renameTo(file);
    System.out.println(renameTo);
  }
  /**
   * public boolean isDirectory(): 判断是否是文件目录
   * public boolean isFile(): 判断是否为文件
   * public boolean exists(): 判断是否存在
   * public boolean canRead(): 判断是否为可读
   * public boolean canWrite(): 判断是否可写
   * public boolean isHidden(): 判断是否可隐藏
   */
  @Test
  public void test5() {
    File file = new File("hello.txt");
    file = new File("hello1.txt");
    System.out.println(file.isDirectory());
    System.out.println(file.isFile());
    System.out.println(file.exists());
    System.out.println(file.canRead());
    System.out.println(file.canWrite());
    System.out.println(file.isHidden());
  }
  /**
   * 创建硬盘中对应的文件或者文件目录：
   * public boolean createNewFile(): 创建文件，如果文件存在，则不创建，返回false
   * public boolean mkdir(): 创建文件目录。如果此文件目录存在，就不创建，如果测文件目录的上一层目录不存在，也不创建。
   * public boolean delete(): 删除文件或者文件夹，Java中的删除不走回收站
   */
  @Test
  public void test6() throws IOException {
    File file = new File("hi.txt");
    if(!file.exists()) {
      file.createNewFile();
      System.out.println("创建成功");
    }else{
      file.delete();
      System.out.println("删除成功");
    }
  }
  @Test
  public void test7() {
    File file = new File("d:\\io\\io1\\io2");
    boolean mkdir = file.mkdir();
    if(mkdir) {
      System.out.println("创建成功");
    }
  }
}
