import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 *
 * 一、构造器引用
 *  和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致，抽象方法的返回值就是构造器的返回值
 * 二、数组引用
 *  把数组看成一个类，那么数组引用就是构造器引用了
 *
 * @author DzcGood
 * @date 2021/10/20 - 1:12
 */
public class ConstructorRef {
    /**
     * 构造器引用
     * Supplier中的 T get()
     * */
    @Test
    public void test1(){
        //lambda表达式
        Supplier<Employee> supplier = () -> new Employee();
        //构造器引用
        Supplier<Employee> supplier1 = Employee::new;
    }

    /**
     * Function中的T apply(T t)
     * */
    @Test
    public void test2(){
        //lambda表达式
        Function<Integer, Employee> fun1 = (age) -> new Employee(age);
        //构造器引用
        Function<Integer, Employee> fun2 = Employee::new;
    }

    /**
     * BiFunction的 R apply(T t, U u)
     * */
    @Test
    public void test3(){
        //lambda表达式
        BiFunction<String, Integer, Employee> func = (str, age) -> new Employee(str, age);
        //构造器引用
        BiFunction<String, Integer, Employee> func1 = Employee::new;
    }

    /**
     * 数组引用
     * */
    @Test
    public void test4(){
        //lambda表达式
        Function<Integer, String[]> func = (length) -> new String[length];
        //数组引用
        Function<Integer, String[]> func1 = String[]::new;
    }
}
