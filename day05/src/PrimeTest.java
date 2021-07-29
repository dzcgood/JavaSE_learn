/**
 * @author DzcGood
 * @date 2021/7/28 - 16:04
 */


/*
* 质数输出的实现方式一
* */
public class PrimeTest {
    //100以内所有质数的输出方法一
    public void methodOne(){
        long start =  System.currentTimeMillis();//开始时间
        //暴力解法，从2开始到n-1开始都不能被整除
        boolean flag = true;
        for (int i = 2; i < 100000; i++) {
            for (int j = 2; j < i; j++) {
                if(i % j == 0){//说明不是质数
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                System.out.print(i + " ");
            }
            flag = true;//重置flag为true
        }
        long end = System.currentTimeMillis();
        System.out.println(("所需时间为" + (end - start) + "ms"));
    }

    //算法改进
    public void methodTwo(){
        long start =  System.currentTimeMillis();//开始时间
        //暴力解法，从2开始到n-1开始都不能被整除
        boolean flag = true;
        for (int i = 2; i < 100000; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {//优化点
                if(i % j == 0){//说明不是质数
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                System.out.print(i + " ");
            }
            flag = true;//重置flag为true
        }
        long end = System.currentTimeMillis();
        System.out.println(("所需时间为" + (end - start) + "ms"));
    }

    //实现方法三
    public void methodThree(){
        label:for (int i = 2; i < 100000; i++) {
                for (int j = 2; j <= Math.sqrt(i); j++) {//优化点
                    if(i % j == 0){//说明不是质数
                        continue label;
                    }
                }
                //能执行到此步骤的都是质数
                System.out.print(i + " ");
                }
    }

    public static void main(String[] args) {
        PrimeTest test = new PrimeTest();
        test.methodOne();//耗时2000ms
        test.methodTwo();//耗时108ms
        test.methodThree();//耗时与方法二相近

    }
}
