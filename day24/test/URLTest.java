import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author DzcGood
 * @date 2021/10/15 - 14:59
 */

/*
* URL网络编程
* 1、URL：统一资源定位符，对应着互联网的某一资源地址
* 2、格式：
*   http://localhost:8080/examples/flower?uername=Tom&id=1001
*   协议      主机名  端口号      资源地址        参数列表
* */
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/flower?uername=Tom&id=1001");
            //获取协议
            System.out.println(url.getProtocol());//http
            //获取主机名
            System.out.println(url.getHost());//localhost
            //获取端口号
            System.out.println(url.getPort());//8080
            //获取文件路径
            System.out.println(url.getPath());//    /examples/flower
            //获取URL文件名
            System.out.println(url.getFile());//    /examples/flower?uername=Tom&id=1001
            //获取URL的查询名（即参数）
            System.out.println(url.getQuery());//uername=Tom&id=1001
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //通过URL下载文件
    //因为未配置tomcat，此代码暂时无法运行
    @Test
    public void URLtest1() throws IOException{//记得用try-catch-finally
        URL url = new URL("http://localhost:8080/examples/flower.jpg?uername=Tom&id=1001");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();//得到一个URL连接
        urlConnection.connect();//连接
        InputStream is = urlConnection.getInputStream();//获取输入流
        FileOutputStream fileOutputStream = new FileOutputStream("flower_copy_3");
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fileOutputStream.write(buffer, 0 ,len);
        }
        //关闭资源
        fileOutputStream.close();
        is.close();
        urlConnection.disconnect();//断开连接
    }
}
