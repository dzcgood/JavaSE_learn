import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author DzcGood
 * @date 2021/9/23 - 17:46
 */
/*
* java.util.Comparator接口的使用
* 一、
* 1、背景：
*   当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码
*   或者实现了java.lang.Comparable接口的排序规则不适合当前的操作，
*   那么就可以考虑使用Comparator的对象来排序
* 2、重写compare(Object o1, Object o2)方法，比较o1和o2的大小
*   如果方法返回正整数，则表示o1大于o2
*   如果方法返回负整数，则表示o1小于o2
*   如果方法返回0，则表示o1等于o2
* 二、Comparable与Comparator的对比
*   1、Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小
*   2、Comparator接口属于临时性的比较
* */
public class CompareToTest {
    @Test//Comparator用于String类
    public void test1(){
        String[] arr = new String[]{"AA", "DD", "BB"};
        Arrays.sort(arr, new Comparator(){
            public int compare(Object o1, Object o2){
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);//按照从大到小排
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));//[DD, BB, AA]
    }

    @Test//Comparator用于自定义类
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenoveMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 312);
        arr[3] = new Goods("huaweiMouse", 65);
        Arrays.sort(arr, new Comparator<Goods>() {
            //按照名称从大大小排序。名称相同的按价格从大到小排序
            @Override
            public int compare(Goods o1, Goods o2) {
                if(o1.getName().equals(o2.getName())){
                    return -Double.compare(o1.getPrice(), o2.getPrice());
                }else{
                    return -o1.getName().compareTo(o2.getName());
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }
}
