/**
 * @author DzcGood
 * @date 2021/8/18 - 12:21
 */

/*
* 1、接口和抽象类的异同点？
*   1.1 同
*       > 不能实例化
*       > 都能被继承
*   1.2 异
*       > 抽象类有构造器，接口没有
*       > 抽象类单继承，接口多继承
* 2、abstract不能修饰类的私有方法、静态方法、final方法、final类，因为这些方法不能被重写
* 3、在局部内部类的方法中，如果调用局部内部类所声明的方法的变量，则要求此局部变量声明为final
* */
public class Review {
    public void method(){
        int num = 10;//此处的num是默认声明为final的
        class AA{
            public void method(){
//                num = 20;//会报错，因为默认是final
                System.out.println(num);
            }
        }
    }
}
