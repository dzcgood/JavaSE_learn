import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/16 - 22:12
 */

/*
* abstract关键字的使用
* 1、可以修饰类、方法
* 2、含义：抽象的
* 3、abstract修饰类（抽象类）
*   > 抽象类不能实例化
*   > 抽象类仍然提供构造器，因为子类的实例化需要调用抽象类的构造器
*   > 开发中，都会提供抽象类的子类，让子类实例化
* 4、abstract修饰方法（抽象方法）
*   > 抽象方法只有方法的声明，没有方法体
*   > 包含抽象方法的类一定（必须）是抽象类，但抽象类中可以没有抽象方法
*   > 若子类重写了父类中的！所有的！抽象方法后，就可以实例化
*     若子类没有重写父类中的！所有的！抽象方法，则子类还是抽象类，不可实例化
* 5、abstract使用上的注意点
*   > 不能修饰属性、构造器等结构
*   > 不能用来修饰私有方法（因为不能被重写）、静态方法（静态方法不能被重写）
*   > 不能和final同时使用
* 6、抽象类的匿名子类
*   > 匿名内部类
* 7、设计模式：TemplateMethod（模板方法）
*   > 先写好代码中确定的部分，然后用一个类去继承父类，子类具体实现代码中不确定的部分
*
* */
public class Abstract {
    //抽象类
    @Test
    public void test1(){
//        Person p = new Person();//抽象类不能实例化
    }

    //抽象类的匿名子类
    @Test
    public void test2(){
        Person p = new Man();
        method(p);//非匿名的类，非匿名对象
        method(new Man());//非匿名类，匿名对象
        Person p1 = new Person() {//创建了一个匿名子类(Person的子类)
            @Override
            public void walk() {
                //do something
            }
        };
        method(p1);//匿名类，非匿名对象
        method(new Person() {//匿名类，匿名对象
            @Override
            public void walk() {
                //do something
            }
        });
    }

    public static void method(Person p){
        p.walk();
    }
}

abstract class Person{
    String name;
    int age;

    //这不是抽象方法
    public void eat(){
//        System.out.println("吃");
    }

    //抽象方法没有方法体
    public abstract  void walk();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}

class Man extends Person{
    @Override
    public void walk(){
        System.out.println("男人跑步");
    }
}