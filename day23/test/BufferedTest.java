import org.junit.Test;

import java.io.*;

/**
 * @author DzcGood
 * @date 2021/10/6 - 21:43
 */

/*
* 缓冲流的使用
* 1、缓冲流：BufferedInputStream、BufferedOutputStream、BufferedReader、BufferedWriter
* 2、作用：提升流读取、写入的速度
* 3、处理流，就是”套接“在已有的流的基础上
* */
public class BufferedTest {
    /*
    * 实现非文本文件的复制
    * */
    @Test
    public void test1(){
        //造文件
        File src = new File("花.jpg");
        File dest = new File("花_copy2.jpg");
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            //造流：处理流作用在节点流之上
            bufferedInputStream = new BufferedInputStream(new FileInputStream(src));
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
            //复制的细节
            byte[] buffer = new byte[10];
            int len;
            while((len = bufferedInputStream.read(buffer))!= -1){
                bufferedOutputStream.write(buffer, 0, len);
//                bufferedOutputStream.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            // 原则上，四个都要关，先关闭处理流，再关闭节点流
            // 特性：在关闭外层流的同时，内层流也会自动关闭，所以只关闭处理流即可
            try {
                if(bufferedInputStream != null)
                    bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //BufferedReader和BufferedWriter的使用
    @Test
    public void test2(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            //造对象
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello_copy.txt")));
            char[] cbuf = new char[5];
            //方法一
            /*int len;
            //读写操作
            while((len = bufferedReader.read(cbuf))!= -1){
                bufferedWriter.write(cbuf,0,len);
    //            bufferedWriter.flush();
            }*/
            //方法二：使用String
            String str;
            while((str = bufferedReader.readLine()) != null){//这个方法读不出来换行符
                bufferedWriter.write(str + '\n');//手动添加换行符
//                bufferedWriter.newLine();//添加换行符，和手动添加'\n'效果相同
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bufferedWriter != null)
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
