import org.junit.Test;

import java.util.*;

/**
 * JDK9新特性：集合工厂方法：创建只读集合
 * @author DzcGood
 * @date 2021/10/22 - 22:03
 */
public class CollectionFactoryTest {
    /**
     * 在JDK8中创建只读集合的方法，缺点：比较麻烦
     * */
    @Test
    public void test(){
        List<String> nameList = new ArrayList<>();
        nameList.add("Tom");
        nameList.add("Mike");
        nameList.add("Jerry");
        //创建只读集合
        nameList = Collections.unmodifiableList(nameList);
        //以下语句会报错，因为nameList是只读集合
//        nameList.add("Tommy");
        System.out.println(nameList);
    }


    /**
     * JDK9中提供的of()方法，可以快速得到只读集合
     * */
    @Test
    public void test1(){
        //此时得到的list是只读的，JDK8可以做到
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //此时得到的list是只读的，JDK9之后才有
        List<String> nameList = List.of("Tom", "Mike", "Jerry");
        //此时得到的set是只读的，JDK9之后才有
        Set<Integer> integers = Set.of(1, 2, 3);
        //此时得到的map是只读的，JDK9之后才有
        Map<String, Integer> myMap = Map.of("Tom", 12, "Jerry", 13, "Otis", 16);
        //以下语句会报错
//        nameList.add("hello");
    }
}
