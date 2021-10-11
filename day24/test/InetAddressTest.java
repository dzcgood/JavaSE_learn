import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author DzcGood
 * @date 2021/10/10 - 15:29
 */

/*
* 一、网络编程中有两个主要的问题：
*   1、如何准确地定位网络上一台或多态主机；定位主机上的特定的应用
*   2、找到主机后如何可靠高效地进行数据传输
* 二、网络编程中的两个要素：
*   1、对应问题一：IP和端口号
*   2、对应问题二：提供网络通信协议：TCP/IP参考模型
* 三、通信要素一：IP和端口号
*   1、IP：唯一标识Internet上的计算机（通信实体）
*   2、在Java中使用InetAddress类代表IP
*   3、IP分类：IPv4和IPv6；万维网和局域网
*   4、本地回路地址：127.0.0.1，对应着localhost
*   6、如何实例化InetAddress：两个方法①getByName() ②getLocalHost
*       两个常用方法：①getHostName() ②getHostAddress()
*   7、端口号：标实正在计算机上运行的进程，要求不同的进程有不同的端口号
*      > 系统端口号：0~1023，应用端口号：1023~49151，私有端口号：49152~65535
*   8、端口号与IP地址的组合得出一个网络套接字：Socket
*
* */
public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("192.168.10.1");//通过IP地址
            System.out.println(inet1);
            InetAddress inet2 = InetAddress.getByName("www.baidu.com");//通过域名
            System.out.println(inet2);
            //getHostName()：获取主机名
            System.out.println(inet2.getHostName());//www.baidu.com
            //getHostAddress()：获取IP地址
            System.out.println(inet2.getHostAddress());//183.232.231.172
            InetAddress inet3 = InetAddress.getByName("127.0.0.1");//本机地址
            System.out.println(inet3);
            InetAddress localHost = InetAddress.getLocalHost();//获取本机
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
