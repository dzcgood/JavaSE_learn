import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**
 * @author DzcGood
 * @date 2021/9/23 - 16:10
 */

/*
* DateTimeFormatter类的使用
* 1、类似于SimpleDateFormatter
* */
public class DateTimeFormatterTest {
    @Test
    public void test1(){
        //实例化方式
        //方式1：预定义的格式（ISO_LOCAL_DATE_TIME, ISO_LOCAL_DATE, ISO_LOCAL_TIME）
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String format = formatter.format(localDateTime);
        System.out.println(localDateTime);//2021-09-23T16:14:51.195
        System.out.println(format);//2021-09-23T16:14:51.195
        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2021-09-23T16:14:51.195");
        System.out.println(parse);//{},ISO resolved to 2021-09-23T16:14:51.195
        //实例化方式二:本地化相关的格式，如ofLocalizedDateTime(FormatStyle.LONG)
        //FormatStyle.LONG, FormatStyle.MEDIUM, FormatStyle.SHORT: 适用于LocalDateTime
        //形参不同，格式化后的格式不同
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        String format1 = dateTimeFormatter.format(localDateTime);
        System.out.println(format1);//21-9-23 下午4:24
        //本地化相关的格式，ofLocalizedDate()
        //FormatStyle.FULL, FormatStyle.LONG, FormatStyle.MEDIUM, FormatStyle.SHORT: 适用于LocalDate
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String format2 = dateTimeFormatter1.format(LocalDate.now());
        System.out.println(format2);//2021年9月23日 星期四
        //重点： 实例化方式三，自定义的格式，如ofPattern("yyyy-MM-dd hh:mm:ss E ")
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String format3 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format3);//2021-09-23 04:45:20 (十二小时制)
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2021-09-23 04:45:20");
        //{SecondOfMinute=20, MinuteOfHour=45, MicroOfSecond=0, NanoOfSecond=0, HourOfAmPm=4, MilliOfSecond=0},ISO resolved to 2021-09-23
        System.out.println(parse1);
    }
}
