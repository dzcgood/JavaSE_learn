/**
 * @author DzcGood
 * @date 2021/7/27 - 17:01
 */
/*
* 三元运算符
* 1、结构： (条件表达式) ? 表达式1 : 表达式2
* 2、若表达式位true，则执行表达式1，否则执行表达式2
* 3、三元运算符可以用 if - else 语句代替
* 4、在可以使用三元运算符和if - else 语句的地方，首选三元运算符
* */
public class SanYuanTest {
    //取两个数的较大值
    public static void main(String[] args) {
        int m = 12;
        int n = 5;
        int max = (m > n)? m : n;
        System.out.println("m = " + m);

        //三元运算符可以嵌套,但不建议这样写
        String maxStr = (m > n)? "m大" : ((m == n)? "一样大" : "n大");
    }
}
