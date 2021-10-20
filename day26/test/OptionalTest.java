import org.junit.Test;

import java.util.Optional;

/**
 * Optional类的使用：为了避免程序中空指针异常而创建的类
 * 1、常用方法
 *  > ofNullable(T t)
 *  > T orElse(T t)
 *  > T get() 如果Optional内部value不为空，返回该值，否则，抛异常
 *  > T getOrElse(Supplier<? super T> consumer) 如果有值，就返回值，没有就返回Supplier接口提供的返回值
 *  > boolean isPresent() 判断是否包含对象
 * @author DzcGood
 * @date 2021/10/21 - 1:19
 */
public class OptionalTest {
    @Test
    public void test1(){
        //Optional.of(T t) 要求t必须不为null
        Optional<Employee> employee = Optional.of(new Employee());
        //Optional.empty() 创建一个空的Optional实例
        Optional<Object> empty = Optional.empty();
        //Optional.ofNullable(T t) 允许t为空
        Optional<Object> o = Optional.ofNullable(null);
        Employee e = null;
        //这里会报空指针
//        getEmployeeName(e);
        //这里调用使用了Optional的getName()，虽然e是空，但是避免了空指针
        System.out.println(OptionalTest.getName(e));
    }

    /**
     * 假设我想获取Employee的姓名，如果不适用Optional，传入null的时候就会空指针异常
     * */
    public String getEmployeeName(Employee e){
        return e.getName();
    }


    /**
     * 假设我想获取Employee的姓名，如果不适用Optional，传入null的时候就会空指针异常
     * 按照以往逻辑，可以这样优化
     * */
    public String getEmployeeName1(Employee e){
        if(e == null){
            throw new RuntimeException();
        }else{
            return e.getName();
        }
    }

    /**
     * 使用Optional后
     * */
    public static String getName(Employee e){
        //这里的e有可能是null，有可能不是
        Optional<Employee> e1 = Optional.ofNullable(e);
        // T orElse(T other) 如果Optional内部的value有值就返回value，没有就返回other
        //如果e1内部的T是空，就会返回新创建的employee，如果e1不为空，就会返回e1
        //这样，获取的Employee对象就一定不是null，可以避免空指针
        return e1.orElse(new Employee("我是空值",12)).getName();
    }
}
