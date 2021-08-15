import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/15 - 15:27
 */

/*
*static关键字的使用
* 1、static：静态的
* 2、static可用来修饰属性、方法、代码块、内部类
* 3、使用static修饰属性：静态变量（类变量）
*   3.1 属性：按照是否用static修饰，可分为静态属性和非静态属性（实例变量）
*       实例变量：我们创建了类的多个对象，每个对象都独立地拥有一套类中的非静态属性，
*                当修改一个对象中的非静态属性时，不会影响其他对象中的非静态属性
*       静态变量：我们创建了类的多个对象，每个对象共享一个静态变量，当修改其中一个类的静态变量，其他对象的也会改变
*   3.2 静态变量随着类的加载而加载，可以通过"类名.静态变量名"访问
*       实例变量随着对象的加载而加载
*       静态变量的加载早于对象的创建（实例变量的加载）
*       由于类只加载一次，所以静态变量在内存中只加载一次，存放在方法区的静态域中
*   3.3 静态属性举例： Math.PI, System.out
* 4、使用static修饰方法：静态方法
*   4.1 静态方法随着类的加载而加载，可以通过"类名.静态方法名"访问
*   4.2 静态方法中只能调用静态方法和静态属性
*       非静态方法既可以调用非静态方法和非静态属性，又可以调用静态方法和静态属性
* 5、注意点
*   5.1 在静态方法内不能使用this和super关键字
* 6、在何时，属性应该声明为静态属性？
*       该属性是被多个对象共享的，不会随着对象的改变而改变的
*       类中的常量也常常声明为static
* 7、在何时，方法应该声明为静态方法？
*       操作静态属性的方法通常设置为静态方法
*       工具类中的方法习惯声明为静态方法（因为没必要造出对象，如Math类）
* */
public class Static {
    @Test
    public void test1(){
        Chinese.nation = "PRC";
        Chinese c1 = new Chinese();
        c1.name = "小强";
        c1.age = 20;
        c1.nation = "CHN";
        Chinese c2 = new Chinese();
        c2.name = "马龙";
        c2.age = 25;
        c2.nation = "CHINA";
        System.out.println("c1.nation = " + c1.nation);//CHINA
        Chinese.show();
    }
}

class Chinese{
    static String nation;
    String name;
    int age;
    public static void show(){
        System.out.println("我是一个中国人！");
    }
}
