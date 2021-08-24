/**
 * @author DzcGood
 * @date 2021/8/24 - 16:15
 */

/*
* 生产者消费者问题：同时可以存放20个产品
* */


public class ProductTest {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("生产者");
        Consumer consumer = new Consumer(clerk);
        consumer.setName("消费者");
        producer.start();
        consumer.start();
    }
}

class Clerk{
    private int productNumber = 0;
    //生产产品
    public synchronized void produceProduct(){
        if(productNumber < 20){
            System.out.println(Thread.currentThread().getName() + "：开始生产第" + ++productNumber + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //消费产品
    public synchronized void consumeProduct(){
        if (productNumber > 0) {
            System.out.println(Thread.currentThread().getName() + "：开始消费第" + productNumber-- + "个产品");
            notify();
        }else{
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread{
    private Clerk clerk = null;

    public Producer(Clerk clerk) { //生产者
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始生产产品");
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();
        }

    }
}

class Consumer extends Thread{
    private Clerk clerk = null;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "：开始消费产品");
        while(true){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consumeProduct();
        }
    }
}
