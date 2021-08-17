import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/17 - 15:04
 */

/*
* 接口的使用 -- interface
* 1、在java中，接口和类是并列的两个结构
* 2、定义接口：定义接口的成员
*   > JDK 1.7及以前：只能定义全局常量及抽象方法
*       全局常量： public static final
*       抽象方法： public abstract
*   > JDK 1.8及以后，还可以定义静态方法，默认方法
*       静态方法：public static
*           > 接口中定义的静态方法只能通过接口去调用，一般是给接口自己用的
*       默认方法：
*           > 可以被实现类重写
*           > 实现接口的类的对象可以调用默认方法
* 3、接口中不能定义构造器，意味着接口不可以实例化，抽象类也不能实例化，但是抽象类可以有构造器
* 4、Java中，接口通过让类去实现(implements)接口的方式来使用接口
*   > 如果实现类实现了接口中！所有！的方法，则实现类可以实例化
*   > 若实现类没有实现接口中！所有！的方法，则该实现类是抽象类，不能实例化
* 5、一个Java类可以实现多个接口，打破了Java单继承的局限性
* 6、格式： class 子类名 extends 父类名 implements 接口名1， 接口名n
* 7、接口与接口之间可以继承，而且可以多继承
* 8、接口的使用
*   > 体现多态
* 9、接口实际上可以看成是一种规范（开发中往往是面向接口编程）
* 10、如果父类和接口中声明了同名的方法，子类在没有重写该方法的前提下，默认调用的是父类中的方法（类优先原则）
* 11、如果实现类实现了多个接口，接口中定义了同名同参数的方法，子类没有重写该方法的前提下，
*     会导致接口冲突，所以必须重写此方法
* 12、 class A extends B implements C, D
*       如果BCD都有同名同参数方法。且未被重写，则:
*       > new A().method()调用的是父类中的
*       > C.super.method()调用的是C中的
*       > D.super.method()调用的是D中的
* */
public class Interface {
    public static void method(Flyable fly){//形参体现多态
        fly.fly();
        fly.stop();
    }

    @Test
    public void test1(){
        Interface.method(new Plane());//体现多态性，创建了非匿名实现类的匿名对象
        Interface.method(new Flyable() {//体现多态性，创建了接口的匿名实现类的匿名对象
            @Override
            public void fly() {
                //
            }

            @Override
            public void stop() {
                //
            }
        });
    }
}


interface Flyable{
    public static final int MAX_SPEED = 7900;
    int MIN_SPEED = 1; //这样写相当于忽略了public static final，但实际上也是常量
    public abstract void fly();//抽象方法
    void stop();//抽象方法，省略了public abstract，但也是抽象方法

    public static void method(){//JDK8新特性：接口中定义静态方法
        System.out.println("接口的静态方法");
    }

    public default void method2(){//JDK8新特性：接口中定义默认方法
        System.out.println("接口的默认方法");
    }

}

//实现类，可以实例化
class Plane implements Flyable{
    @Override
    public void fly(){
        System.out.println("飞");
    }

    @Override
    public void stop(){
        System.out.println("停");
    }
}

//实现类，可以实例化
//没有重写所有方法，是抽象类
abstract class Kite implements Flyable{
    @Override
    public void fly(){
        //
    }
}

interface AA{

}

interface BB{

}

interface CC extends AA, BB{
    //接口之间多继承
}