import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author DzcGood
 * @date 2021/10/19 - 16:36
 * lambda表达式的使用
 * 1、举例：(o1, o2) -> Integer.compare(o1,o2);
 * 2、格式：
 *      (形参列表) -> lambda体(其实就是方法体)
 * 3、使用：分六种情况介绍
 * 4、lambda表达式本质：作为接口的具体实现类的对象。简化了接口的实现过程。如Comparator实现类子类的创建
 * 5、要求实现的接口是函数式接口：只有一个方法的接口
 */

public class LambdaTest {
    /**
     * 语法格式一：无参，无返回值
     */
    @Test
    public void test1(){
        Runnable r1 = new Runnable(){
            @Override
            public void run(){
                System.out.println("I Love You");
            }
        };
        r1.run();
        System.out.println("..........................");
        Runnable r2 = () -> {System.out.print("I Love You Too, ");
            System.out.println("骗你的");};
        r2.run();
    }

    /**
     * lambda需要一个参数，但没有返回值
     * */
    @Test
    public void test2() {
        //原型
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("爱你哦");
            }
        };
        con.accept("sssss");
        //lambda表达式形式
        Consumer<String> con1 = (String s) -> {
            System.out.println("我不爱");
        };
    }

    /**
     * 情况三：参数类型可省略，由编译器自动推断
     * */
    @Test
    public void test3(){
        //原型
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println("爱你哦");
            }
        };
        con.accept(123);
        //lambda表达式形式
        Consumer<String> con1 = s -> {
            System.out.println("我不爱");
        };
    }

    /**
     * 情况四：只有一个参数时，括号可以省略
     * */
    @Test
    public void test4(){
        //原型
        Consumer<Integer> con = new Consumer<Integer>() {
            @Override
            public void accept(Integer s) {
                System.out.println("爱你哦");
            }
        };
        con.accept(123);
        //lambda表达式形式
        Consumer<String> con1 = (s) -> {
            System.out.println("我不爱");
        };
    }

    /**
     * 情况五：需要两个以上参数，有多条语句，有返回值
     * */
    @Test
    public void test5(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12,21);
        System.out.println(compare1);
        System.out.println("////////////////////////////");
        //lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1, o2);
        };
    }

    /**
     * 情况六：lambda体只有一条语句时，若有Return和大括号，则都可以省略
     * */
    @Test
    public void test6(){
        Comparator<Integer> com1 = (o1, o2) -> o1.compareTo(o2);
    }
}
