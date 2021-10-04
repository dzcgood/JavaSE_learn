import org.junit.Test;

import java.util.*;

/**
 * @author DzcGood
 * @date 2021/9/27 - 23:04
 */

/*
* 一、集合框架的概述
* 1、集合、数组都是对多个数据进行存储操作的结构，简称Java容器
*   说明：此时的存储，主要指的是内存层面的存储，不涉及到持久化的存储（.txt, .jpg, .avi, 数据库中是持久化层面的）
* 2.1、数组在存储多个数据方面的特点：
*   > 一旦初始化以后，其长度就确定了。
*   > 一旦定义好，其元素的类型也就确定了。我们只能操作指定类型的数据。比如 String[] arr; int[] arr1;
* 2.2 数组在存储多个数据的缺点：
*   > 一旦初始化以后，其长度不可修改
*   >  数组中提供的方法非常有限，对于添加、删除、插入数据等操作，非常不便，同时效率也不高
*   > 获取数组中实际元素的个数的需求，数组没有线程的属性或方法可用
*   > 数组存储数据的特点：有序、可重复。对于无序、不可重复
* 3、集合可分为Collection和Map两种体系
*   3.1 Collection接口：单列数据，定义了存取一组对象的方法的集合
*       > List:元素有序、可重复的集合
*       > Set:元素无序、不可重复的集合
*   3.2 Map接口：双列数据，保存具有映射关系“key-value对”的集合
* 二、集合框架
*   |---- Collection接口：单列集合，用来存储一个一个的对象
*       |---- List接口：存储有序的、可重复的数据。  --> 类似于"动态"数组
*           |---- ArrayList、LinkedList、Vector
*       |---- Set接口：存储无序的、不可重复的数据   --> 类似于高中讲的“集合”
*           |---- HashSet、 LinkedHashSet、TreeSet
*   |---- Map接口：双列集合，用来存储一对一对(key, value)的数据    --> 类似于高中函数 y = f(x)，
*                                                               一个key对应一个value，一个value可以对应多个key
*       |---- HashMap、LinkedHashMap、TreeMap、HashTable、Properties
* 三、Collection接口中的方法
* */
public class CollectionTest {
    @Test
    public void test1() {
        Collection collection = new ArrayList();
        //add(Object e)：将元素e添加到集合中
        //向Collection接口的实现类的对象中添加数据obj时，要求重写obj所在类的equals()方法
        collection.add("AA");
        collection.add("BB");
        collection.add(123);//自动装箱
        collection.add(new Date());
        //size()：获取添加的元素的个数
        System.out.println(collection.size());//4
        //addAll(Collection c)：将集合c中的元素添加到当前的集合中
        Collection collection1 = new ArrayList();
        collection.add("CC");
        collection.add(456);//自动装箱
        collection.addAll(collection1);
        System.out.println(collection);//[AA, BB, 123, Wed Sep 29 00:49:29 CST 2021, CC, 456]
        //isEmpty()：判断当前集合是否为空(是否有元素)
        System.out.println(collection.isEmpty());//false
        //clear()：清空集合中的所有元素
        collection.clear();
        System.out.println(collection.isEmpty());//true
        //contains(Object e)：判断当前集合中是否包含对象e。对于对象，判断的是equals()方法而不是==运算符。
        //所以实现相关功能需要考虑是否重写equals()方法
        System.out.println(collection.contains("AA"));//false
        collection.add("AA");
        System.out.println(collection.contains("AA"));//true
        //containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
        collection.add(123);
        collection.add(456);
        Collection coll1 = Arrays.asList(123,456);//返回的是含有123和456的list
        collection.containsAll(coll1);//true
        //remove(Object o)：删, 返回值是boolean，表示是否删除成功
        //仍然需要重写equals()方法，因为是逐个判断是否和目标相同的
        collection.remove(123);
        System.out.println(collection);
        //removeAll(Collection coll1)：从当前集合中移除coll1中所有的元素
        //仍然需要重写equals()方法，因为是逐个判断是否和目标相同的
        collection.removeAll(Arrays.asList("AA", 456));
        System.out.println(collection);//[]   (空)
        //retrainAll(Collection coll1)：求与coll1的交集（次操作会修改原有集合）。返回值是boolean
        collection.add(123);
        collection.retainAll(Arrays.asList(123,456));
        System.out.println(collection);//[123]
        //equals(Object obj)：判断两个集合是否相等。
        System.out.println(collection.equals(Arrays.asList(123)));//true
        //hashCode()：返回当前对象的hash值
        System.out.println(collection.hashCode());
        //toArray()： 集合转换成数组（返回值是Object[]类型）
        Object[] objects = collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }
        //Arrays.asList()：数组转换成成集合
        List<String> list = Arrays.asList("AA", "BB");
        //注意:new int[]{123, 456}被当成是一个元素装入List；new Integer[]{123, 456}则是两个元素被装入list
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1
        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
        //iterator()：返回一个迭代器接口的实例，用于遍历集合元素
    }
}
