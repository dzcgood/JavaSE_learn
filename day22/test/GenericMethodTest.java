import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DzcGood
 * @date 2021/10/4 - 21:11
 */

/*
* 自定义泛型方法
* 1、泛型方法可以出现在非泛型类中
* 2、泛型方法：在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
*    换句话说，泛型方法所属的类是不是泛型都没有关系
* 3、泛型方法可以声明为static，原因：泛型参数是在调用方法时确定的，并非在实例化类时确定
* */
public class GenericMethodTest<T> {
    T name;

    public void show(T name){//这不是泛型方法！！！！
        System.out.println(name);
    }

    public <E> List<E> copyFromArrayToList(E[] arr){//声明泛型方法：在返回类型前面加上<>
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }

    //测试泛型方法
    @Test
    public void test1(){
        GenericMethodTest<String> order = new GenericMethodTest<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}


class A{
    public static <E> List<E> copyFromArrayToList(E[] arr){//非泛型类也可以定义泛型方法，且可以声明为static
        ArrayList<E> list = new ArrayList<>();
        for (E e : arr) {
            list.add(e);
        }
        return list;
    }
}