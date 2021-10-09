import org.junit.Test;

import java.io.*;

/**
 * @author DzcGood
 * @date 2021/10/8 - 1:23
 */

/*
* 处理流二：转换流
* 1、属于字符流
* 2、包括
*   > InputStreamReader：将一个字节的输入流转换为字符的输入流
*   > OutputStreamWriter：将一个字符的输出流转换为字节的输出流
* 3、作用：提供字节流与字符流之间的转换
* 4、解码：字节、字节数组 ---> 字符数组、字符串
*    编码：字符数组、字符串---> 字节、字节数组
* 5、字符集：
*   > ASCII：美国标准信息交换码，用一个字节的7位表示
*   > ISO8859-1:拉丁码表，欧洲码表，用一个字节的8位表示
*   > GB2312：中国的中文编码表，最多两个字节编码所有字符
*   > GBK：中国的中文编码表升级，融合了更多的中文文字符号，最多两个字节编码
*   > Unicode：国际标准码，融合了目前人类使用的所有字符，为每一个字符分配唯一的字符码，每个字符使用2字节
*   > UTF-8：变长的编码方式，可用1-4个字节来表示一个字符
*   > ANSI：系统默认字符集，英文系统是ISO8859-1,中文操作系统是GBK
* */
public class ChangeStreamTest {
    /*
    * InputStreamReader的使用：实现字节输入流到字符流的转换
    * 应该使用try-catch-finally处理异常，这里懒得写了，直接throws IOException
    * */
    @Test
    public void test1() throws IOException {
        FileInputStream fis = new FileInputStream(new File("hello.txt"));
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认字符集
        //参数2指明了字符集，根据文件的编码字符集选择解码字符集
        InputStreamReader isr1 = new InputStreamReader(fis, "UTF-8");//使用系统默认字符集
        char[] cbuf = new char[20];
        int len;
        while((len = isr1.read(cbuf))!= -1){
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }
        isr1.close();
    }

    /*
    * InputStreamReader和OutputStreamWriter的综合使用：读取utf-8的文件，并以gbk编码存储
    * 应该使用try-catch-finally处理异常，这里懒得写了，直接throws IOException
    * */
    @Test
    public void test2() throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("hello.txt")));
        //以GBK字符集写入
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("hello_gbk.txt")),"GBK");
        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1){
            String s = new String(cbuf, 0, len);
            osw.write(s);
            System.out.print(s);
        }
        isr.close();
        osw.close();
    }
}
