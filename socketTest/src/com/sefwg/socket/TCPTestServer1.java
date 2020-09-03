package com.sefwg.socket;

/*
 * @create author: seafwg
 * @create time: 2020/8/28
 * @describe: 实现TCP网络编程：
 * demo1: 从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。
 * 服务端分析：
 * ①。创建一个ServerSocket对象，监听一个端口。
 * ②。调用accept()接收客户端socket对象的信息
 * ③。获取一个输入流，作用域socket的对象
 * ④。创建一个文件对象，输出流对象，用于写入从客户端发过来的信息
 * ⑤。读取文件，写入文件
 * ⑥。服务器端给与客户端反馈
 * ⑦。关闭资源
 */
public class TCPTestServer1 {
}
