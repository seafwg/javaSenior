package com.seafwg.streamClass;

import org.testng.annotations.Test;

import java.io.*;

/*
 * @create author: seafwg
 * @create time: 2020/8/26
 * @describe: 流的分类和流的体系结构：
 * 一，流的分类：
 *  1.操作数据单位：字节流[后缀为stream]，字符流[后缀为：Reader,Writer]
 *  2.数据的流向：输入，输出流
 *  3.流的角色：节点流，处理流
 *
 * 二, 流的体系结构：
 *  抽象基类：       节点流(或文件流)                                   缓冲流(处理流的一种)
 *  InputStream     FileInputStream  (read(byte[] buffer))           BufferedInputStream  (read(byte[] buffer))
 *  OutputStream    FileOutputStream  (write(byte[] buffer,0,len))   BufferedOutputStream  (write(byte[] buffer,0,len))
 *  Reader          FileReader (read(char[] cbuf))                   BufferedReader  (read(char[] cbuf)  / readLine())
 *  Writer          FileWrite  (write(char[] cbuf,0,len))            BufferWriter  (write(char[] cbuf,0,len) / flush())
 *
 * [说明]
 * ①。read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
 * ②。异常处理：为了保证流资源一定可以执行关闭操作。需要使用try-catch-finally处理。
 * ③。读入的文件一定要存在，否则就会保FileNotFoundException
 *
 * 步骤：
 * ①。实例化File类的对象，指明要操作的文件
 * ②。提供具体的流
 * ③。数据的读入
 * ④。流的关闭操作
 *
 *
 * 1）创建源或者目标对象（拿文件流举例）
      输入操作：把文件中的数据流向到程序中，此时文件是源，程序是目标.
      输出操作：把程序中的数据流向到文件中，此时文件是目标，程序是源.
  2）创建IO流对象
      输入操作：创建输入流对象.
      输出操作：创建输出流对象.
  3）具体的IO操作
      输入操作：输入流对象的read方法.
      输出操作：输出流对象的write方法.
  4):关闭资源(勿忘).：一旦资源关闭之后，就不能使用流对象了，否则报错.
      输入操作：输入流对象.close()
 *
 * 结论：
 * ①。对于文本文件(.txt,.java,.c,.cpp),使用字符流处理[以后缀为writer/reader结尾的流操作]
 * ②。对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...),使用字节流处理[以后缀为stream结尾的流的操作]
 *  使用字节流FileInputStream处理文本文件，可能出现乱码。
 *
 *
 */
public class streamClass1 {

  @Test
  public void testFileReader() {
    FileReader fileReader = null;
    try {
      // ①。实例化File类的对象，并指明要操作的文件：
      File file = new File("hello.txt");
      // ②。提供具体的流
      fileReader = new FileReader(file);
      // 使用字符流读取，read()方法返回的字符的数值，所以要按照流的类型转换[字符的char转换，字节的byte转换]
      // ③。数据的读入
      int data;
      while((data = fileReader.read()) != -1) {
        System.out.print((char) data);
//        System.out.print(data); read()返回的是读入的
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      // ④。关闭资源：
      if(fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  // 对read()方法使用重载：
  @Test
  public void testFileRead1() {
    FileReader fileReader = null;
    try {
      //①。实例化File类，指明操作的文件：
      File file = new File("hello.txt");
      //②。提供具体的流操作：
      fileReader = new FileReader(file);
      //③。数据的读入操作：
      //read(char[] cbuf):返回每次读入cbuf数组中的字符的个数
      char[] cbuf = new char[5];
      int len;
      while((len=fileReader.read(cbuf)) != -1) {
        // len如果是字符返回0-65536之间的数字，读完返回-1，也就退出循环
//        for (int i = 0;i < len;i++) {
//          System.out.print(cbuf[i]);
//        }
//        String string = new String(cbuf, 0, len);
//        System.out.print(string);
        String str = new String(cbuf, 0, len);
        System.out.print(str);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源：
      if (fileReader != null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /*
    从内存中写出数据到硬盘的文件里。
    说明：
    1. 输出操作，对应的File可以不存在的。并不会报异常
    2. File对应的硬盘中的文件如果不存在，在输出的过程中，会自动创建此文件。
       File对应的硬盘中的文件如果存在：
                如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
                如果流使用的构造器是：FileWriter(file,true):不会对原有文件覆盖，而是在原有文件基础上追加内容
   */
  @Test
  public void testFileWrite() {
    FileWriter fileWriter = null;
    try {
      // ①。创建源[目标对象]
      File file = new File("hello.txt");
      // ②。创建IO流对象
      fileWriter = new FileWriter(file,true);
      // ③。写出操作
      fileWriter.write("I have a dream！\n");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源
      if(fileWriter!=null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 文件的拷贝：
   */
  @Test
  public void testFileReadToWrite() {
    FileReader fileReader = null;
    FileWriter fileWriter = null;
    try {
      //①。创建源[都如何写出的目标]
      File srcFile = new File("hello.txt");
      File destFile = new File("hi1.txt");
      //②。创建IO流对象
      fileReader = new FileReader(srcFile);
      fileWriter = new FileWriter(destFile);
      //③。IO操作
      char[] chars = new char[5];
      int len = -1;
      while((len = fileReader.read(chars)) != -1) {
        fileWriter.write(chars,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源
      if (fileReader!=null) {
        try {
          fileReader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileWriter!=null) {
        try {
          fileWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 实现图片或者视频的拷贝：
   */
  @Test
  public void testCopyImg() {
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      //①。创建源
      File srcFile = new File("javacore4.pdf");
      File destFile = new File("java.pdf");
      //②。创建IO流
      fileInputStream = new FileInputStream(srcFile);
      fileOutputStream = new FileOutputStream(destFile);
      //③。操作IO流
      byte[] buf = new byte[1024];
      int len = -1;
      while((len = fileInputStream.read(buf)) != -1) {
        fileOutputStream.write(buf,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源
      if (fileInputStream!=null) {
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileOutputStream!=null) {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 封装成一个指定目录下的拷贝非文本文件的方法：
   */
  public void copyFile(String srcPath, String destPath) {
    FileInputStream fileInputStream = null;
    FileOutputStream fileOutputStream = null;
    try {
      //①。创建源[读入目标，写入目标]
      File srcFile = new File(srcPath);
      File destFile = new File(destPath);
      //②。创建io流[字节流，分别是读入，写出]
      fileInputStream = new FileInputStream(srcFile);
      fileOutputStream = new FileOutputStream(destFile);
      //③. 操作io流[先读后写]
      byte[] buf = new byte[1024*10];
      int len = -1;
      while((len = fileInputStream.read(buf)) != -1) {
        fileOutputStream.write(buf,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源
      if (fileInputStream!=null) {
        try {
          fileInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fileOutputStream!=null) {
        try {
          fileOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }


  @Test
  public void testCopyFile() {
    long startTime = System.currentTimeMillis();
    String srcPath = "F:\\BaiduNetdiskDownload\\2.mp4";
    String destPath = "123456.mp4";
    copyFile(srcPath,destPath);
    long endTime = System.currentTimeMillis();
    System.out.println("花费时间为：" + (endTime - startTime));
    // 1.66GB
    // buf[1024] --> 20902
    // buf[1024*3] --> 10509
    // buf[1024*5] --> 7873
  }

}
