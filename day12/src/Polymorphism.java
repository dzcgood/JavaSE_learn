/**
 * @author DzcGood
 * @date 2021/8/13 - 13:39
 */

/*
* 面向对象三大特征之多态
* 1、何为多态性
*   1.1 对象的多态性：父类的引用指向子类的对象（子类的对象赋给父类的引用）
*   1.2 当调用子父类同名同参的方法时，实际执行的是子类重写父类的方法----虚拟方法调用
* 2、虚拟方法调用
*   2.1 有了多态性后，在编译期只能调用父类中声明的方法，但在运行期，实际执行的是子类中重写父类的方法
*       总结：编译看左边，执行看右边
* 3、多态性的使用前提
*   3.1 类的继承关系
*   3.2 方法的重写
* 4、补充
*   4.1 对象的多态性适用于方法，但不适用于属性（如父类中有属性id，子类中也有，则使用的会是父类中的id）
*   4.2 多态性是运行时行为
*   4.3 重载是静态绑定，重写是动态绑定
*   4.4 有了对象的多态性以后，内存中实际上加载了子类特有的属性和方法，但是因为声明为父类类型，所以无法调用子类特有的属性和方法，
*       要想调用子类的属性和方法，就得进行强制类型转换，但是强制类型转换有风险，会抛出ClassCastException异常
*   4.5 父类转成子类：向下转型
*       子类转成父类：向上转型、多态
* */
public class Polymorphism {
    public static void main(String[] args) {
        //对象的多态性：父类的引用指向子类的对象
       Person person = new Student();
       person.eat();//调用的是子类的方法
    }
}
