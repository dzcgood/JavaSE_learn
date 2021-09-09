import org.junit.Test;

import java.util.Date;

/**
 * @author DzcGood
 * @date 2021/9/9 - 17:16
 */

/*
* JDK 8之前日期和时间的API测试
* */
public class DateTimeTest {
    //1、System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差
        //成为时间戳
        System.out.println(time);
    }

    /*
    * java.util.Date类
    *       | --- java.sql.Date类
    * 1、两个构造器的使用
    * 2、两个方法的使用
    *      > toString():显示当前的年月日时分秒
    *      > getTime()：获取当前Date对象对应的时间戳
    * 3、java.sql.Date对应数据库中的日期变量，和数据库交互时才会用到
    *      > 如何实例化
    *           > java.sql.Date date = new java.sql.Date(long date);
    *      > 如何将java.util.Date转换成java.sql.Date对象？
    *           >方法一：强转（会报错）
    *           >方法二：java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());通过时间戳
    * */
    @Test
    public void test2(){
        //构造器一，Date()，创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1);//Thu Sep 09 17:23:49 CST 2021
        System.out.println(date1.getTime());//获取当前Date对象对应的时间戳
        //构造器二，Date(long date)，创建指定毫秒数的Date对象
        Date date = new Date(1631179672631L);
        System.out.println(date1);
        System.out.println(date1.getTime());
        //创建java.sql.Date类对象
        java.sql.Date date2 = new java.sql.Date(1631179672631L);
        System.out.println(date2);//2021-09-09
        System.out.println(date2.getTime());//1631179672631

    }
}
