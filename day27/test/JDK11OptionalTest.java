import org.junit.Test;

import java.util.Optional;

/**
 * JDK11新特性：Optional加强
 * @author DzcGood
 * @date 2021/10/23 - 14:34
 */
public class JDK11OptionalTest {
    @Test
    public void test(){
        /*
        * boolean isEmpty() ：value为空，就返回true。 注意和isPresent()区别
        * ifPresentOrElse(Consumer c, Runnable r) : value存在，执行c，不存在，执行r
        * orElseThrow()：value存在，就返回value，不存在，就抛异常
        * stream() ：value为空，就返回一个空stream，value存在，就返回value的stream
        * or(Optional o)：value存在，就返回对应的optional，value不存在，就返回参数指定的optional
        * */
        var op = Optional.of("hello");
        var op1 = Optional.of("hi");
        //因为op里面的value非空，所以返回的是op
        Optional<String> op2 = op.or(() -> op1);
        //因为op里面的value为空，所以返回的是op1
        op = Optional.empty();
        op2= op.or(() -> op1);

    }
}
