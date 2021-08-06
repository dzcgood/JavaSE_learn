/**
 * @author DzcGood
 * @date 2021/8/4 - 22:35
 */

/*
* java面向对象学习的三条主线
* 1、Java类及类的成员：属性、方法、构造器、代码块，内部类
* 2、面向对象的三大特征：封装性、继承性、多态性
* 3、其他关键字：this、super、static、final、abstract、interface、package、import
*
*
* 属性 = 成员变量 = field = 域、字段
* 方法 = 成员方法 = 函数 = method
* 创建类的对象 = 类的实例化
* 通过”对象.属性“或”对象.方法“调用类的结构
* 创建类的多个对象，则每个对象都独立地拥有类的属性（除了static）
* 不能在方法中声明另一个方法
*
*
* 类中属性的使用
* 属性（成员变量）   vs  局部变量
* 1、相同点
*   声明变量的方式都相同
*       变量类型 变量名 = 值;
*   先声明后使用，都各自的作用域
*
*
*
* 2、不同点
*   在类中声明位置不同
*       属性：直接声明在类内
*       局部变量：声明在方法中、方法的形式参数中、代码块、构造器内部、构造器形参中
*   权限修饰符不同
*       属性可以在声明的时候使用权限修饰符，常用的有public、default、protected、private -------->封装性
*       局部变量不能使用权限修饰符
*   默认初始化值不同
*       属性有默认初始化值
*       局部变量没有初始化值，调用局部变量前，一定要赋值，否则会报错
*   在内存中加载位置不同
*       属性：加载到堆空间中（非static属性）
*       局部变量：加载到栈空间
*
* JVM内存结构
* 1、虚拟机栈，局部变量存放在栈中
* 2、堆，new出来的对象存放在堆中，对象的属性（除了static）都加载在堆中
* 3、方法区，类的加载信息，常量池，静态域存放在方法区中
*
* 理解万事万物皆对象
* 1、在Java语言范畴中，我们将功能、结构封装到类中，通过类的实例化，来调用具体的功能结构
*   >Scanner,String等
*   >File类
*   >网络资源：URL
* 2、设计Java语言与HTML前端或者数据库交互时，前后端在与Java语言交互时，都体现为类、对象的交互
*
* 匿名对象
*   1、每个匿名对象一次只能使用一次
*   2、开发中的使用：见类NickNameTest
*
* 方法重载和覆盖
*   重载是在一个类中
*       参数个数、参数类型、参数顺序至少有一个不同
*       只有返回类型不同的不是重载
*   覆盖是在不同类中
* */
public class OOPTest {//测试类

    public void personTest(){
        //创建类的对象
        Person personTest = new Person();
        //调用类的结构（属性和方法）
        personTest.name = "Tom";
        personTest.isMale = true;
        System.out.println("personTest.name = " + personTest.name);
        System.out.println("personTest.isMale = " + personTest.isMale);
        personTest.eat();
        personTest.talk("English");
        personTest.sleep();
        //******************
        Person personTest2 = new Person();
        System.out.println("personTest2.name = " + personTest2.name);// null
        System.out.println("personTest2.isMale = " + personTest2.isMale);// false
        //******************
        Person personTest3 = personTest;// personTest和personTest指向堆中的同一个对象
        System.out.println("personTest3.name = " + personTest3.name);// Tom
    }

    public void UserTest(){
        User userTest = new User();
        System.out.println("userTest.name = " + userTest.name);// null
        System.out.println("userTest.age = " + userTest.age);// 0
        System.out.println("userTest.isMale = " + userTest.isMale);// false
    }

    public static void main(String[] args) {
        OOPTest test = new OOPTest();
        test.personTest();
        System.out.println("\n");
        test.UserTest();
        //匿名对象
        new OOPTest().personTest();
        new OOPTest().UserTest();//两次调用是两个不同的对象
    }
}

class Person{
    //属性
    String name;
    int age = 1;//和c++不同，这里可以设置初始值
    boolean isMale;

    //方法
    public void eat(){
        System.out.println("人可以吃饭");
    }

    public void sleep(){
        System.out.println("人可以睡觉");
    }

    public void talk(String language){
        System.out.println("人可以说话，使用的语言是" + language);
    }
}


class User{
    String name;
    int age;
    boolean isMale;

    public void talk(String language){//language是形参，局部变量
        System.out.println("人可以说话，使用的语言是" + language);
    }

    public void eat(){
        String food = "rice";//rice 局部变量
        System.out.println("人可以吃" + food);
    }
}

class NickNameTest{//匿名类的使用
    public void show(User user){
        user.talk("English");
        user.eat();
    }
}
//像这样使用匿名类
//new NickNameTest().show(new User());
//等价于
// NickName test = new NickNameTest();
// User user = new User();
// test.show(user)

