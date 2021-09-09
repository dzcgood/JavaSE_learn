import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/9/9 - 11:05
 */

/*
* 关于StringBuffer和StringBuilder类的使用
* 对比StringBuffer，StringBuilder，String的效率
*       答：StringBuilder > StringBuffer > String
* */
public class StringBuffer_StringBuilderTest {

    /*
    * String,StringBuffer,StringBuilder之间的区别？
    * String:不可变；底层使用final char[]存储
    * StringBuffer：可变，效率有点低，线程安全；底层使用char[]存储
    * StringBuilder：可变，jdk5.0新增效率比StringBuffer高，线程不安全；底层使用char[]存储
    *
    * 源码分析：
    * String str1 = new String();//底层：new char[0];
    * String str2 = new String("abc");//底层：new char[]{'a', 'b', 'c'};
    * StringBuffer str3 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组
    * str3.append('a');//value[0] = 'a';
    * str3.append('b');//value[1] = 'b';
    * StringBuffer sb2 = new StringBuffer("abc");//char[] value1 = new char[3 + 16];
    *                                               底层创建了长度是”abc“.length()+16的数组
    * 问题1：sb2.length()的输出是3
    * 问题2：扩容问题：如果要添加的数据底层数组盛不下了，就需要扩容低层的数组
    *                默认情况下扩容位原来容量的2倍 + 2，同时将原有数组中的元素复制到新的数组中
    *       指导意义：开发中建议使用StringBuffer(int capacity)或StringBuilder(int capacity)指定数组容量，
    *                避免多次扩容，导致效率降低
    * */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');//sb1本身被改变
        System.out.println(sb1);
    }


    /*
    * StringBuffer,StringBuilder中新增的方法，以StringBuffer为例
    * */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);//append()
        s1.append('1');
        s1.append("1");//结果都是在末尾加上字符1
        System.out.println(s1);
        s1.delete(2,4);//delete(int start, int end),删除[start, end)之间的字符串
        s1.replace(2,4,"hello");//replace(start, end, str)，将[start, end)之间的字符串换成str
        s1.insert(0,"world");//insert(int index,str)，在指定位置插入
        System.out.println(s1);
        s1.reverse();//reverse()，字符串逆序
        //substring()，取字串
        //length()
        //charAt()
        //setCharAt(int index, char ch)修改指定位置字符
        /*
        * 总结：关注以下几个方法
        * 增：append
        * 删：delete
        * 改：replace, setCharAt
        * 查：substring, charAt
        * 长度：length
        * 遍历：toString, for + charAt
        * */
    }
}
