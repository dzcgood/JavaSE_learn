/**
 * @author DzcGood
 * @date 2021/7/27 - 13:31
 */

/*
* 1、随意给一个数字，写出其个位，十位，百位的数字
*    如：153 的个位是3，十位是5，百位是1
* */
public class AriExercise {
    public static void main(String[] args) {
        int number = 153;
        int 个位 = number % 10;
        System.out.println("个位 = " + 个位);
        int 十位 = number % 100 /10;
        System.out.println("十位 = " + 十位);
        int 百位 = number / 100;
        System.out.println("百位 = " + 百位);
    }
}
