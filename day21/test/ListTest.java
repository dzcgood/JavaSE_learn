import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author DzcGood
 * @date 2021/10/1 - 16:48
 */
/*
* 1、List继承结构
*   |---- Collection接口：单列集合，用来存储一个一个的对象
*       |---- List接口：存储有序的、可重复的数据。  --> 类似于"动态"数组
*           |---- ArrayList：作为List接口的主要实现类，@since 1.2，线程不安全的，效率高。底层使用Object[]存储
*           |---- LinkedList，@since 1.2，对于频繁的插入、删除操作效率比ArrayList高                             ，底层使用双向链表存储
*           |---- Vector：作为List接口的古老实现类，@since 1.0，线程安全的，效率低。底层使用Object[]存储
* 2、 面试题：比较ArrayList、LinkedList、Vector三者的异同？
*       同：三个类都实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
*       不同：见上
* 3、ArrayList源码分析：
*       JDK7情况下：
*           ArrayList list = new ArrayList();//底层创建了初始长度为10的数组
*           list.add(123);//element[0] = new Integer(123);
*           ...
*           list.add(11);//如果此次的添加导致底层数组容量不构，则扩容；
*                       //默认扩容为原先长度的1.5倍，并将原有数组数据复制到新数组中
*           建议：开发中使用带参的构造器：ArrayList(int initialCapacity)，尽量避免扩容
*       JDK8情况下：
*           ArrayList list = new ArrayList();//底层Object[] element初始化为{}，并没有创建长度为10的数组
*           list.add(123);//第一次调用add()时，底层才创建了长度10的数组，并将123添加到element[]
*           ...
*           后续的添加和扩容操作与JDK7无异
*       小结：JDK7中的ArrayList对象创建类似于单例模式中的饿汉式，而JDK8中的ArrayList对象的创建类似于懒汉式，
*            延迟了数组的创建，节约了内存
* 4、LinkedList源码分析：
*   LinkedList list = new LinkedList();//内部声明了类型的first和last属性（头指针和尾指针），默认值为null
*   list.add(123);//将123封装到Node中，创建了Node对象，并插入到双向链表的末尾
*   其中，链表结点Node的定义为：
*   private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
* 4、Vector源码分析：
*   JDK7和JDK8中通过Vector()构造器创建对象时，底层都创建了长度为10的数组，在扩容方面，默认扩容为原来数组长度的2倍
* */
public class ListTest {
    //List接口的常用方法：以ArrayList为例
    /*
    * 总结：常用方法有
    * 增：add(Object o)
    * 删: remove(int index) / remove(Object o)
    * 改: set(int index, Object o)
    * 查: get(int index) / indexOf(Object o) / lastIndexOf(Object o)
    * 插: add(int index, Object o)
    * 长度: size()
    * 遍历: ①iterator迭代器 ②for - each ③普通for循环，按照索引访问
    * */
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 12));
        list.add(456);
        System.out.println(list);//[123, 456, AA, Person@4dcbadb4, 456]
        //void add(int index, Object obj)：在index位置插入元素
        list.add(1, "BB");
        System.out.println(list);//[123, BB, 456, AA, Person@4dcbadb4, 456]
        //boolean addAll(int index, Collection c):在index位置开始将集合c的所有元素插入
        list.addAll(1, Arrays.asList(1,2,3));
//        list.add(Arrays.asList(1,2,3));//注意区分
        System.out.println(list.size());//6 + 3 = 9
        //Object get(int index)：获取索引值为index的元素
        Object o = list.get(1);
        System.out.println(o);
        //int indexOf(Object o)：返回o第一次出现的位置，若没有，则返回-1
        //int lastIndexOf(Object o)：返回o最后一次出现的位置，若没有，则返回-1
        int i = list.indexOf(456);
        System.out.println(i);
        int i1 = list.lastIndexOf(456);
        System.out.println(i1);
        //Object remove(int index):按索引删除元素，并返回该元素
        Object obj = list.remove(1);
        System.out.println(obj);
        //Object set(int index, Object o):将index位置的元素设置成o，并返回该索引位置修改前的值
        System.out.println(list);
        Object obj1 = list.set(0, 111);
        System.out.println(obj1);
        System.out.println(list);
        //List subList(int fromIndex, int endIndex)：返回子列表,[fromIndex, endIndex)
        System.out.println(list.subList(0,2));
    }
}
