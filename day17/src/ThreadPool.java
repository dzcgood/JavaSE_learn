import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author DzcGood
 * @date 2021/8/24 - 20:59
 */

/*
* 线程池的使用
* 1、优点
*   提前创建好多个线程，放入线程池中，使用时直接获取，使用完放回池中，可以避免频繁创建销毁，实现重复利用。
* 2、步骤
*   提供指定数量的线程池
*   执行指定的线程操作（需要提供实现Runnable接口或者Callable接口的实现类的对象）
*   关闭连接池
* 3、在开发中，四种创建线程的方式中，一般使用的都是线程池
*
* 面试题：创建线程有几种方式？答：四种。 Thread,Runnable,FutureTask,ExecutorService
*
* */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //设置线程池的属性
        //ExecutorService是一个接口，其中并没有corePoolSize，maximumPoolSize等属性。
        // 实际上Executors.newFixedThreadPool返回的是ExecutorService的一个实现类ThreadPoolExecutor的对象
        //corePoolSize，maximumPoolSize等属性定义在ThreadPoolExecutor类中，所以如果要设置相关属性，需要进行强转
        ThreadPoolExecutor executorService1 = (ThreadPoolExecutor) executorService;
        executorService1.setCorePoolSize(5);//设置核心池大小
//        executorService1.setKeepAliveTime();//设置线程在没有任务时，最多存活多少时间
        executorService1.setMaximumPoolSize(10);//设置最大线程数
        executorService.execute(new Num());//适合用于Runnable
//        executorService.submit();//适合用于Callable
        executorService.shutdown();//关闭线程池
    }
}

class Num implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                System.out.println(i);
            }
        }
    }
}
