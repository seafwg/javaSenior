package com.sefwg.socket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @create author: seafwg
 * @create time: 2020/8/28
 * @describe: TCP的网络编程 - 服务端：
 * demo1: 客户端发送消息给服务端，服务端将数据显示到控制台：
 *
 * 步骤：
 * ①。创建服务端serverSocket,并指明客户端端口
 * ②。调用accept()方法接收客户端的socket
 * ③。获取输入流的对象
 * ④。读取输入流中的数据，并输出数据
 * ⑤。关闭资源
 */
public class TCPTestServer {
  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    Socket accept = null;
    InputStream inputStream = null;
    ByteArrayOutputStream byteArrayOutputStream = null;
    try {
      //①。创建服务端ServerSocket的对象，指明端口
      serverSocket = new ServerSocket(9000);
      //②。调用accept()方法接收客户端的socket
      accept = serverSocket.accept();
      //③。获取输入流对象，用于接收客户端发过来的信息
      inputStream = accept.getInputStream();
      //④。读取数据并写入。
      byteArrayOutputStream = new ByteArrayOutputStream();//创建ByteArrayOutputStream流用于写入读进来的数据
      byte[] buf = new byte[5];
      int len = -1;
      while((len = inputStream.read(buf)) != -1) {
        byteArrayOutputStream.write(buf,0,len);
      }
      System.out.println("收到了来自于：" + accept.getInetAddress().getHostAddress() + "的数据");
      System.out.println(byteArrayOutputStream.toString());
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      //⑤。关闭资源
      if (byteArrayOutputStream != null) {
        try {
          byteArrayOutputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (accept != null) {
        try {
          accept.close();
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
}
