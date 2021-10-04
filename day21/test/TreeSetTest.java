import org.junit.Test;

import java.util.*;

/**
 * @author DzcGood
 * @date 2021/10/2 - 14:26
 */

/*
* TreeSet类的使用
* 1、向TreeSet中添加的数据，要求是相同类的对象
* 2、两种排序方式：自然排序（实现CompareTo接口）和定制排序（Comparator）
* 3、自然排序中，比较两个元素是否相同的标准为compareTo()方法，不再是equals()方法
* 4、自定义排序中，比较两个元素是否相同的标准为compareTo()方法，不再是equals()方法
* */
public class TreeSetTest {
    @Test
    public void test1(){
        Set set = new TreeSet();
        set.add(456);
        set.add(123);
//        set.add("AA");//错误添加方式，“AA”与整型数据类型不一样
//        set.add("CC");
//        set.add(new Person("Tom", 12));
//        set.add(new Person("Tom", 12));
        set.add(24);
        for (Object o : set) {
            System.out.println(o);
        }
    }

    @Test
    public void test2(){
        Set set = new TreeSet();
        set.add(new Person("Tom", 12));//Person类已重写compareTo()方法，按照年龄大小排序
        set.add(new Person("Tom", 14));
        set.add(new Person("Tom", 13));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test3(){
        Comparator comparator = new Comparator(){
            @Override
            public int compare(Object o1, Object o2){
                if(o1 instanceof Person && o2 instanceof Person){
                    return Integer.compare(((Person) o1).getAge(), ((Person) o2).getAge());
                }else{
                    throw new RuntimeException("类型不匹配");
                }
            }
        };
        Set set = new TreeSet(comparator);//使用自定义的排序方式
        set.add(new Person("Tom", 12));//虽然Person类已重写compareTo()方法，但TreeSet的构造器使用了定制排序
        set.add(new Person("Tom", 14));
        set.add(new Person("Tom", 13));
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
