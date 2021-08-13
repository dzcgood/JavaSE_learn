/**
 * @author DzcGood
 * @date 2021/8/9 - 22:20
 */

/*
* 一、面向对象的特征二————继承（子类时父类功能的拓展）
*   1、语法： 访问权限 class 类名 extends 父类名{}
*   2、优点：减少代码冗余，提高代码复用性，便于功能扩展，为多态性的使用提供前提
*   3、子类可以继承到父类的私有结构，但因为封装性的影响，子类不能直接访问到父类的私有结构
*   4、子类除了继承父类的结构外，还可以定义自己的属性和方法
*   5、某些规定
*       5.1 一个类可以被多个子类继承
*       5.2 一个类只能有一个直接父类（单继承）
*       5.3 父类的父类是子类的间接父类
*   6、所有的类都直接或间接地继承自java.lang.Object类，都具有Object类中声明的功能
*   7、子类和父类中可以出现相同名字的属性，可以用this和super加以区分
*   8、子类对象的实例化过程
*       8.1 创建子类的对象，在堆空间中，就会加载父类全部的属性
*       8.2 当我们通过子类的构造器创建子类的对象时，一定会直接或间接地调用父类的构造器，直到调用java.lang.Object的空参构造器
*           正因为加载过所有的父类结构，所以内存中才有父类的结构，子类对象才能将其调用
*       8.3 虽然创建子类对象时调用了父类的构造器，但一共只创建了一个对象（即子类对象）
* */
public class Heritage {
}
