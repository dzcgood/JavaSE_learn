import org.junit.Test;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 *
 * JDK10新特性：局部变量类型推断
 * 1、工作原理
 *  var是根据右边的类型来推断左边的类型的，如果右边的不确定，左边就不能用var
 *  推断完成后，会把原来的类型写入字节码文件，var不会出现在字节码文件中
 * 2、var不是关键字
 * @author DzcGood
 * @date 2021/10/23 - 13:36
 */
public class JDK10Test {
    @Test
    public void test(){
        //以前的写法
        int num = 10;
        //1、声明变量时，根据所赋的值，推断变量的类型
        var num1 = 11;
        var list = new ArrayList<String>();
        list.add("hello");
        //2、遍历
        for(var str : list){
            System.out.println(str + " " + str.getClass());
        }
        //普通的遍历操作
        for (var i = 0; i < 100; i++) {
            System.out.println(i);
        }
    }

    /**
     * 不能使用类型推断的场景
     * */
    @Test
    public void test1(){
        //情况一：没有赋初始值的情况
        int num;
//        var num;
        //情况二：lambda表达式中，左边的接口不能省略
        Supplier<Double> sup = () -> Math.random();
        //lambda表达式是作为实例赋值给接口的，你现在把接口都省略了，我怎么知道赋值给谁啊。。。
//        var sup1 = () -> Math.random();
        //情况三：方法引用中，左边的接口不能省略
        Consumer<String> con = System.out::println;
//        var con1 = System.out::println;
        //情况四：数组的静态初始化中
//        var arr = {1,2,3,4};
        //以下是可以的
        var arr = new int[]{1,2,3,4};
    }

    /**
     * 其他不可使用的情况
     * */
    @Test
    public void test3(){
        //没有初始化的局部变量声明
//        var num = null;
        //方法的返回类型：原则是由返回值类型判断return语句是不是合法，而不是根据return推断返回值类型
        //方法的参数类型： public void method(var a, var b)，理由同上。 如果写成var，什么牛马都可以往里面塞
        //构造器的参数类型：理由同上
        //属性：属性涉及到构造函数，构造函数就会涉及到参数类型
        //catch块
    }
}
