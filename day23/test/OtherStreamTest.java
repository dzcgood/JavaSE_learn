import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author DzcGood
 * @date 2021/10/8 - 23:32
 */

/*
* 其它流的使用
* 1、标准输入、输出流
* 2、打印流
* 3、数据流
* */
public class OtherStreamTest {

    /*
    * 1、标准的输入、输出流
    *   System.in：标准的输入流，默认从键盘输入
    *   System.out:标准的输出流，默认从控制台输出
    * 2、System类的setIn(InputStream)和setOut(PrintStream)可以使输入输出重定向
    * 3、练习：从键盘输入字符串直到e或者exit时退出，将输入的字符串转成大写输出
    *   > 方法一：使用Scanner实现，调用next()返回字符串
    *   > 方法二：使用System.in实现：System.in ---> 转换流 ---> BufferedInputStream中的readLine()
    * */
    public static void main(String[] args) {
        //@Test中不能进行输入输出操作，所以放在main中
        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
            while(true){
                System.out.println("请输入字符串");
                String data = br.readLine();
                if("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)){
                    System.exit(0);
                    System.out.println("程序结束");
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
