/**
 * @author DzcGood
 * @date 2021/7/27 - 23:48
 */

/*
* 随机数的使用
* 1、Math.random() 随机生成 [0.0, 1.0)的小数
*
* 例题 ：彩票系统
* 随机生成一个两位数的彩票，与用户输入相比较，全部一样，则奖励10000美元。全部一样但顺序不对，奖励5000美元，只有一个数字一样，奖励1000美元
* */
public class RandomTest {
    public static void main(String[] args) {
        int value = (int)Math.random() * 90 + 10;//随机生成[10, 99]的整数
        //具体实现略了。。。知道怎么生成随机数就行

    }
}
