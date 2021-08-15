/**
 * @author DzcGood
 * @date 2021/8/15 - 17:07
 */

/*
* 单例设计模式：对于某个类，最多只能存在一个该类的实例（举例：java.lang.Runtime）
* 1、实现方法：饿汉式 vs 懒汉式
* 2、 饿汉式：提前创建好对象，所以对象加载时间过长，线程安全的
*     懒汉式：一开始不创建对象，目前的写法是线程不安全的，之后讲到线程的时候会修改
*
* */
public class Singleton {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}

/*
* 实现方式一：饿汉式
* */
class Singleton1{
    //私有化的构造器
    private Singleton1(){

    }

    //内部创建静态的类的对象
    private static Singleton1 singleton = new Singleton1();

    //提供公共静态方法返回对象实例
    public static Singleton1 getInstance(){
        return singleton;
    }
}

/*
* 实现方式二：懒汉式
* */

class Singleton2{
    private Singleton2(){

    }
    private static Singleton2 singleton2= null;

    public static Singleton2 getInstance(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
            return singleton2;
        }
        return singleton2;
    }
}
