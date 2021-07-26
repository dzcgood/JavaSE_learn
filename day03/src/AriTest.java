/**
 * @author DzcGood
 * @date 2021/7/27 - 0:12
 */

/*
* 1、算数运算符 + - * / +(正) -(负)  ++(前) ++(后) --(前) --(后) %
*
* */
public class AriTest {
    public static void main(String[] args) {
        //除号
        int num1 = 12;
        int num2 = 5;
        int result = num1 / num2;
        System.out.println("result = " + result);//result = 2
        int result2 = num1 / num2 * num2;
        System.out.println("result2 = " + result2);//result2 = 10

        double result3 = num1 / num2;
        System.out.println("result3 = " + result3);//result3 = 2.0

        double result4 = num1 / num2 +0.0;
        System.out.println("result4 = " + result4);//result4 = 2.0

        double result5 = num1 / (num2+0.0);
        System.out.println("result5 = " + result5);//result5 = 2.4

        double result6 = (double)num1 / num2;
        System.out.println("result6 = " + result6);//result6 = 2.4

        double result7 = (double)(num1 / num2);
        System.out.println("result7 = " + result7);//result7 = 2.0

        //取余运算 %
        //结果的符号与被模的符号相同
        int m1 = 12;
        int n1 = 5;
        System.out.println("m1 % n1 = " + m1 % n1);

        //取余运算 %
        int m2 = -12;
        int n2 = 5;
        System.out.println("m2 % n2 = " + m2 % n2);

        //取余运算 %
        int m3 = 12;
        int n3 = -5;
        System.out.println("m3 % n3 = " + m3 % n3);

        //取余运算 %
        int m4 = -12;
        int n4 = -5;
        System.out.println("m4 % n4 = " + m4 % n4);

        //前++，先自增，后运算
        int a1 = 10;
        int b1 = ++a1;
        System.out.println("a1 = " + a1 + " b1 = "+ b1);
        //后++，先运算，后自增
        int a2 = 10;
        int b2 = a2++;
        System.out.println("a2 = " + a2 + " b2 = "+ b2);

        // ++ 和 -- 运算符不会改变原有数据类型，例：
        short s1 = 10;
        //s1 = s1 +1; 会报错
        s1++;//这样就可以了
        byte s2 = 10;
        //s2 = s2 + 1; 会报错
        s2++;//这样就可以了

        //前--，先自减，后运算
        int a3 = 10;
        int b3 = --a3;
        System.out.println("a3 = " + a3 + " b3 = "+ b3);
        //后--，先运算，后自减
        int a4 = 10;
        int b4 = a4--;
        System.out.println("a4 = " + a4 + " b4 = "+ b4);
    }
}
