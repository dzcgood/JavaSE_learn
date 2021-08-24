/**
 * @author DzcGood
 * @date 2021/8/22 - 14:37
 */

/*
* 创建多线程的方式二：实现Runnable接口
* 1、创建一个实现了Runnable接口的类
* 2、实现类去实现Runnable中的抽象方法：run()
* 3、创建实现类的对象
* 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
* 5、通过Thread类的对象调用start()
*
*
* 两种创建线程的方式：
* 1、开发中优先选择实现Runnable的方式
*   原因：
*       > 实现的方式没有类继承的局限性（单继承）
*       > 实现的方式更适合处理多个线程有共享数据的情况
* 2、联系：Thread本身就实现了Runnable
* 3、相同点：两种方式都需要重写run()方法，将需要执行的操作写在run()方法中
* */
public class ThreadTest1 {
    public static void main(String[] args) {
        //创建实现类的对象
        MThread mThread = new MThread();
        //将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread = new Thread(mThread);
        //通过Thread类的对象调用start()
        thread.start();
        //再启动一个线程，遍历100以内偶数
        Thread thread1 = new Thread(mThread);
        thread1.start();
    }
}

//创建一个实现了Runnable接口的类
class MThread implements Runnable{
    //实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println(Thread.currentThread().getName() + "：" + i);
            }
        }
    }
}
