/**
 * @author DzcGood
 * @date 2021/7/28 - 15:45
 */

/*
* 写while循环千万别忘记迭代条件，少了迭代条件，就可能导致死循环
* do - while 循环至少会执行一次
* */
public class WhileTest {
    public static void main(String[] args) {
        //输出100一位的奇数
        int i = 0;
        while(i <= 100){
            if(i % 2 == 0){
                System.out.println(i);
            }
            i++;
        }
    }

}
