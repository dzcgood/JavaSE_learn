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
        rw.write("xyz".getBytes());//因为参数是byte[]
        rw.close();
    }
}
