import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author DzcGood
 * @date 2021/10/2 - 0:09
 */

/*
* 1、Set接口的框架
*   |---- Collection接口：单列集合，用来存储一个一个的对象
*       |---- Set接口：存储无序的、不可重复的数据   --> 类似于高中讲的“集合”
*           |---- HashSet：Set接口的主要实现类；线程不安全的；可以存储null值
*               |---- LinkedHashSet：是HashSet的子类；遍历其内部数据时，可以按照添加的顺序遍历
*           |---- TreeSet：使用红黑树存储的，要求元素必须是同一类型，可按照某种属性进行排序
* 2、Set接口中没有额外定义的方法，使用的都是Collection中的方法
* 3、要求：向Set中添加的数据，其所在类一定要重写hashCode()和equals()
*         重写的hashCode()和equals()尽可能保持一致性：相等的对象必须具有相等的散列码
* */
public class SetTest {
    /*
    * 一、Set:无序存储的、不可重复的数据
    *   以HashSet为例说明：
    *   1、无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。而是根据数据的Hash值决定的。
    *   2、不可重复性：保证添加的元素按照equals()方法判断时，不能返回true。即，相同的元素只能添加一个。
    * 二、添加元素的过程：以HashSet为例
    *   我们向HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值，此哈希值接着通过某种算法计算出
    *   HashSet底层数组中的存放位置（即：索引位置），判断数组此位置上是否已经铀元素：如果此位置上没有其他元素，则元素a添加成功。
    *   如果此位置上有其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的hash值，如果hash值不相同，则元素a添加成功，
    *   如果hash值相同，进而调用元素a所在类的equals()方法。若返回true，则元素a添加失败。若返回false，则元素a添加成功。
    *   JDK7中，链表是头插入；JDK8中，链表是尾插入
    *   HashSet底层存储原理：数组 + 链表 + 红黑树
    * */
    @Test
    public void test1(){
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");

    }

    /*
    * LinkedHashSet的使用
    * 1、LinkedHashSet中的元素被封装成一个结点e，这些结点按照元素的添加顺序以双向链表的方式互相连接，这样，就可以按照元素添加
    *   顺序来遍历LinkedHashSet。
    * 2、优点：对于频繁的遍历操作，LinkedHashSet的效率高于HashSet
    * */
    @Test
    public void test2(){
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 12));
        set.add(new Person("Tom", 12));
    }

    /*
    * 一道面试题
    * */
    @Test
    public void test3(){
        HashSet set = new HashSet();
        Person person1 = new Person("AA", 1001);
        Person person2 = new Person("BB", 1001);
        set.add(person1);
        set.add(person2);
        person1.setName("CC");
        //这里会删除失败，因为person1中的属性被修改，导致hashCode值改变。用新的hashCode值去索引，会找不到目标
        set.remove(person1);
        //输出还是有两个person
        System.out.println(set);
        //会添加成功，虽然元素重复，但新的hashCode对应的位置是空的，可以添加
        set.add(new Person("CC",1001));
        System.out.println(set);//输出三个person
        //还是能添加成功，虽然hashCode相同，但equals()返回不相同
        set.add(new Person("AA",1001));
        System.out.println(set);//会输出四个person
    }
}
