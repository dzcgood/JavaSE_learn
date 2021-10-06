import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author DzcGood
 * @date 2021/10/6 - 20:52
 */

/*
* FileInputStream与FileOutputStream的使用
* */
public class FileInputOutputStreamTest {
    /*
    * 字节流不能用来读取单个字符长度超过1字节的文本文件
    * 结论：对于文本文件（.txt\.java\.cpp），使用字符流处理；
    * 对于非文本文件(.jpg\.mp3\.avi\.doc\.ppt等)，使用字节流处理
    * */
    @Test
    public void test1(){
        File file = new File("hello.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] buffer = new byte[5];
            int len;
            while((len = fileInputStream.read(buffer)) != -1){
                String s = new String(buffer, 0 ,len);
                System.out.print(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    * 实现一张图片的复制操作
    * */
    @Test
    public void test2(){
        //建File
        File src = new File("花.jpg");
        File dest = new File("花_copy.jpg");
        //建流类
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);
            byte[] buffer = new byte[5];
            int len;
            //复制的过程
            while((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0 ,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭
            if(fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
