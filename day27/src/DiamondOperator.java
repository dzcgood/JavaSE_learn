import org.junit.Test;

import java.util.Comparator;

/**
 * 新特性：在匿名内部类中也可以使用泛型的自动推断<>
 * @author DzcGood
 * @date 2021/10/22 - 17:28
 */
public class DiamondOperator {
    @Test
    public void test(){
        //匿名内部类中也可以使用泛型了的自动推断了
        //JDK8中，是不允许的
        //JDK8中，必须写成Comparator<Object> com = new Comparator<Object>{};
        Comparator<Object> com = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
    }
}
