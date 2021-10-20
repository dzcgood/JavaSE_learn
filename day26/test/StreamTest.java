import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Stream API的使用
 * 1、Stream关注的是数据的运算，与CPU打交道
 *    集合讲的是数据的存储，与内存打交道
 * 2、Stream不会自己存储数据，不会改变源对象，相反，他们会返回一个持有结果的新Stream
 * 3、Stream是延迟执行的，这意味着他们会等到需要结果的时候才执行
 * 4、操作步骤
 *  > 创建Stream
 *  > 一系列的中间操作
 *  > 终止操作（一旦执行终止操作，就会开始执行中间操作并产生结果），之后，就不能再被使用
 * @author DzcGood
 * @date 2021/10/20 - 20:45
 */
public class StreamTest {
    /**
     * 创建Stream实例的方法一：通过集合
     * */
    @Test
    public void test1(){
        List<String> list = Arrays.asList("hello", "hi", "why");
        // default Stream<E> stream()：返回一个顺序流
        Stream<String> stream = list.stream();
        // default Stream<E> parallelStream()：返回一个并行流
        Stream<String> stringStream = list.parallelStream();
    }

    /**
     * 创建Stream实例的方法二：通过数组
     * */
    @Test
    public void test2(){
        //调用static <T>  Stream<T> Arrays.stream(T[] array)：返回一个流
        IntStream stream = Arrays.stream(new int[]{123, 4, 54, 232, 6});

    }

    /**
     * 创建Stream实例的方法三：通过Stream.of()
     * */
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
    }

    /**
     * 创建Stream实例的方法四：通过Stream.iterate() 和 Stream.generate()
     * */
    @Test
    public void test4(){
        //迭代
        //public static <T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前10个偶数
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
        //生成
        //public static <T> Stream<T> generate(Supplier<T> s)
        //产生十个随机数
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }


    //接下来介绍中间操作



    /**
     * Stream中间操作一：筛选与切片
     * */
    @Test
    public void test5(){
        /*
        * filter(Predicate p)：接受lambda，从流中删除一些元素
        * */
        List<String> list = Arrays.asList("hello", "hi", "why", "world", "but", "hello");
        Stream<String> stream = list.stream();
        //实例：删除流中字符串hi
        stream.filter(e -> !e.equals("hi")).forEach(System.out::println);
        /*
        * limit(n) 截断流，使元素不超过给定数量
        * */
        //因为stream已经执行终止操作，所以得重新造一个
        //筛选出前三条数据
        list.stream().limit(3).forEach(System.out::println);
        /*
        * skip(n) 跳过前n个元素，若元素个数不足n，则返回空流
        * */
        list.stream().skip(3).forEach(System.out::println);
        /*
        * distinct() 筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
        * */
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 中间操作之映射
     * */
    @Test
    public void test6(){
        //map(Function f)：按照f将元素转换成其他形式
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        //转换成大写
        list.stream().map(String::toUpperCase).forEach(System.out::println);
        //flatMap(Function f)接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流合成一个流

        /*
        * map和flatMap的区别：
        * map相当于List.add
        * flatMap相当于List.addAll
        * */
    }

    /**
     * 中间操作之排序
     * */
    @Test
    public void test7(){
        //sorted() 自然排序
        List<Integer> list = Arrays.asList(12, 43, 6, 2, 46, 32);
        list.stream().sorted().forEach(System.out::println);
        System.out.println(".......................");
        //sorted(Comparator com)：定制排序
        //这里实现从大到小排序
        list.stream().sorted((n1, n2) -> -Integer.compare(n1, n2)).forEach(System.out::println);
    }

    /**
     * 终止操作：匹配与查找
     * */
    @Test
    public void test8(){
        //boolean allMatch(Predicate p) 检查是否匹配所有元素
        // 判断是否所有元素的长度都大于3
        List<String> list = Arrays.asList("avf", "dfgr", "a");
        Stream<String> stream = list.stream();
        boolean b = stream.allMatch(s -> s.length() > 3);
        //false
        System.out.println(b);
        //boolean anyMatch(Predicate p) 检查是否有元素匹配该规则
        //true
        list.stream().anyMatch(s -> s.length() > 3);
        //boolean noneMatch(Predicate p) 如果没有任何元素符合，就返回true
        //true
        list.stream().noneMatch(s -> s.length() > 5);
        //Optional<T> findFirst() 返回第一个元素
        Optional<String> first = list.stream().findFirst();
        //Optional<T> findAny() 返回任意元素，
        Optional<String> any = list.stream().findAny();
        //long count()返回流中元素总数
        long count = list.stream().count();
        //Optional<T> max(Comparator c) 返回最大值
        //Optional<T> min(Comparator c) 返回最小值
        //forEach(Consumer c) 内部迭代
    }

    /**
     * 终止操作之归约
     * */
    @Test
    public void test9(){
        //reduce(T identity BinaryOperator) 将流中元素反复结合起来，得到一个值并返回
        //identity是初始值
        //计算1-10的自然数之和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().reduce(0, Integer::sum);
        //reduce(BinaryOperator)，返回Optional<T>
        //计算list中所有元素之和
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        //也可以这样写
        Optional<Integer> reduce1 = list.stream().reduce((n1, n2) -> n1 + n2);
        System.out.println(reduce1.toString());
    }

    /**
     * 终止操作之收集
     * */
    @Test
    public void test10(){
        //collect(Collector c) ：c决定了如何对流执行收集的操作（如收集到List，Set，Map）
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        //找到大于5的数字并返回一个List
        List<Integer> list1 = list.stream().filter(e -> e > 5).collect(Collectors.toList());
        for (Integer integer : list1) {
            System.out.print(integer + " ");
        }
    }
}


