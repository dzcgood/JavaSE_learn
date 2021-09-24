import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * @author DzcGood
 * @date 2021/9/13 - 0:45
 */

/*
* jdk 8 中时间API的测试
* */
public class JDK8DateTest {
    /*
    * java.util.Date类的缺点（JDK8时间API出现的原因）:
    * 1、偏移性：时间是从1900年开始的，月份是从0开始的
    * 2、格式化(SimpleDateFormat)只对Date有用，Calendar则不行
    * 3、不是线程安全的
    * 4、不能处理闰秒
    * */
    @Test
    public void test1(){
        //按照偏移性，表示2021年9月13日应该这样表示
        Date date = new Date(2021 - 1900, 9 - 1, 13);//此方法已过时
        System.out.println(date);//Mon Sep 13 00:00:00 CST 2021
    }

    /*
    * LocalDate、LocalTime、LocalDateTime类的使用
    * 说明：
    *   1、LocalDateTime类使用比其他两个类较多
    *   2、类似于Calendar
    * */
    @Test
    public void test2(){
        /*
        * 实例化
        * */
        //now()：获取当前的日期、时间、日期时间
        LocalDate localDate = LocalDate.now();//静态方法
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate);//2021-09-20
        System.out.println(localTime);//22:17:04.923
        System.out.println(localDateTime);//2021-09-20T22:17:04.923
        //of():不用考虑偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 9, 20, 22, 20);
        //2021年9月20日22时20分
        System.out.println(localDateTime1);
        /*
        * getXxx()：以LocalDateTime类为例（三各类都有共同方法），获取相关的属性
        * */
        System.out.println(localDateTime.getDayOfMonth());//20
        System.out.println(localDateTime.getDayOfWeek());//MONDAY
        System.out.println(localDateTime.getDayOfYear());//263
        System.out.println(localDateTime.getMonth());//SEPTEMBER
        System.out.println(localDateTime.getMonthValue());//9
        System.out.println(localDateTime.getMinute());//23
        /*
        * withXxx()：类似于set方法，设置相关的属性
        * */
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);//此方法设置日期
        System.out.println(localDateTime);//不可变性，localDateTime未改变
        System.out.println(localDateTime2);

        /*
        * 加减操作
        * 加：plusXxx()
        * 减：minusXxx()
        * */
        LocalDateTime localDateTime3 = localDateTime.plusDays(1);//不可变性
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
//        localDateTime.minusXxx()
    }
}
