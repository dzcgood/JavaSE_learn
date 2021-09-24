import org.junit.Test;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author DzcGood
 * @date 2021/9/20 - 22:41
 */
public class InstantTest {
    /*iuytro
    * Instant类的使用
    * */
    @Test
    public void test(){
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();//静态方法
        System.out.println(instant);//2021-09-20T14:46:15.739Z，对应的是UTC时间，比北京时间晚八个小时
        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);//2021-09-20T22:46:15.739+08:00
        //toEpochMilli():获取瞬时点对应自1970年1月1日0时0分的毫秒数,类似于Date类的getTime()
        long l = instant.toEpochMilli();
        System.out.println(l);//1632149304356
        //ofEpochMilli():通过给定的毫秒数，获取Instant实例。 类似于Date(long milli)
        Instant instant1 = Instant.ofEpochMilli(1632149304356L);
        System.out.println(instant1);
    }

}
