/**
 * @author DzcGood
 * @date 2021/8/22 - 14:26
 */

/*
* 例子：创建三个窗口卖票，总票数为100张（使用继承Thread类来实现）
* 1、问题：卖票过程中出现了重票和错票 --> 出现了线程安全问题
* 2、问题出现的原因：当某个线程操作车票的过程中，尚未完成操作时，其他线程参与进来，也操作车票。
* 3、如何解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket之后，其他线程才可以开始操作ticket。
*            这种情况下，即使线程a出现了阻塞，也不能改变。
* 4、在Java中，我们通过同步机制来解决线程安全问题。
*
* 方式一：同步代码块
*   synchronized(同步监视器){
*       //需要被同步的代码
*   }
* 说明：
*       > 操作共享数据的代码即为需要被同步的代码 --> 不能包含多了（效率低），也不能包含少了（达不到要求）
*       > 共享数据：多个线程共同操作的变量，比如：ticket就是共享数据
*       > 同步监视器，俗称：锁。任何一个类的对象都可以充当锁
*         要求：多个线程必须要公用一把锁(所以要通过实现Runnable接口来创建新进程，或者把锁声明为static)
*         补充：在实现Runnable接口创建多线程的方式中，可以考虑使用this充当同步监视器；在继承Thread类创建多线程的方式
*              中，慎用this充当同步监视器，可以考虑当前类（类名.class）充当同步监视器
* 方式二：同步方法
*   如果操作共享数据的代码完整的声明在一个方法中，我们不妨把这个方法声明为synchronized
*   如果是继承Thread的方式，则方法要声明为static；
*   如果是实现Runnable的方式，则不需要声明为static
*   总结：
*       > 同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
*       > 非静态的同步方法，同步监视器是this
*       > 静态的同步方法，同步监视器是当前类本身（类名.class）
* 5、使用同步的方式，解决了线程的安全问题。------好处
*    操作被同步的代码时，只能有一个线程参与，其他线程必须等待，相当于时一个单线程的过程，效率低。 -----局限性
*
* */
public class WindowTest {
    public static void main(String[] args) {
        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();
        w1.start();
        w2.start();
        w3.start();
    }
}

class Window extends Thread{
    private static int ticket = 100;
    private static Object obj = new Object();
    @Override
    public void run() {
        while(true){
            synchronized (Window.class) {//类也是对象，Window.class只会加载一次
//            synchronized (this) { //在继承实现线程的方法中，这样写是错误的
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (ticket > 0) {
                    System.out.println(getName() + "：卖票，票号为" + ticket--);
                }else{
                    break;
                }
            }
        }
    }
}
