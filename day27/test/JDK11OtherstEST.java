import org.junit.Test;

import java.util.function.Consumer;

/**
 * @author DzcGood
 * @date 2021/10/23 - 14:52
 */
public class JDK11OtherstEST {
    @Test
    public void test1(){
        //在lambda表达式如果想用注解，就不能省略类型
        Consumer<String> con = (@Deprecated String t) -> System.out.println(t.toUpperCase());
        //以下是错误的，没有加类型
//        Consumer<String> con1 = (@Deprecated t) -> System.out.println(t.toUpperCase());
        //JDK11中，可以用var这样写
        Consumer<String> con2 = (@Deprecated var t) -> System.out.println(t.toUpperCase());

    }
}
