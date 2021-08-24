package exercise;

/**
 * @author DzcGood
 * @date 2021/8/21 - 23:14
 */

/*
* 练习：创建两个分线程，一个遍历100以内奇数，一个遍历100以内偶数
* */
public class ThreadDemo {
    public static void main(String[] args) {
        //因为只使用一次，可以考虑匿名内部类
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 0){
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i < 100; i++) {
                    if (i % 2 == 1){
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            }
        }.start();
    }
}
