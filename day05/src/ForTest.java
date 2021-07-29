import java.util.Scanner;

/**
 * @author DzcGood
 * @date 2021/7/28 - 15:33
 */

/*
* 输入两个数m, n求m和n的最小公倍数和最大公约数
* */
public class ForTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //获取输入
        System.out.println("请输入m");
        int m = scan.nextInt();
        System.out.println("请输入n");
        int n = scan.nextInt();
        //取最小值
        int min = (m < n)? m : n;
        for (int i = min; i >= 1; i--) {
            if(m % i == 0 && n % i == 0){
                System.out.println("最大公约数是" + i);
                break;
            }
        }
        //取最大值
        int max = (m > n)? m : n;
        for (int i = 1;; i++) {
            if(max * i % m == 0 && max * i % n == 0){
                System.out.println(("最小公倍数是" + max * i));
                break;
            }
        }
    }
}
