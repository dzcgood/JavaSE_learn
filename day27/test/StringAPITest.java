import org.junit.Test;

/**
 * JDK11新特性：String新增的方法
 * @author DzcGood
 * @date 2021/10/23 - 14:25
 */
public class StringAPITest {
    @Test
    public void test(){
        //isBlank()：没有实际的字符的，就返回true（\t,\n，空格，空字符都不算实际字符）
        System.out.println(" \t \n   ".isBlank());
        //strip()：去除前后的空格、\t、\n等空白
        System.out.println("  hello  ".strip());

        //stripTrailing()：去除尾部空白
        //stripLeading()：去除首部空白

        //repeat(int count)：将字符串重复n次
        System.out.println("5".repeat(5));
        //lines().count()：返回行数
        //首尾的\n是不被算进去的
        String str = "abc\nde\nfg";
        System.out.println(str.lines().count());
    }
}
