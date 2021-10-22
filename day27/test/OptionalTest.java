import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * JDK9新特性：Optional的stream()方法
 * @author DzcGood
 * @date 2021/10/22 - 23:37
 */
public class OptionalTest {
    @Test
    public void test(){
        List<String> list = Arrays.asList("Tom", "Jerry", "Otis");
        Optional<List<String>> optional = Optional.ofNullable(list);
        //stream()方法会返回一个流。
        //下面的例子中，会返回一个流，流内只有一个list对象
        Stream<List<String>> stream = optional.stream();
        stream.flatMap(x -> x.stream()).forEach(System.out::println);
    }
}
