import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/28 - 23:03
 */

/*
* String类的使用
* */
public class StringTest {
    /*
    * 1、String：字符串，用一对""引起来表示
    * 2、String是声明为final的，不可被继承
    * 3、String实现了Serializable接口：表示字符串是支持序列化的
    *    String实现了Comparable接口，表示String可以比较大小
    * 4、String内部定义了final char value[]用于存储字符串数据
    * 5、String代表一个不可变的字符序列。简称：不可变性
    *   体现：当对字符串重新赋值时，需要重新指定内存区域赋值，不能使用原有的value[]进行赋值
    *        当对现有字符串进行连接操作时，也不能在原有value[]上进行拼接
    *        当调用String的replace方法修改指定的字符或字符串时，也必须重新指定内存地址赋值
    * 6、通过字面量的方式给字符串赋值（区别于new Sting的方式），此时的字符串值声明在字符串常量池中，
    *    字符串常量池是不会存储相同的内容的
    * */
    @Test
    public void test1(){
        String s1 = "abc";//字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);//true, "abc"保存在方法区的常量池中
        s1 = "hello";
        System.out.println(s1);//hello
        System.out.println(s2);//abc
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println(s2);//abc
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

    /*
    * String的实例化方式
    * 1、通过字面量的方式
    * 2、通过new + 构造器的方式
    * */
    @Test
    public void test2(){
        //通过字面量的方式，此时的s1和s2的数据hello声明在方法区的字符串常量池中
        String s1 = "hello";
        String s2 = "hello";
        //通过new + 构造器的方式，此时的s3和s4是保存的地址值，是数据在堆空间中开辟的对象的地址值
        String s3 = new String("hello");
        String s4 = new String("hello");
        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
        //**************************************
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);
        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true，因为是使用字面量的方式声明的字符串
        //**************************************
        Person p3 = new Person(new String("Tom"), 12);
        Person p4 = new Person(new String("Tom"), 12);
        System.out.println(p3.name == p4.name);//false，因为是使用new + 构造器的方式声明的字符串
    }

    /*
    * 结论：
    * 1、常量与常量的拼接结果在常量池，且常量池不会存在相同内容的常量
    * 2、只要其中有一个是变量，结果就在堆中
    * 3、如果拼接的结果调用intern()方法，返回值就在常量池中
    * */
    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//常量 + 常量，结果在常量池
        String s5 = s1 + "hadoop";//变量 + 常量，结果在堆
        String s6 = "javaEE" + s2;//常量 + 变量，结果在堆
        String s7 = s1 + s2;//变量 + 变量，结果在堆
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s6 == s7);//false
        String s8 = s5.intern();//返回值得到的s8使用的是常量池中已经存在的"javaEEhadoop"
        System.out.println(s3 == s8);//true
        String str = "hello world";
        final String str1 = "hello ";//str1是常量
        String str2 = str1 + "world";
        System.out.println(str == str2);//true,因为str1加了final，所以是常量！！
    }



    public void change(String str, char[] ch){
        str = "test ok";
        ch[0] = 'b';
    }
    /*
    * 一道恶心的面试题
    * */
    @Test
    public void test4(){
        String str = new String("good");
        char[] ch = { 't', 'e', 's', 't'};
        change(str, ch);
        System.out.print(str);//good
        System.out.println(ch);//best
    }
}



