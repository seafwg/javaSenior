package com.sefwg.socket;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @create author: seafwg
 * @create time: 2020/8/28
 * @describe: TCP的网络编程：
 * demo1: 客户端发送消息给服务端，服务端将数据显示到控制台：
 */
public class TCPTest1 {

  // 服务端：

  /**
   * 步骤：
   * ①。创建服务端serverSocket,并指明客户端端口
   * ②。调用accept()方法接收客户端的socket
   * ③。获取输入流的对象
   * ④。读物输入流中的数据，并输出数据
   * ⑤。关闭资源
   */
  @Test
  public void server() {
    ServerSocket serverSocket = null;
    Socket acceptSocket = null;
    InputStream is = null;
    ByteArrayOutputStream baos = null;
    try {
      //①。创建服务端serverSocket,指明端口号：
      serverSocket = new ServerSocket(9000);
      //②。调用accept()接收客户端的socket
      acceptSocket = serverSocket.accept();
      //③。获取输入流
      is = acceptSocket.getInputStream();
      //④。读取输入流中的数据：[都出来后写入一个数据缓存中]
      baos = new ByteArrayOutputStream();
      byte[] buffer = new byte[5];
      int len = -1;
      while ((len = is.read(buffer)) != -1) {
        baos.write(buffer, 0, len);
      }
      System.out.println("收到了来自：" + serverSocket.getInetAddress().getHostAddress() + "的数据");
      System.out.println(baos.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //⑤。关闭资源
      if (baos != null) {
        try {
          baos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (is != null) {
        try {
          is.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (acceptSocket != null) {
        try {
          acceptSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (serverSocket != null) {
        try {
          serverSocket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  // 客户端：
  @Test
  public void client() {
    Socket socket = null;
    OutputStream outputStream = null;
    try {
      //①。创建Socket对象，指明服务端的ip和端口号
      InetAddress inet = InetAddress.getByName("127.0.0.1");
      socket = new Socket(inet, 9000);
      //②。获取一个输出流，用于输出数据
      outputStream = socket.getOutputStream();
      //③。写出数据的操作
      outputStream.write("你好！".getBytes());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //④。关闭资源
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (socket != null) {
        try {
          socket.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

}
