/**
 * @author DzcGood
 * @date 2021/8/23 - 0:48
 */

/*
* 使用同步方法来实现进程通信（继承Thread的方式）
* */
public class WindowTest3 {
}

class Window3 extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
            show();
        }
    }
    private static synchronized void show(){//在show方法中，同步监视器就是Window3.class，要加上static
        try {                               //保证锁是唯一的
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为" + ticket--);
        }
    }
}
