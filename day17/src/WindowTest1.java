/**
 * @author DzcGood
 * @date 2021/8/22 - 14:48
 */

/*
* 售票窗口，用实现Runnable接口
* */
public class WindowTest1 {
    public static void main(String[] args) {
        Window1 w = new Window1();
        new Thread(w).start();
        new Thread(w).start();
        new Thread(w).start();
    }
}

class Window1 implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {
        while(true){
                synchronized (this){//此时的this代表唯一的Window1对象
                if(ticket > 0){
                    System.out.println(Thread.currentThread().getName() + "售票，票号：" + ticket--);
                }else{
                    break;
                }
            }
        }
    }
}
