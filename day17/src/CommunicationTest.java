/**
 * @author DzcGood
 * @date 2021/8/24 - 15:54
 */

/*
* 进程通信的例子：两个线程分别交替打印数字1-100
* 涉及到的三个方法：
*   ①wait() 一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器（锁）
*   ②notify() 一旦执行此方法，就会唤醒一个被wait()的方法，如果有多个线程被wait()，就唤醒优先级高的
*   ③notifyAll() 一旦执行此方法，就会唤醒所有被wait()的方法
* 使用前提：
*   ①wait(),notify(),notifyAll()用于进程通信时，只能在同步代码块或者同步方法中使用
*   ②wait(),notify(),notifyAll()三个方法的调用者必须是同步代码块或同步方法中的同步监视器，
*     否则会抛出IllegalMonitorStateException
* 面试题：sleep()和wait()方法的异同？
*   1、相同点：调用后都可以使得线程进入阻塞状态
*   2、不同点
*       > 两个方法声明的位置不同，sleep()声明在Thread类，wait()声明在Object
*       > sleep可以在任何需要的情况下调用，wait()必须使用在同步代码块或同步方法中
*       > 关于是否释放同步监视器：如果两个方法都使用在同步代码块或同步方法中，sleep不会释放同步监视器，wait会释放同步监视器
*
* */
public class CommunicationTest {
    public static void main(String[] args) {
        Communication c = new Communication();
        new Thread(c).start();
        new Thread(c).start();
    }
}


class Communication implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        while(true){
            synchronized (this) {
                this.notifyAll();//唤醒其他所有线程
                if(number <= 100){
                    System.out.println(Thread.currentThread().getName() + ":" + number++);
                    try {
                        this.wait();//阻塞该线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}