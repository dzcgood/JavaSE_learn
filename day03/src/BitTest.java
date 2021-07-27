/**
 * @author DzcGood
 * @date 2021/7/27 - 16:26
 */
/*
* 位运算符 & | ~ << >> >>> ^
* 结论：
* 1、操作的都是整形数据
* 2、在一定范围内，每向左移1位。相当于 * 2.每向右移一位，相当于 / 2
*
* 面试题：最高效的方式计算 2 * 8
* 答：2 << 3 或者 8 << 1
* */
public class BitTest {
    public static void main(String[] args) {
        int i = 21;

        System.out.println("\"i << 2\" = " + (i << 2));
        // 移动位数太多，符号位变成了1，值变成负数
        System.out.println("\"i << 27\" = " + (i << 27));
        int m = 12;
        int n = 5;
        System.out.println("\"m & n\" = " + (m & n));
        //练习：交换两个变量的值
        int num1 = 10;
        int num2 = 20;

        //方法一：中间变量法
        int temp = num1;
        num1 = num2;
        num2 = temp;

        //方法二：好处：不用定义临时变量，弊端：有溢出风险、有局限性（只能用在数值型）
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;

        //方法三：使用位运算符，有局限性（只能用在数值型）
        num1 = num1 ^ num2;
        num2 = num1 ^ num2;
        num1 = num1 ^num2;
    }
}
