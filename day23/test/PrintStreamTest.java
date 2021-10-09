import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/**
 * @author DzcGood
 * @date 2021/10/9 - 16:32
 */
/*
* 打印流的使用
* PrintStream和PrintWriter
* 1、提供了一系列重载的print()和printLine()方法
* */
public class PrintStreamTest {
    //练习：重定向控制台的输出到test.txt
    @Test
    public void test() throws IOException {
        //创建打印流，autoFlush设置为true（写入换行符或字节'\n'都会刷新缓冲区）
        PrintStream ps = new PrintStream(new FileOutputStream("test.txt"), true);
        if(ps != null){
            System.setOut(ps);
        }
        for (int i = 0; i <= 255; i++) {//如果没有重定向，则是输出到控制台
            System.out.print((char)i);//调用重载的print(char)方法，如果不强转，调用的是print(int)
            if (i % 50 == 0){
                System.out.println();
            }
        }
    }
}
