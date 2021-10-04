import org.junit.Test;

import java.util.*;

/**
 * @author DzcGood
 * @date 2021/10/2 - 22:49
 */

/*
* 一、Map接口框架
*   |---- Map：双列数据，存储key-value对的数据 --> 类似于高中的函数y = f(x)
*       |---- HashMap：作为Map的主要实现类，线程不安全的，效率高。存储存储key或value时，可以是null值。
*           |---- LinkedHashMap：保证在遍历map元素时，可以按照添加的顺序实验遍历。原理和LinkedHashSet类似。对于频繁的
*                                遍历操作，效率要高于HashMap
*       |---- TreeMap：保证按照添加的key-value对（排序依据是key）进行排序，实现排序遍历。底层使用红黑树
*       |---- Hashtable：作为古老的实现类，线程安全的，效率低。存储存储key或value时，不可以是null值
*           |---- Properties：常用来处理配置文件。key和value都是String类型
*   HashMao的底层：数组 + 链表（JDK7及以前）
*                 数组 + 链表 + 红黑树 （JDK8之后）
* 二、面试题
*   1、HaspMap的底层实现原理
*   2、HashMap和Hashtable的异同？
*   3、CurrentHashMap与Hashtable的异同？（暂时不讲）
* 三、结构的理解（以HashMap为例，不适用于TreeMap）
*   key是不可重复的、无序的，使用Set存储所有的key   ---> key所在类要重写equals()和hashCode()方法
*   value是可重复的、无序的，使用Collection存储所有的value  ---> value所在类要重写equals()
 *   key和value是被封装成一个entry对象，key和value是entry的两个属性。
*   entry是无序的、不可重复的，使用set存储所有的entry
* 四、HashMap底层实现原理，以JDK7为例
*   HashMap map = new HashMap();
*   在实例化以后，底层创建了长度是16的一维数组Entry[] table
*   ..执行多次put..
*   map.put(key1, value1);
*   首先，调用key1所在类的hashCode()方法计算key1的hash值，此hash值经过某种算法计算后，得到在Entry数组中的存放位置
*   如果此位置上的数据为空，此时key1-value1添加成功。如果此位置上的数据不为空（意味着此位置存在一个或多个数据（以链表存在）），
*   比较当前key1和已存在的一个或多个数据key的hash值：
*       如果key1的hash值与已存在数据的hash都不相同，此时key1-value1添加成功。 ---> 情况2
*       若和某一个数据(key2, value2)的hash值相同，则调用key1所在类的equals()方法：
*           若相同，则添加失败   ----> 情况3
*           若不相同，使用value1替换value2
*   补充：关于情况2和情况3，此时key1-value1和原来的数据以链表方式存储
*   在不断的添加过程中，会涉及到扩容的问题，当超出临界值并且要存放的位置非空时，扩容。
*   默认的扩容方式：扩容为原来容量的2倍，并将原有的数据复制过来。
*   JDK8相较于JDK7底层实现方面的不同：
*   1、new HashMap()：底层没有创建一个底层为16的数组
*   2、JDK8底层的数组是：Node[]，而非Entry[]
*   3、首次调用put()方法时，底层会创建长度为16的数组
*   4、JDK7底层结构只有：数组 + 链表；JDK8底层结构：数组 + 链表 + 红黑树。
*      当数组的某一个索引位置上的元素超过8个时且当前数组的长度超过64时，此时此索引位置上的数据改为使用红黑树存储
* 五、几个概念
*   DEFAULT_INITIAL_CAPACITY:HashMap的默认容量：16
*   DEFAULT_LOAD_FACTOR:HashMap的默认加载因子：0.75
*   threshold：扩容的临界值，= 容量 * 加载因子 = 16 * 0.75 = 12
*   TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值，转化为红黑树：8
*   MIN_TREEIFY_CAPACITY：Bucket中的Node倍树化时最小的hash表容量：64
* 六、LinkedHashMap底层实现原理
*   源码中LinkedHashMap底层链表上的结点Entry继承了HashMap中的结点Node，将其改成了双向链表
 * */
public class MapTest {
    @Test
    public void test1(){
        Map map = new HashMap();
        map.put(123, "AA");
        map.put(456, "BB");
        map.put(12, "CC");
        System.out.println(map);//不按照添加顺序输出，{456=BB, 123=AA, 12=CC}

        LinkedHashMap map1 = new LinkedHashMap();
        map1.put(123, "AA");
        map1.put(456, "BB");
        map1.put(12, "CC");
        System.out.println(map1);//不按照添加顺序输出，{123=AA, 456=BB, 12=CC}
    }

    //常用方法
    /*
    * 添加：put()
    * 删除：remove()
    * 修改：put()
    * 查询：get()
    * 长度：size()
    * 遍历：keySet(), values(), entrySet()
    * */
    @Test
    public void test2(){
        Map map = new HashMap();
        //Object put(Object key, Object value)
        map.put("AA",123);
        map.put(45,123);
        //修改操作
        map.put("AA",456);
        System.out.println(map);//{AA=456, 45=123}
        Map map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);
        //void putAll(Map m)
        map.putAll(map1);
        System.out.println(map);//{AA=456, CC=123, DD=123, 45=123}
        //Object value = remove(Object key)
        map.remove("CC");
        System.out.println(map);//{AA=456, DD=123, 45=123}
        //clear()
        map.clear();
        System.out.println(map);//{}
        System.out.println(map.size());//0
        map.put("AA",123);
        map.put(45,123);
        //Object value = get(Object key)
        System.out.println(map.get("AA"));//123
        //boolean containsKey(Object key)
        System.out.println(map.containsKey("AA"));//true
        //boolean containsValue(Object value)
        System.out.println(map.containsValue(123));//true
        //size()
        System.out.println(map.size());//2
        //isEmpty()
        System.out.println(map.isEmpty());//false
        //boolean equals(Object obj):判断当前map和参数对象obj是否相等
        //Map没有迭代器
        //Set keySet()：返回所有key组成的Set
        Set set = map.keySet();
        for (Object o : set) {
            System.out.println(o);
        }
        //Collection values()：返回所有value值构成的集合
        Collection values = map.values();
        for (Object value : values) {
            System.out.println(value);
        }
        //遍历所有的key-value
        //方式一：Set entrySet()
        Set set1 = map.entrySet();
        for (Object o : set1) {
//            System.out.println(o);//可以直接输出
            Map.Entry entry = (Map.Entry)o;
            System.out.println(entry.getKey() + ", " + entry.getValue());//entry有getKey()和getValue()
        }
        //方式二
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while(iterator.hasNext()){
            Object key = iterator.next();
            Object value = map.get(key);
            System.out.println("key = " + key + ", value = " + value);
        }
    }
}
