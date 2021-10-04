import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author DzcGood
 * @date 2021/10/3 - 20:29
 */

/*
* Collections:操作Collection和Map的工具类
* 面试题：Collections和Collection的区别？
* */
public class CollectionsTest {
    //常用方法
    @Test
    public void test1(){
        /*
        * Collections类中提供了多个synchronizedXxx()方法，该方法可使将指定集合包装成线程同步的集合，从而可以解决多线程并发集合
        * 时的线程安全问题。如synchronizedCollection、synchronizedList、synchronizedMap等等。
        * 比如List list1 = synchronizedList(list)返回的就是线程安全的list
        *
        * reverse(List)：反转List中元素的顺序
        * shuffle(List)：使List的元素随机乱序
        * sort(List)：从小到大自然排序
        * sort(List, Comparator):定制排序
        * swap(List, i ,j):交换List中索引位置为i和j的元素
        * Object max(Collection)：自然排序最小值
        * Object max(Collection, Comparator)：定制排序最大值
        * Object min(Collection)：自然排序最小值
        * Object min(Collection, Comparator)：定制排序最小值
        * int frequency(Collection, Object)：返回出现次数
        * void copy(List dest, List src)：将src的内容复制到dest
        * boolean replaceAll(List list, Object oldValue, Object newVal)：将List中所有oldValue换成newValue
        *
        * */
        List list = new ArrayList();
        list.add(123);
        list.add(523);
        list.add(13);
        list.add(153);
        list.add(3);
        list.add(17);
        System.out.println(list);//[123, 523, 13, 153, 3, 17]
        Collections.reverse(list);
        System.out.println(list);//[17, 3, 153, 13, 523, 123]
        Collections.shuffle(list);
        System.out.println(list);;//[3, 523, 17, 123, 13, 153]
        Collections.sort(list);
        System.out.println(list);//[3, 13, 17, 123, 153, 523]
        Collections.swap(list, 0, 1);
        System.out.println(list);//[13, 3, 17, 123, 153, 523]
        //一眼就知道是做什么的就不一一举例了。。。。。
    }

    @Test
    public void test2(){
        //copy方法可能会出错，举例说明一下
        List list = new ArrayList();
        list.add(123);
        list.add(523);
        list.add(13);
        list.add(153);
        list.add(3);
        list.add(17);
//        List desc = new ArrayList();
//        Collections.copy(desc, list);//会报异常，desc的size比list小的就会报错
        List desc = Arrays.asList(new Object[list.size()]);//应该这样写
        Collections.copy(desc, list);
        System.out.println(desc);
    }
}
