import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author DzcGood
 * @date 2021/8/24 - 19:42
 */

/*
* 创建线程的方式三 --- 实现Callable接口， JDK5.0新增
* 步骤：
*   1、创建一个实现Callable接口的类
*   2、重写call()方法，将线程需要执行的操作声明在call()方法中
*       > call()可以有返回值，可以抛出异常
*   3、创建Callable接口实现类的对象
*   4、将创建的对象作为参数传递到FutureTask的构造器中，创建FutureTask的对象
*   5、将FutureTask的对象作为参数传递到Thread的构造器中，创建Thread的对象，并调用start()方法
*   6、获取Callable中的call()方法的返回值的方法：调用FutureTask对象的get()方法
* 如何理解实现Callable接口的方式创建线程比实现Runnable接口创建线程的方式要强大？
*   答：call()方法可以有返回值、可以抛出异常，让其他操作捕获异常、call()支持泛型
* */
public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        new Thread(futureTask).start();
        try {
            //get()的返回值即为FutureTask构造器形参的实现类重写的call方法的返回值
            //本例中即为NumThread类重写的call()方法的返回值
            Integer o = futureTask.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class NumThread implements Callable{
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2 == 0) {
                sum += i;
                System.out.println(i);
            }
        }
        return sum;
    }
}
