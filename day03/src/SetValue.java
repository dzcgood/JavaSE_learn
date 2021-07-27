/**
 * @author DzcGood
 * @date 2021/7/27 - 13:42
 */

/*
* 赋值运算符 = += -= *= /= %=
* */
public class SetValue {
    public static void main(String[] args) {
        //赋值符号 =
        int i1 = 10;
        int j1 = 10;
        int i2, j2;
        //连续赋值
        i2 = j2 = 10;
        int i3 = 10, j3 = 10;
        // +=
        int num1 = 10;
        num1 += 2;// num1 = num1 + 2
        System.out.println("num1 = " + num1);// num1 = 12
        // %=
        int num2 = 12;
        num2 %= 5;//num2 = num2 % 5;
        System.out.println("num2 = " + num2);//num2 = 2

        // 和普通赋值运算的区别，不会改变数据类型
        short s1 = 10;
        // s1 = s1 +2; 会报错
        s1 += 2;//这个不会报错， 类似于 s1++,都不会改变数据类型

        /*
            开发中，如果虚妄实现+2的操作，有几种方法？(前提： int num = 10;)
            方法1: num = num + 2;
            方法2: num += 2;(推荐使用)
        */
            /*
            开发中，如果虚妄实现+1的操作，有几种方法？(前提： int num = 10;)
            方法1: num = num + 1;
            方法2: num ++;(推荐使用)
            方法3：num += 1;
        */
        int n = 10;
        //不同编译器结果不同，不管
        System.out.println("(n + (n++) + (++n)) = " + (n + n++ + ++n));



    }
}
