package com.sefwg.socket;

/*
 * @create author: seafwg
 * @create time: 2020/8/28
 * @describe: 实现TCP网络编程：
 * demo1: 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 客户端分析：
 * ①。创建Socket对象，实例化InetAdress IP和端口
 * ②。获取一个输出流对象，用于写入将要发送的文件
 * ③。创建File对象，输入流对象，读取将要发送的文件，并写入输出流中。
 * ④。关闭数据的输出
 * ⑤。通过socket对象获取输入流对象，并显示到控制台
 *    1）。通过客户端socket实例获取输入流对象，用于读取服务端的反馈
 *    2）。创建ByteArrayOutputStream()对象用于接收服务端发过来的socket信息
 * ⑥。关闭资源
 */
public class TCPTestClient1 {
}
