/**
 * @author DzcGood
 * @date 2021/8/23 - 0:42
 */

/*
* 通过同步方法实现进程通信（实现Runnable的方法创建线程）
* */
public class WindowTest2 {

}

class Window2 implements Runnable{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true){
               show();
        }
    }
    private synchronized void show(){//在show方法中，同步监视器就是this
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：卖票，票号为" + ticket--);
        }
    }
}

