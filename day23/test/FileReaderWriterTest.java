import org.junit.Test;

import java.io.*;

/**
 * @author DzcGood
 * @date 2021/10/6 - 19:37
 */

/*
* 一、流的分类
*   1、按照操作数据单位：字节流、字符流
*   2、按照数据的流向：输入流、输出流
*   3、流的角色：节点流、处理流
* 二、流的体系结构
*   抽象基类            节点流                     缓冲流（处理流中的一种）
*   InputStream        FileInputStream           BufferedInputStream
*   OutputStream       FileOutputStream          BufferedOutputStream
*   Reader             FileReader                BufferedReader
*   Writer             FileWriter                BufferedWriter
* */
public class FileReaderWriterTest {//字符流不能用于处理图片等字节流文件
    //FileReader的使用
    @Test
    public void test1() {
        /*
        * 将day23下的hello.txt文件内容读入程序中，并输出到控制台
        * 说明：
        *   > 为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
        *   > 读入的文件一定要存在，否则就会报FileNotFoundException
        * */
        //1、实例化File类的对象，指明要操作的文件
        File file = new File("hello.txt");//相较于当前Module
        FileReader fileReader = null;
        try {
            //2、提供具体的流
            fileReader = new FileReader(file);
            //3、数据的读入
            //int read()：返回读入的一个字符，如果达到文件末尾，返回-1
            int data;
            while((data = fileReader.read()) != -1){
                System.out.print((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流的关闭操作
            try {
                if(fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //使用read()重载的方法
    @Test
    public void test2(){
        File file = new File("hello.txt");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            //read(char[] cbuf)：返回每次读入cbuf数组中的字符的个数，如果达到文件末尾，返回-1
            while((len = fileReader.read(cbuf)) != -1){//难点，需要特别注意len的作用
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
//                for (char c : cbuf) {//错误的写法
//                    System.out.print(c);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //向写入写入数据
    /*
    * 1、若要写入的文件不存在，则会自动创建文件
    * 2、若要写入的文件存在，则取决于FileWriter构造器中的append参数取值，取值为true，则为追加方式，为false则为覆盖方式
    * */
    @Test
    public void test3(){
        //1、提供File类的对象，指明写出到的文件
        File file = new File("hello1.txt");
        FileWriter fileWriter = null;//以覆盖方式写入文件
        try {
            //2、提供FileWriter类的对象，用于数据的写出
            fileWriter = new FileWriter(file, false);
            //3、写出的操作
            fileWriter.write("I have a dream \n");
            fileWriter.write("You need to have a dream \n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null)
                try {
                    fileWriter.close();//4、流资源的关闭
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
