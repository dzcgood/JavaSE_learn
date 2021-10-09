import org.junit.Test;

import java.io.*;

/**
 * @author DzcGood
 * @date 2021/10/9 - 16:54
 */

/*
* 数据流的使用：用于读取或写出基本数据类型的变量或字符串
* 1、DataInputStream和DataOutputStream
* 2、DataInputStream中的方法
*   > readBoolean       > readByte
*   > readChar          > readFloat
*   > readDouble        > readShort
*   > readLong          > readInt
*   > readUTF           > readFully(byte[] b)
* 3、DataOutputStream中的方法
*   把DataInputStream中的方法的read改成write即可
* 4、注意点:
* 5、缺点：无法存取对象，解决方法：使用对象流
* */
public class DataStreamTest {
    //将内存中的字符串、基本数据类型的变量写出到文件data.txt中
    @Test
    public void test() throws IOException {
        //造流类
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File("data.txt")));
        //写数据
        dataOutputStream.writeUTF("数据输出流测试");
        dataOutputStream.flush();//刷新缓冲区，立刻写入
        dataOutputStream.writeInt(123);
        dataOutputStream.writeChar('a');
        //关闭
        dataOutputStream.close();
    }

    //将文件中存储的基本数据类型变量和字符串读取到内存中
    @Test
    public void test2() throws IOException{
        //造流类
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(new File("data.txt")));
        //读取:必须按照写入的顺序读取
        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readChar());
        dataInputStream.close();
    }
}
