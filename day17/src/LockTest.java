import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DzcGood
 * @date 2021/8/23 - 20:04
 */

/*
* 解决线程安全问题的方法三：Lock锁   --- JDK5.0新增
* 1、面试题：synchronized与ReentrantLock的异同
*   1.1 异
*       > synchronized实行完代码后会自动释放同步监视器
*       > ReentrantLock需要手动启动同步（lock）并结束同步（unlock）
*       > 建议优先级：ReentrantLock > 同步代码块 > 同步方法
*   1.2 同
*       > 都可以用来解决线程同步问题
* 2、面试题：如何解决线程安全问题
*   答：同步代码块，同步方法，ReentrantLock锁
* 3、在何时需要考虑线程安全问题？
*   答：有多个线程并且有共享资源的情况下
* */
public class LockTest {
    public static void main(String[] args) {
        Windows w1 = new Windows();
        new Thread(w1).start();
        new Thread(w1).start();
        new Thread(w1).start();
    }
}

class Windows implements Runnable{
    private int ticket = 100;
    //1、实例化一个ReentrantLock的对象
    private ReentrantLock lock = new ReentrantLock(true);//公平的lock，如果是无参，就是不公平的lock
    @Override
    public void run() {
        while(true){
            try {
                //调用lock()方法
                lock.lock();
                if(ticket > 0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "票号为：" + ticket--);
                }else{
                    break;
                }
            } finally {
                //调用解锁方法unlock()
                lock.unlock();
            }
        }
    }
}


