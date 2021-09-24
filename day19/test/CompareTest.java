import org.junit.Test;

import java.util.Arrays;

/**
 * @author DzcGood
 * @date 2021/9/23 - 17:04
 */
/*
* Java比较器
* 一、说明：Java中的对象，正常情况下，只能进行比较 == 或 != 。 不能使用 > 或 < 的，但是在开发场景中，我们需要对多个对象进行
*           排序，言外之意，就需要比较对象的大小。
*           如何实现？使用两个接口中的任何一个：Comparable, Comparator
* 二、Comparable接口的使用
*
* */
public class CompareTest {
    /*
    * Comparable使用的举例：自然排序
    * 1、String, 包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方法
    * 2、重写compareTo()接口的规则：
    *   如果当前对象this大于形参对象obj，则返回正整数；
    *   如果当前对象this小于形参对象obj，则返回负整数；
    *   如果当前对象this等于形参对象obj，则返回0。
    * 3、 对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()方法
    *   在compareTo()方法中指明如何排序
    * */
    @Test
    public void test1(){
        String[] arr = new String[]{"AA", "DD", "BB"};
        Arrays.sort(arr);//默认从小到大排序
        System.out.println(Arrays.toString(arr));//[AA, BB, DD]
    }

    @Test
    public void test2(){
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenoveMouse", 34);
        arr[1] = new Goods("dellMouse", 43);
        arr[2] = new Goods("xiaomiMouse", 312);
        arr[3] = new Goods("huaweiMouse", 65);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Goods implements Comparable{
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Goods() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //指明商品比较大小的方式：先按照价格从低到高排序，价格一样的按照商品名称进行排序
    @Override
    public int compareTo(Object o){
        if(o instanceof Goods){
            Goods goods = (Goods)o;
            if(this.price > goods.price){
                return 1;
            }else if(this.price < goods.price){
                return -1;
            }else{
//                return 0;
                return this.name.compareTo(goods.name);//价格一样的按照名称排序
            }
        }
        //方式二
//        return Double.compare(this.price, goods.price);
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
