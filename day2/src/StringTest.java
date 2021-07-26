/**
 * @author DzcGood
 * @date 2021/7/26 - 20:29
 */

/*
 * 1、声明String变量时，用一对""
 * 2、String可以和8种基本数据类型做连接运算运算符 + ，运算结果为String
 */
public class StringTest {
    public static void main(String[] args) {
        String s1 = "Hello World";
        System.out.println(s1);
        String s2 = "";//表示空字符串
        String s3 = "a";
        //char c1 = ''   (字符串声明不能为空)
        boolean x = true;
        //x + s3 的运算结果为 truea
        System.out.println("(x + s3) = " + (x + s3));

    }
}
