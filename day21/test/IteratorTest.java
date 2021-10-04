import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author DzcGood
 * @date 2021/10/1 - 16:01
 */

/*
* 集合元素的遍历操作，使用Iterator接口
* 1、内部的方法：hasNext(), next()
* 2、内部定义了remove()方法，此处的方法不同于Collection中的remove方法。
*    如果还没调用next()或在上一次调用next方法之后已经调用了remove()方法，再调用remove都会报IllegalStateException
* */
public class IteratorTest {
    @Test
    public void test1(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String(("Tom")));
        collection.add(false);
        Iterator iterator = collection.iterator();//迭代器
        //迭代器越界后会报错：NoSuchElementException
        //正确的迭代方法
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add(456);
        collection.add(new Person("Jerry", 20));
        collection.add(new String(("Tom")));
        collection.add(false);
        Iterator iterator = collection.iterator();//迭代器
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                //删除集合中的"Tom"，如果还没调用next()或在上一次调用next方法之后已经调用了remove()方法，
                //再调用remove都会报IllegalStateException
                iterator.remove();
            }
        }
        iterator = collection.iterator();//迭代器,因为前面iterator已经指向末尾，所以此处要重新生成
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
