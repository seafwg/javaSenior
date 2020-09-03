package com.sefwg.socket;


import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * @create author: seafwg
 * @create time: 2020/8/27
 * @describe: 网络编程：
 * 一，网络编程中两个主要的问题：
 *  ①。如何准确地找到网络上一台或多台主机；定位主机上的特定的应用
 *  ②。找到主机后如何可靠高效地进行数据传输
 * 二，网络编程中的两个要素：
 *  ①。IP和端口号
 *  ②。提供网络通信协议：TCP/IP参考模型(应用层，传输层，网络层，物理层+数据链路层)
 *
 * 三，通信要素一：IP和端口号
 *  ①。IP:唯一标识Internet上的计算机(通信实体)
 *  ②。在Java中使用InetAddress类代表IP
 *  ③。IP分类：IPv4,IPv6;万维网和局域网
 *  ④。域名：www.baidu.com ...
 *  ⑤。本地回路地址：127.0.0.1 = localhost
 *  ⑥。实例化InetAddress类的两个方法：getByName(String host),getLocalHost();
 *     两个常用方法：getHostName() / getHostAddress()
 *  ⑦。端口号：正在计算机上运行的进程
 *  ⑧。IP地址和端口号组合得出一个网络套接字:Socket
 */
public class SocketTest {

  public static void main(String[] args) {
    try {
      //实例化InetAddress类：
      InetAddress inet1 = InetAddress.getByName("10.2.219.163");
      System.out.println(inet1); //  /10.2.219.163  [返回路径]
      InetAddress name = InetAddress.getByName("www.baidu.com");
      System.out.println(name); //  www.baidu.com/14.215.177.38
      System.out.println("getHostName:" + name.getHostName()); // www.baidu.com
      System.out.println("getHostAddress:" + name.getHostAddress()); // 14.215.177.39

      InetAddress inet2 = InetAddress.getByName("127.0.0.1");
      System.out.println("inet2:" + inet2); //  /127.0.0.1

      // 获取本地IP:
      InetAddress localHost = InetAddress.getLocalHost();
      System.out.println(localHost);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

}
