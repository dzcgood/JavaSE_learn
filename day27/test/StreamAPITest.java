import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * JDK9新特性：Stream API的加强
 * @author DzcGood
 * @date 2021/10/22 - 22:40
 */
public class StreamAPITest {
    /**
     * takeWhile()
     * dropWhile()
     * */
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(11, 65, 9, 3235, 63, 856);
        //takeWhile(Predicate p)会返回从开头开始尽可能多的元素，一旦遇到不符合条件的，即使后面有符合条件的，也会被忽略
        list.stream().takeWhile(x -> x < 60).forEach(System.out::println);
        //dropWhile(Predicate p)：将符合条件的丢弃，直到遇见不符合条件的
        list.stream().dropWhile(x -> x < 60).forEach(System.out :: println);
        //
    }

    /**
     * ofNullable()
     * */
    @Test
    public void test2(){
        //实例化方法一
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        //允许某个值是null
        Stream<Integer> integerStream1 = Stream.of(1, 2, 3, null);
        System.out.println(integerStream1.count());//元素个数被认为是4个
        //不允许只有null
//        Stream<Integer> integerStream2 = Stream.of(null);
        //允许是多个null
        Stream<Integer> integerStream3 = Stream.of(null, null, null);
        System.out.println(integerStream3.count());//元素个数被认为是3个

        //ofNullable() 允许只有null
        Stream<Integer> integerStream4 = Stream.ofNullable(null);
        System.out.println(integerStream4.count());//元素个数被认为是0个
    }

    /**
     * iterate()
     * */
    @Test
    public void test3(){
        //JDK8已经有了
        Stream.iterate(0, x -> x + 1).limit(10).forEach(System.out::println);
        //JDK9新增：可以自定义终止条件，下面的终止条件是 x < 100
        Stream.iterate(0, x -> x < 100, x -> x + 1).forEach(System.out::println);
    }
}
