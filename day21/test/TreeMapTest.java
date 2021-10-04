import org.junit.Test;

import java.util.*;

/**
 * @author DzcGood
 * @date 2021/10/3 - 16:33
 */
public class TreeMapTest {
    //向TreeMap中添加key-value，要求key必须是由同一个类创建的对象
    //因为要按照key进行排序：自然排序，定制排序
    //自然排序
    @Test
    public void test1(){
        TreeMap map = new TreeMap();
        map.put(new Person("Tom",13), 98);
        map.put(new Person("Jack",15), 89);
        map.put(new Person("Mike",21), 76);
        map.put(new Person("Jerry",9), 100);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }

    //定制排序：使用参数为Comparator的构造器
    //按照年龄从大到小排序
    @Test
    public void test2(){
        Map map = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Person && o2 instanceof Person){
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return -Integer.compare(p1.getAge(), p2.getAge());
                }
                throw new RuntimeException("参数不匹配");
            }
        });
        map.put(new Person("Tom",13), 98);
        map.put(new Person("Jack",15), 89);
        map.put(new Person("Mike",21), 76);
        map.put(new Person("Jerry",9), 100);
        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " " +entry.getValue());
        }
    }
}
