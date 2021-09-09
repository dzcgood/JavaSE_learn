import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

/**
 * @author DzcGood
 * @date 2021/9/8 - 11:17
 */

/*
* String类常用API
* */
public class StringMethodTest {
    /*
    * 较高频率的方法
    * */
    @Test
    public void test1(){
        String s1 = "Hello World";
        System.out.println(s1.length());//length()
        System.out.println(s1.charAt(0));//charAt()
        System.out.println(s1.isEmpty());//isEmpty()，返回str.length() == 0
        String s2 = s1.toLowerCase();//toLowerCase()，返回新建的小写值
        System.out.println(s1);//s1的值没有改变（不可变性）
        System.out.println(s2);//hello world
        String s3 = s1.toUpperCase();//toUpperCase(),返回新建的大写值
        String s4 = "   he  llo   world    ";
        String s5 = s3.trim();//trim(),返回去除首尾空格后的字符串值（中间的空格不去除）
        System.out.println(s3);//s3本身不改变
        System.out.println(s4);
        System.out.println(s1.equals(s2));//equals()，判断字符串是否相等
        System.out.println(s1.equalsIgnoreCase(s2));//equalsIgnoreCase()，判断字符串是否相等，忽略大小写
        String s6 = "abc";
        String s7 = "def";
        String s8 = s6.concat(s7);//concat()，效果和 + 一样
        System.out.println(s8);//abcdef
        System.out.println(s6.compareTo(s7));//compareTo()，字符串比大小
        System.out.println(s1.substring(0)) ;//substring(int index),取从index开始的子符串
        System.out.println(s1.substring(0,2)) ;//substring(int start, int end),取 [start, end) 的子符串

    }

    //
    @Test
    public void test2(){
        String s1 = "hello world";
        System.out.println(s1.endsWith("world"));//endsWith(String str),判断字符串是否以str结尾
        System.out.println(s1.startsWith("he"));//startsWith(String str),判断字符串是否以str开头
        System.out.println(s1.startsWith("He"));//false，区分大小写
        s1.startsWith("ll",2);//startsWith(String str, int index)，判断字符串从index开始是否以str开头
        String s2 = "wo";
        System.out.println(s1.contains(s2));//contains(String str),判断字符串是否包含str
        System.out.println(s1.indexOf("lo"));//indexOf(String str),返回字符串第一次出现str的索引，没有则返回-1
        System.out.println(s1.indexOf("ll", 1));//indexOf(String str, int startIndex)
                                                             // 返回从startIndex开始的str的索引，没有则返回-1
        String s3 = "hellorworld";
        System.out.println(s3.lastIndexOf("or"));//lastIndexOf(String str)，返回从后往前找的第一个str的索引位置
        System.out.println(s3.lastIndexOf("or", 6));//lastIndexOf(String str, int fromIndex)，
                                                        //从fromIndex从右往前找，返回第一个str的索引位置

    }

    /*
    * 有关替换的方法
    * */
    @Test
    public void test3(){
        String s1 = "hello world ll";
        System.out.println(s1.replace('l', 'g'));//将所有oldChar替换成newChar
        System.out.println(s1);//s1没有被改变
        System.out.println(s1.replace("ll", "hh"));//也可以替换字符串（全部替换）
        //replaceAll()，正则表达式的地方再讲
        //replaceFirst()，正则表达式的地方再讲
        //matches()，判断str是否和正则表达式符合
        //split()，以正则表达式切割，返回String[]
    }

    /*
    * String与基本数据类型、包装类之间的转换
    * */
    @Test
    public void test4(){
        //String --> 基本数据类型
        String s1 = "123";
        int n1 = Integer.parseInt(s1);
        //基本数据类型 --> String
        int num = 12356;
        String s2 = String.valueOf(num);//调用valueOf()方法
        String s3 = num + "";//使用 + 运算符连接
    }

    /*
    * String与char[]之间的转换
    * */
    public void test5(){
        //String --> char[]
        String str = "abc123";
        char[] ch = str.toCharArray();//调用String的toCharArray()方法
        for (int i = 0; i < ch.length; i++) {
            System.out.println(ch[i]);
        }
        //char[] --> String：调用String的构造器
        char[] ch2 = new char[]{'a', 'g'};
        String str2 = new String(ch2);//构造器
    }

    /*
    * String与byte[]之间的转换
    *
    * 编码：字符串 --> 字节
    * 解码：字节 --> 字符串
    * UTF-8字符集中，一个汉字对应三个字节
    * GBK字符集中，一个汉字对应两个字节
    * 说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
    * */
    @Test
    public void test6(){
        //编码：String --> byte[]
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes();//使用默认字符集进行编码（默认utf-8）
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = null;
        try {
            bytes1 = str1.getBytes("gbk");//使用指定字符集进行转换
            System.out.println(Arrays.toString(bytes1));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //解码：byte[]  --> String：调用String构造器
        String s = new String(bytes);//使用默认字符集进行解码（默认utf-8）
        System.out.println(s);
        String s1 = new String(bytes1);
        System.out.println(s1);//使用gbk编码，却使用utf-8解码，会乱码
        try {
            String gbk = new String(bytes1, "gbk");//使用对应解码方法解码
            System.out.println(gbk);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
