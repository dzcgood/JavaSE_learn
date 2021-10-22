import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * try语句的升级
 * @author DzcGood
 * @date 2021/10/22 - 17:37
 */
public class TryTest {
    /**
     * JDK8之前的情况
     * 资源关闭操作在finally中
     * */
    @Test
    public void test1(){
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(System.in);
            char[] buf = new char[20];
            int len;
            if((len = inputStreamReader.read(buf)) != -1){
                String str = new String(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * jdk8中的资源关闭操作
     * 可以把资源的声明写在try(){}的小括号中，小括号内的资源可以自动关闭
     * 要求执行后必须关闭的资源必须在try子句的小括号中声明并实例化，否则编译不通过
     * */
    @Test
    public void test2(){
        try(InputStreamReader inputStreamReader = new InputStreamReader(System.in);){
            char[] buf = new char[20];
            int len;
            if((len = inputStreamReader.read(buf)) != -1){
                String str = new String(buf, 0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * jdk9中的资源关闭
     * 可以把资源声明在try外面，然后在try子句中放入资源对象即可
     * 要求：try子句中的对象是默认为final的，如果修改它，就会报错
     * */
    @Test
    public void test3(){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        try(inputStreamReader ){
//            reader = null; //会报错，reader默认是final的，不能修改
            char[] buf = new char[20];
            int len;
            if((len = inputStreamReader.read(buf)) != -1){
                String str = new String(buf, 0, len);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
