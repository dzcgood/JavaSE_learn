/**
 * @author DzcGood
 * @date 2021/8/21 - 23:26
 */

/*
* 一、Thread类常用方法
* 1、start()：启动当前线程；调用当前线程的run()方法
* 2、run():通常需要重写Thread类的此方法，将创建的线程需要执行的操作写在此方法
* 3、static currentThread()：静态方法，返回当前代码执行的线程
* 4、getName()：获取当前线程的名字
* 5、setName()：设置当前线程的名字
* 6、yield()：释放当前线程对CPU的使用权
* 7、join()：在线程a中调用线程b的join，则线程a进入阻塞状态，直到线程b执行完成后，线程a才结束阻塞状态
* 8、stop()：强制结束当前线程（不推荐使用）
* 9、static sleep(long millitime)：静态方法，阻塞线程一段时间（单位：ms）
* 10、isAlive()：判断线程是否还存活
*
* 线程的优先级（并不是优先级越高，就一定是先执行，可以把优先级想象成概率）
* MAX_PRIORITY 10 最大优先级
* MIN_PRIORITY 1 最小优先级
* NORM_PRIORITY 5 默认优先级
* 1、获取和设置线程的priority
*   > getPriority()
*   > setPriority()
* 2、说明：高优先级的线程要抢占低优先级线程cpu的执行器，但是只是从概率上讲，高优先级的线程被执行的概率较大，并不意味着只有当
*         高优先级的线程执行完以后，低优先级的线程才被执行
*
* 线程通信：wait(),notify(),notifyAll() 这三个方法是定义在Object类中的
* 分类：守护线程、用户线程。如果JVM中只剩下守护线程，则JVM会退出。如gc()线程就是一个守护线程
* */
public class ThreadMethodTest {
    public static void main(String[] args) {
        //给主线程命名
        Thread.currentThread().setName("主线程");
        HelloThread h1 = new HelloThread();
        h1.setName("线程1");//设置线程名为“线程1”
        h1.setPriority(Thread.MAX_PRIORITY);//设置优先级
        h1.start();
        HelloThread h2 = new HelloThread("线程2");//通过构造器命名
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            if (i == 20) {
                try{
                    h1.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(h1.isAlive());
    }
}

class HelloThread extends Thread{
    public HelloThread(String name) {
        super(name);
    }

    public HelloThread() {
    }

    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i % 20 == 0) {
                this.yield();
            }
        }
    }
}
