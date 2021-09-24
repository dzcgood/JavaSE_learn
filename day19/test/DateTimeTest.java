import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author DzcGood
 * @date 2021/9/10 - 17:36
 */

/*
* JDK8之前的时间API测试
* 1、System类中currentTimeMillis();
* 2、java.util.Date和其子类java.sql.Date
* 3、SimpleDateFormat
* 4、Calendar
* */
public class DateTimeTest {
    /*
    * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
    * 1、两个操作
    *   1.1 格式化：日期 --> 字符串
    *   1.2 解析：字符串 --> 日期
    * 2、SimpleDateFormat的实例化
    * */
    @Test
    public void test1(){
        //实例化SimpleDateFormat：使用默认构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期 --> 字符串
        Date date = new Date();
        System.out.println(date);//Fri Sep 10 17:42:39 CST 2021
        String format = sdf.format(date);//格式化返回的是字符串
        System.out.println(format);//21-9-10 下午5:42
        //解析：字符串 --> 日期
        String str = "21-9-12 上午1:00";
        Date date1 = null;
        try {
            date1 = sdf.parse(str);//parse方法会抛出异常，需要try-catch
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        /*
            实例化SimpleDateFormat：使用带参数的构造器（可以去API里面找）
            指定的构造器可以使用指定的格式进行格式化和解析
        */
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
        String format1 = sdf1.format(date);
        System.out.println(format1);//02021.九月.12 公元 01:07 上午
        /*
        *   发中几个常用的格式:
        *   y：年
        *   M：月
        *   d：日
        *   h：时
        *   m：分
        *   s：秒
        * */
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//开发中喜欢用这种
        System.out.println(sdf2.format(new Date()));//2021-09-12 01:11:25
        //解析，必须使用创建该对象时指定的格式
        try {
            //sdf2只能识别"yyyy-MM-dd hh:mm:ss"格式的时间
            Date date2 = sdf2.parse("2020-01-02 23:32:11");
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /*
    * 练习一：字符串”2020-09-08“转换成java.sql.Date类
    * 练习二：从1990-01-01开始，”三天打鱼，两天晒网“。问之后的某年某月某日，渔夫是在打鱼，还是在晒网
    *        思路：先求得题目日期距离1990-01-01年有多少天，然后取模5运算
    *             总天数求法：利用天数求得时间戳，二者相减。
    *             总天数 = (date1.getTime() - date2.getTime()) / (1000 * 60 *60 *24) + 1
    *             总天数 % 5 == 0，4 在晒网
    *             总天数 % 5 == 1，2，3 在打鱼
    * */
    @Test
    public void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
           date = sdf.parse("2020-09-08");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date birthDate = new java.sql.Date(date.getTime());//java.sql.Date类的带参构造器
        System.out.println(birthDate);
    }


    /*
    * java.util.Calendar类（日历类，抽象类）的使用
    * */
    @Test
    public  void test3(){
        //实例化
        //方式一：创建其子类的对象
        //方式二：调用其静态方法getInstance()方法
        Calendar calendar = Calendar.getInstance();//返回的是java.util.GregorianCalendar类对象
                                                //对应当前时间

        //常用方法：
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);//今天是这个月的第几天
        System.out.println(days);//13
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));//今天是今年的第几天,256
        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);//calendar类对象本身的信息被修改（类信息改成当前是这个月的第22天）
        //add()
        calendar.add(Calendar.DAY_OF_MONTH,3);//在现有这个月的第几天上，加了三天，变成第25天
        //getTime()，用于日历类 --> Date类
        Date date = calendar.getTime();
        System.out.println(date);
        //setTime()，用于Date --> 日历类
        calendar.setTime(new Date());
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

    }
}
