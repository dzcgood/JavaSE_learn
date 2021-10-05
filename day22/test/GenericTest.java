import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author DzcGood
 * @date 2021/10/4 - 17:17
 */

/*
* 泛型的使用
* 1、JDK5.0新增的特性
* 2、在集合中使用泛型：
*   总结：
*   ① 集合接口或集合类在JDK5.0时都修改为带泛型的结构
*   ② 在实例化集合类时，可以指明具体的泛型类型
*   ③ 指明完以后，在集合类或接口中凡是定义类或接口时，内部结构使用到泛型的位置，都指定为实例化时泛型的类型。
*      如：add(E e) ---> 实例化后： add(Integer e)
*   ④ 注意点：泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的地方，需要写成包装类
*   ⑤ 如果实例化时没有指明泛型的类型，默认类型为java.lang.Object
* 3、如何自定义泛型结构：泛型类、泛型接口、泛型方法
* */
public class GenericTest {
    //再集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(76);
        //问题一：类型不安全
//        list.add("Tom");
        for (Object score : list) {
            //问题二：强转时，可能出现ClassCastException
            int stuScore = (int)score;
            System.out.println(stuScore);
        }
    }

    //使用泛型的情况
    //使用泛型的时候，基本数据类型必须写成包装类的形式
    @Test
    public void test2(){
//        ArrayList<Integer> list = new ArrayList<Integer>();//不能写int
        //JDK7新特性，类型推断】
        ArrayList<Integer> list = new ArrayList<>();//不能写int
        list.add(123);
        list.add(456);
        //编译时，会进行类型检查，保证数据的安全
//        list.add("Tom");//编译不通过
        for (Integer score : list) {
            //避免了强转操作
            System.out.println(score);
        }
    }

    //以HashMap举例
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom", 12);
        map.put("Jack", 34);
        //类型不符合要求
//        map.put(123, "Tom");
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
    }

    /*
    * 泛型在继承方面的体现
    * 类A是类B的父类，G<A> 和G<B>不具备子父类关系，二者是并列关系，不能相互赋值
    * 类A是类B的父类，A<G> 和 B<G>具有子父类关系
    * */
    @Test
    public void test4(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<>();
        //此时list1和list2的类型不具有子父类关系，编译不通过
//        list1 = list2;//报错
        /*
        * 原因：假设可以编译通过,则list1和list2指向同一个list对象，通过list1.add()可以添加非String类型的对象到list对象
        * */

        Date date = new Date();
//        str = date;//这两个报错信息的原理其实是一样的

        show(list1);
//        show(list2);//报错，原理同上

        List<String> list3 = null;
        ArrayList<String> list4 = null;
        list3 = list4;//可以赋值，类A是类B的父类，A<G> 和 B<G>具有子父类关系

    }

    public void show(List<Object> list){

    }

    @Test
    public void test(){
        /*
        * 通配符的使用
        * 通配符： ?
        * 类A是类B的父类，G<A>和G<B>是并列关系，二者共同的父类是G<?>
        * 通配符的其他形式：
        *   ? extends A表示A及A的子类，G<? extends A>可以是G<A>和G<B>的父类，其中B是A的子类
        *   ? super A表示A及A的父类，G<? extends A>可以是G<A>和G<B>的父类，其中B是A的
        * */

        List<Object> list1 = null;
        List<String> list2 = null;
        List<?> list3 = null;
        list3 = list1;//可以赋值
        list3 = list2;//可以赋值

        List<String> list4 = new ArrayList<>();
        list4.add("AA");
        list3 = list4;
        //添加：对于List<?>就不能向其内部添加数据，
        //但是可以添加null
//        list3.add("DD");//报错，类型不匹配
        list3.add(null);//只能添加null
        //获取(读取)：允许读取数据
        Object o = list3.get(0);//读出来的是Object类型

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
