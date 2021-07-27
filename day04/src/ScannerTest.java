import java.util.Scanner;

/**
 * @author DzcGood
 * @date 2021/7/27 - 22:32
 */

/*
* 从键盘获取输入，需要使用Scanner类
* 具体实现步骤：
* 1、导包 import java.util.Scanner;
* 2、Scanner的实例化Scanner scan = new Scanner(System.in);
* 3、调用Scanner的相关方法获取输入
* 如果输入类型不符合要求，会抛出异常，InputMisMatchException
*
* */
public class ScannerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        System.out.println("num1 = " + num1);
        String s1 = scan.nextLine();
        System.out.println("s1 = " + s1);
        //对于char型的获取，Scanner没有提供相关API，只能通过String类型获取
        String char1 = scan.next();//输入一个字符即可，但是会被当成String接受
        char firstChar = scan.next().charAt(0);//这样就可以获取字符了
    }
}
