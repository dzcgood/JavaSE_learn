import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JDK10新特性：集合中新增的copyOf()方法，用于创建只读集合
 * @author DzcGood
 * @date 2021/10/23 - 14:02
 */
public class CopyOfTest {
    @Test
    public void test(){
        var list = List.of("Java", "Python", "C");
        var copy1 = List.copyOf(list);
        //true
        System.out.println(list == copy1);

        var alist = new ArrayList<>();
        var copy2 = List.copyOf(alist);
        //false
        System.out.println(alist == copy2);

        //两个代码基本一致，为什么一个为true，一个为false？
        //答：如果copyOf()的实际参数是只读的，则没必要再造一个，直接返回实际参数
        //如果copyOf()的实际参数不是只读的，就会新造一个。
        //所以copy1实际上就是list，而copy2是新造的
    }
}
