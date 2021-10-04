import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author DzcGood
 * @date 2021/10/1 - 16:39
 */

/*
* 使用for - each遍历集合、数组(JDK5.0新增)
* */
public class ForEachTest {
    @Test
    public void test(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String(("Tom")));
        collection.add(false);
        //for(集合/数组元素类型 : 局部变量, 集合/数组对象){}
        for(Object obj : collection){
            System.out.println(obj);
        }
    }
}
