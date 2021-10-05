import org.junit.Test;

import java.util.ArrayList;

/**
 * @author DzcGood
 * @date 2021/10/4 - 20:05
 */

/*
* 1、如何自定义泛型结构：泛型类、泛型接口、泛型方法
* 2、关于自定义泛型类、泛型方法
*   > 如果定义了泛型类，实例化没有指明类的泛型，则认位此泛型类型为Object类型
*   > 建议实例化时指明类的泛型
*   > 若子类在继承带泛型的父类时，指明了泛型类型，则子类不再是泛型类。在实例化时，不需要指明泛型
*   > 泛型不同的引用不能相互赋值
*   > 静态方法中不能使用泛型，原因：泛型在类对象创建的时候才确定，而static随着类的加载而加载
*   > 异常类不能声明为泛型的
* */
public class Order<T> {
    String name;
    int orderId;
    //类的内部结构可以使用类的泛型
    T orderT;
    //        T[] arr = new T[10];//这样写会报错
    T[] arr = (T[])new Object[10];//这样写才行，原因：泛型是编译期的，不支持运行期，而new在运行期
    public Order(){}

    public Order(String name, int orderId, T orderT) {
        this.name = name;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    public static void show(){
//        System.out.println(orderT);//报错，static不能使用泛型

    }

    @Test
    public void test1(){
        //泛型不同的引用不能相互赋值
        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = null;
//        list1 = list2;//报错
    }
}

class SubOrder<T, E> extends Order<T>{//未指明泛型类型，SubOrder还是泛型类
    E name;
}

class SubOrder1 extends Order<Integer>{//指明了泛型类型，SubOrder1不再是泛型类

}

