package com.seafwg.streamClass;

import org.testng.annotations.Test;

import java.io.*;

/*
 * @create author: seafwg
 * @create time: 2020/8/26
 * @describe: 缓冲流的使用：
 * 处理流一：缓冲流：
 * ①。缓冲流：
 *  BufferedInputStream
 *  BufferedOutputStream
 *  BufferedReader
 *  BufferedWriter
 * ②。作用：提供流的读取写入的速度。
 *    原因：内部提供了一个缓冲区
 * ③。处理流就是”套接“在已有的流的基础之上。
 */
public class buferedTest {
  /**
   * 利用缓冲流进行大文件的复制操做
   */
  public void copyBigFile(String srcPath, String destPath) {
    BufferedInputStream bufferedInputStream = null;
    BufferedOutputStream bufferedOutputStream = null;
    try {
      //①。创建源
      File srcFile = new File(srcPath);
      File destFile = new File(destPath);
      //②。创建io流[创建缓冲流并套接缓冲流]
      FileInputStream fileInputStream = new FileInputStream(srcFile);
      FileOutputStream fileOutputStream = new FileOutputStream(destFile);

      bufferedInputStream = new BufferedInputStream(fileInputStream);
      bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
      //③。io流的操作
      byte[] buf = new byte[1024*5];
      int len = -1;
      while((len = bufferedInputStream.read(buf)) != -1) {
        bufferedOutputStream.write(buf,0,len);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源[关闭里层的就会自动关闭外层]
      if (bufferedInputStream != null) {
        try {
          bufferedInputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (bufferedOutputStream != null) {
        try {
          bufferedOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  @Test
  public void copyBigFileTest() {
    long startTime = System.currentTimeMillis();
    String srcPath = "F:\\BaiduNetdiskDownload\\2.mp4";
    String destPath = "1234.mp4";
    copyBigFile(srcPath,destPath);
    long endTime = System.currentTimeMillis();
    System.out.println("花费时间为：" + (endTime - startTime));
    // 1.66GB
    // buf[1024] --> 6891
    // buf[1024*3] --> 11237
    // buf[1024*5] --> 9562
  }
}
