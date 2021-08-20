import jdk.nashorn.internal.runtime.arrays.ArrayIndex;
import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/18 - 21:18
 */
public class ExceptionTest {
    @Test
    public void numerFormatException(){
        try{
            String str = "abc";
            int num = Integer.parseInt(str);
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
            //e.printStackTrace();
            System.out.println("出现数值转换异常...");
        }finally{
            System.out.println("一定会执行的代码");
        }
        System.out.println("jjj");
    }
}
