/**
 * @author DzcGood
 * @date 2021/8/21 - 22:42
 */

/*
* 多线程
* 1、多线程的创建建
*   1.1 方式一：继承于Thread类
*       > 创建一个继承于Thread类的子类
*       > 重写Thread类的run()方法 --> 将此线程执行的操作声明在run()中
*       > 创建Thread类的子类的对象
*       > 通过此对象调用start()方法
*       例子：遍历100以内的所有的偶数
* */
public class ThreadTest {
    public static void main(String[] args) {
        //创建Thread类的子类的对象
        MyThread myThread = new MyThread();
        //通过此对象调用start()方法:①启动该线程 ②JVM调用该线程的run()方法
        myThread.start();
        //如下语句仍然是在main()线程执行的
        System.out.println("Hello"); //两个线程的执行顺序是随机的
        //问题一：如果直接调用run()而不调用start()，则不是新开启一个线程，只是调用了这个对象的run方法而已
        myThread.run();//和main()方法在同一个线程
        //问题二：不可以让已经start的线程去执行start，应该新建一个新的线程对象
//        myThread.start();//会报错
        //正确做法：重新创建线程对象，调用start()方法
        new MyThread().start();
    }
}

//创建一个继承于Thread类的子类
class MyThread extends Thread{
    //重写Thread类的run()方法
    @Override
    public void run(){
        for (int i = 0; i < 100; i+=2) {
            System.out.println(i);
        }
    }
}
