import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的使用：
 * 1、使用的情景：当要传递给lambda体的操作已经有实现的方法了，可以使用方法引用。
 * 2、方法引用，本质上就是lambda表达式，而lambda表达式作为函数式接口的实例，所以方法引用也是函数式接口
 * 3、使用格式： 类（或对象）:: 方法名
 *      > 类 :: 非静态方法
 *      > 类(对象) :: 静态方法
 *      > 类 :: 非静态方法  ******
 * 4、什么时候使用方法引用？要求？
 *  > 要求接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型一致（针对情况一和二）
 *  >
 * @author DzcGood
 * @date 2021/10/19 - 19:56
 */
public class MethodRefTest {
    /**
     * 情况一：对象::实例方法
     * Consumer中的void accept(T t)
     * PrintStream中的void println(T t)
     * */
    @Test
    public void test1(){
        Consumer<String> con1 = str -> System.out.println(str);
        con1.accept("hello");
        System.out.println("................");
        //这两个lambda表达式效果一致
        Consumer<String> con2 = System.out::println;
    }

    /**
     * Supplier的 T get()
     * Employee中的String getName()
     * */
    @Test
    public void test2(){
        //lambda表达式形式
        Employee emp = new Employee("Tom", 10);
        Supplier<String> s =  () -> emp.getName();
        //方法引用形式
        Supplier<Integer> s1 = emp::getAge;
    }

    /**
     * 类名 :: 静态方法名
     * */
    @Test
    public void test3(){
        //lambda表达式的写法
        Comparator<Integer> con = (t1, t2) -> Integer.compare(t1, t2);
        //方法引用的写法
        Comparator<Double> con1 = Double::compare;
    }

    /**
     * Function中的 R apply(T t)
     * Math中的Long round(Double d)
     * */
    @Test
    public void test4(){
        //lambda表达式写法
        Function<Double, Long> func = (d) -> Math.round(d);
        func.apply(12.3);
        //方法引用写法
        Function<Double, Long> func1 = Math::round;
        func1.apply(12.6);
    }

    /**
     * 情况三： 类名 :: 实例方法
     * Comparator中的int compare(T t1, T t2)
     * String中的boolean t1.equals(t2)
     * */
    @Test
    public void test5(){
        //lambda表达式写法
        Comparator<String> con1 = (s1, s2) -> s1.compareTo(s2);
        //方法引用写法
        Comparator<String> con2 = String::compareTo;
        ////////////////////////////////////////////

        /*
        * BiPredicate中的 boolean test(T t1, T t2)
        * String中的 boolean t1.equals(t2)
        * */
        //lambda表达式写法
        BiPredicate<String, String> bp = (t1, t2) -> t1.equals(t2);
        System.out.println(bp.test("hello", "world"));
        //方法引用写法
        BiPredicate<String, String> bp2 = String::equals;
        System.out.println(bp2.test("hello", "hello"));
    }

    /**
     * Employee中的String getName()
     * Function中的 R apply(T t)
     * */
    @Test
    public void test6(){
        //lambda表达式写法
        Function<Employee, String> func = (e) -> e.getName();
        //方法引用写法
        Function<Employee, String> func1 = Employee::getName;
    }
}
