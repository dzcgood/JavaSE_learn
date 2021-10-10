import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author DzcGood
 * @date 2021/10/10 - 2:33
 */

/*
* RandomAccessFile类的使用
* 1、既可以作为输入流，又可以作为输出流（建议造两个对象，一个表示输入，一个表示输出）
* 2、mode
*   > r 以只读的方式打开
*   > rw 可以读也可以写
*   > rws 可读写，同步文件内容和元数据的更新
*   > rwd 可读写，同步文件内容的更新
* 3、作为输出流时，如果写入的文件不存在，则会自动创建
*    若写入的文件存在，则默认从头开始覆盖
* 4、seek(int pos)方法可以定位指针位置
* */
public class RandomAccessFileTest{
    @Test
    public void test() throws IOException {
        RandomAccessFile randomAccessFile = null;
        RandomAccessFile randomAccessFile1 = null;
        try {
            randomAccessFile = new RandomAccessFile(new File("花.jpg"), "r");
            randomAccessFile1 = new RandomAccessFile(new File("花_randomCopy.jpg"), "rw");
            byte[] buffer = new byte[1024];
            int len;
            while ((len = randomAccessFile.read(buffer)) != -1) {
                randomAccessFile1.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (randomAccessFile1 != null) {
                try {
                    randomAccessFile1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test2() throws IOException{
        RandomAccessFile rw = new RandomAccessFile("randomTest.txt", "rw");
        rw.seek(3);//将指针调到角标为3的位置，角标是从0开始的
        //其实write执行的就是覆盖的操作
//        rw.write("xyz".getBytes());//因为参数是byte[]，这里执行的是覆盖
        //下面实现插入（而不是覆盖），先复制后面部分，然后执行写入，最后把复制好的再写入到文件后面
        //1、保存指针3后面的数据到StringBuilder中
        byte[] buffer = new byte[20];
        //使用StringBuilder，长度设置为文件长度
        StringBuilder builder = new StringBuilder((int)new File("randomTest.txt").length());
        int len;
        while((len = rw.read(buffer))!= -1){
            builder.append(new String(buffer, 0 , len));
        }
        //读取完后，指针指向文件末尾，所以要重新定位
        rw.seek(3);
        //写入要插入的字符串
        rw.write("xyz".getBytes());
        //写入刚才复制的字符串
        rw.write(builder.toString().getBytes());//StringBuilder没有getBytes()方法，所以先转换成String再调用toString()
        //关闭流
        rw.close();
    }
}
