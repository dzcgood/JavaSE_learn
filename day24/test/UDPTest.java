import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

/**
 * @author DzcGood
 * @date 2021/10/15 - 14:40
 */

/*
* UDP协议的例子
* */
public class UDPTest {
    //发送端
    @Test
    public void sender() throws IOException {
        DatagramSocket socket = new DatagramSocket();//不使用参数
        String str = "我是UDP方式发送的数据";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        //将需要发送的数据封装在datagramPacket
        DatagramPacket packet = new DatagramPacket(data, 0 , data.length, inet, 9090);
        socket.send(packet);
        socket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException{
        DatagramSocket socket = new DatagramSocket(9090);//指明端口号
        byte[] data = new byte[100];
        DatagramPacket packet = new DatagramPacket(data, 0, data.length);
        socket.receive(packet);
        //packet中的getLength()方法可以返回长度
        //getData()返回的其实就是byte[]
        System.out.println(new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
