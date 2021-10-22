import org.junit.Test;

import java.io.*;

/**
 * JDK9中InputStream的新方法：transferTo()
 * @author DzcGood
 * @date 2021/10/22 - 22:20
 */
public class InputStreamTest {
    @Test
    public void test(){

        try(InputStream is = new FileInputStream("test/hello.txt");
            OutputStream os = new FileOutputStream("test/hello1.txt");){
            is.transferTo(os);//把输入流中的所有数据直接自动地赋值到输出流中
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
