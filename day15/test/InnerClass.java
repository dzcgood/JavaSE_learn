import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/17 - 21:05
 */

/*
* 内部类 innerClass
* 1、Java中允许将一个类A声明在类B中，则A是内部类，B是外部类
* 2、内部类的分类
*   2.1 成员内部类
*   2.2 局部内部类（方法内，代码块内，构造器内）
* 3、成员内部类
*   > 一方面，作为类的成员
*       * 可以调用外部类的结构
*       * 可以被static修饰
*       * 可以被权限修饰符修饰
*   > 一方面，作为一个类
*       * 类内可以定义属性、方法、构造器等类的结构
*       * 可以被final修饰，言外之意，不适用final就可以被继承
*       * 可以被abstract修饰
* 4、关注以下三个问题
*   4.1 如何实例化成员内部类的对象，见test1
*   4.2 如何在成员内部类区分调用外部类结构，见test2
*   4.3 开发中局部内部类的使用，见方法getComparable()
* */


public class InnerClass {
    //如何实例化成员内部类的对象
    @Test
    public void test1(){
        Human.Dog dog = new Human.Dog();//实例化静态内部类对象
        Human man = new Human();
        Human.Bird bird = man.new Bird();//实例化非静态内部类对象
    }

    //如何在成员内部类区分调用外部类结构
    @Test
    public void test2(){
//        System.out.println(name);
//        System.out.println(this.name);//内部类的name
//        System.out.println(Human.this.name);//外部类的name
    }

    //开发中局部内部类的使用
    public Comparable getComparable() {
//        class MyComparable implements Comparable{
        //方式一
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//        return new MyComparable();
//    }
        //方式二 匿名内部类
            return new Comparable(){
                @Override
                public int compareTo(Object o) {
                    return 0;
                };

        }
    }
}

class Human{
    String name;
    int age;

    public void eat(){

    }
    public class Bird{
        //非静态成员内部类
        String name;

        public Bird() {
        }

        public void sing(){
            System.out.println("鸟唱歌");
            System.out.println(Human.this.name);//调用外部类成员
            Human.this.eat();//调用外部类方法
        }

        public void display(){
            System.out.println(name);
            System.out.println(this.name);//Bird类的name
            System.out.println(Human.this.name);//Human类的name
        }
    }

    public static class Dog{
        //静态成员内部类
        String name;
        int age;
        public void show(){
            System.out.println("旺旺旺");
        }
    }
    public void method(){
        class AA{
            //局部内部类：方法内
        }
    }

    public Human() {
        class BB{
            //局部内部类：构造器内
        }
    }

    {
        class CC{
            //局部内部类：代码块内
        }
    }
}
