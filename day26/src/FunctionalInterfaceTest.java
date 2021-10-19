import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java内置的4大核心函数式接口
 * 消费型接口 Consumer<T> void accept(T t)
 * 供给型接口 Supplier<T> T get()
 * 函数型接口 Function<T, R>  R apply(T t)
 * 断定型接口 Predicate<T> boolean test(T t)
 *
 * @author DzcGood
 * @date 2021/10/19 - 19:22
 */
public class FunctionalInterfaceTest {
    /**
     * 测试函数式接口Consumer，所有类似于void accept(T t)的函数都可以用lambda表达式代替
     * */
    @Test
    public void test1(){
        //使用lambda表达式创建函数式接口Consumer<Double>的实例
        happyTime(500, (o) -> System.out.println("消费" + o + "元"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }

    /**
     * 测试predicate<T>接口
     * */
    @Test
    public void test2(){
        List<String> aList = Arrays.asList(new String[]{"hello", "hi", "why"});
        //表示如果字符串是"hello"，就会被过滤
        List<String> list = filterString(aList, s -> !s.equals("hello"));
        //输出结果为[hi, why]
        System.out.println(list);
    }

    /**
     * 根据给定的规则，过滤list中符合条件的字符串，此规则由Predicate的方法决定
     * */
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}
