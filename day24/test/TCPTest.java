import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author DzcGood
 * @date 2021/10/13 - 23:31
 */

/*
* 实现TCP的网络编程
* 例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
* 例子2：客户端发送文件给服务端，服务端把文件存储在本地
* 例子3：客户端发送文件给服务端，服务端把文件存储在本地，并返回“发送成功给客户端”
 * */
public class TCPTest {
    //  例子1：客户端发送信息给服务端，服务端将数据显示在控制台上
    //客户端
    @Test
    public void client() throws IOException {//记得用try-catch-finally,懒得写了。。。。
        //1、创建Socket对象，指明服务器端的ip和端口号
        InetAddress inet = InetAddress.getByName("127.0.0.1");//这里填写的是服务端的IP
        Socket socket = new Socket(inet, 64323);
        //2、获取一个输出流，用于输出数据
        OutputStream outputStream = socket.getOutputStream();
        //3、写出数据，相当于向客户端发送数据
        outputStream.write("你好，我是客户端".getBytes());
        //4、关闭资源
        outputStream.close();//记得关闭资源
        socket.close();//记得关闭资源
    }

    //服务端
    @Test
    public void server() throws IOException{//记得用try-catch-finally,懒得写了。。。。
        //1、创建服务器端的ServerSocket，指明自己的端口号
        ServerSocket serverSocket = new ServerSocket(64323);//此处的端口号客户机连接的端口号
        //2、调用accept()方法，表示接受来自客户端的socket
        Socket socket = serverSocket.accept();//表示接受客户端连接
        //3、获取输入流
        InputStream inputStream = socket.getInputStream();
//        byte[] buffer = new byte[20];
//        int len;
//        while((len = inputStream.read(buffer)) != -1){
//            String s = new String(buffer, 0, len);
//            System.out.print(s);
//        } //用于处理中文字符会出错
        //4、读取输入流的数据
        byte[] buffer = new byte[10];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len;
        while((len = inputStream.read(buffer)) != -1){
            //这个流类的write方法会写入自身内部的byte数组
            //全部读取完后再toString()这样可以避免出现字节流读取中文字符的乱码问题
            baos.write(buffer, 0 , len);
        }
        //这里调用baos的toString()方法，实际上是调用baos内部的数组的toString()方法
        System.out.println(baos.toString());
        //5、所有资源都需要关闭
        baos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }


    //例子2：客户端发送文件给服务端，服务端把文件存储在本地
    @Test
    public void client1() throws IOException{//记得用try-catch-finally
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("flower.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!= -1){
            outputStream.write(buffer, 0 , len);
        }
        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server1()throws IOException{//记得try-catch-finally
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("flower_copy.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        fos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }

//例子3：客户端发送文件给服务端，服务端把文件存储在本地，并返回“发送成功给客户端”

    @Test
    public void client2() throws IOException{//记得用try-catch-finally
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fis = new FileInputStream("flower.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer))!= -1){
            outputStream.write(buffer, 0 , len);
        }
        //关闭数据的输出
        socket.shutdownOutput();//********************没有此语句的话，会报错******************
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        buffer = new byte[5];
        while((len = inputStream.read(buffer)) != -1){
            baos.write(buffer, 0 ,len);
        }
        System.out.println(baos.toString());
        inputStream.close();
        baos.close();
        fis.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server2()throws IOException{//记得try-catch-finally
        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("flower_copy2.jpg");
        byte[] buffer = new byte[1024];
        int len;
        while((len = inputStream.read(buffer)) != -1){
            fos.write(buffer, 0, len);
        }
        //服务器向客户机发送数据
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("照片已收到".getBytes());
        outputStream.close();
        fos.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
