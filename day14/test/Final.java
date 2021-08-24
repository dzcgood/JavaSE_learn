/**
 * @author DzcGood
 * @date 2021/8/15 - 21:00
 */

/*
* final关键字的使用
* 1、final可以用来修饰类、属性、方法、变量
*   >修饰类：该类不能被继承，如String，System，StringBuffer
*   >修饰属性/变量：该属性/变量的值不能改变，就称为常量
*   >修饰方法：该方法不能被重写
* 2、final修饰属性，可以考虑赋值的位置有：显式初始化、代码块、构造器（每个构造器都要保证每个常量都被赋值）
*   final修饰局部变量时，必须在声明的时候赋值；尤其是使用final修饰形参时，表明此形参是一个常量，不可修改
* 3、常量必须在对象被创建之前赋值
* 4、static final：全局常量
*
* native关键字表示调用c、c++的代码
* */
public class Final {
}