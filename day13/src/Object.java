/**
 * @author DzcGood
 * @date 2021/8/14 - 13:08
 */

/*
* Object类的使用
* 1、Object类是所有Java类的根父类
* 2、Object类的功能（属性、方法）具有通用性
*   2.1 Object类只声明了一个空参的构造器
*   2.2 属性：无
*       方法：equals，toString，getClass，hashCode，clone，finalize，wait，notify，，notifyAll
* 3、==和equals的区别
*   3.1 ==是运算符，可以用于基本数据类型或者引用数据类型
*       用于基本数据类型时（除了boolean，其他7个类型可以混合比较），比较二者数值是否相等；
*       （注意：10 == 10.0 是true，因为有自动类型提升）
*       用于引用数据类型时，比较内存地址是否相同。
*       补充：==使用时，必须保证左右两边变量类型要一致
*   3.2 equals是方法，适用于引用数据类型
*       Object类中equals方法的功能和==运算符一样，所以使用时通常需要重写。
*       String类已经重写了equals，比较的是字符串是否相等
*       String、Date、File、包装类都重写了equals方法
* 4、toString方法
*   4.1 当我们输出实例对象的引用时，会自动调用toString方法
*       即System.out.println(类名)和System.out.println(类名.toString())等价
*   4.2 Object类的toString方法作用是输出地址，String，Date，File，包装类等都重写了Object类的toString方法
*   4.3 一般需要重写toString方法
* */

public class Object {
    public static void main(String[] args) {
        Object o = new Object();
        System.out.println(o.toString());//Object@677327b6
        System.out.println(o);//Object@677327b6
        String s = "Hello";
        System.out.println(s);//Hello
        System.out.println(s.toString());//Hello
    }
}
