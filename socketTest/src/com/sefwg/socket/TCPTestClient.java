package com.sefwg.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/*
 * @create author: seafwg
 * @create time: 2020/8/28
 * @describe: TCP的网络编程 - 客户端：
 * demo1: 客户端发送消息给服务端，服务端将数据显示到控制台：
 *
 * 步骤：
 * ①。创建Socket对象，指明服务端的ip和端口号
 * ②。获取一个输出流，用于输出数据
 * ③。写出数据的操作
 * ④。关闭资源
 */
public class TCPTestClient {
  public static void main(String[] args) {
    Socket socket = null;
    OutputStream outputStream = null;
    try {
      //①。实例化InetAddress类，创建Socket对象
      InetAddress name = InetAddress.getByName("127.0.0.1");
      socket = new Socket(name, 9000);
      //②。获取一个输出流
      outputStream = socket.getOutputStream();
      //③。写出要发送的信息
      outputStream.write("你好，我是客户端".getBytes());
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
