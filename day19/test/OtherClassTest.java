import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author DzcGood
 * @date 2021/9/24 - 16:03
 */

/*
* 其他常用类的使用
* 1、System
* 2、Math
* 3、BigInteger、BigDecimal
* */
public class OtherClassTest {
    //System类
    @Test
    public void test1(){
        //getProperty(),参数有java.version, java.home, os.name, os.version, user.name, user.dir
        String property = System.getProperty("java.version");//java版本
        System.out.println(property);//1.8.0_291
        String property1 = System.getProperty("java.home");//javahome的路径
        System.out.println(property1);//C:\Program Files\Java\jdk1.8.0_291\jre
        String property2 = System.getProperty("os.name");//系统名
        System.out.println(property2);//Windows 10
        String property3 = System.getProperty("os.version");//系统版本
        System.out.println(property3);//10.0
        String property4 = System.getProperty("user.name");//系统用户名
        System.out.println(property4);//邓智超
        String property5 = System.getProperty("user.home");//用户路径
        System.out.println(property5);//C:\Users\DzcGood
        String property6 = System.getProperty("user.dir");//当前工作路径
        System.out.println(property6);//G:\JAVA\learn\day19
    }

    //Math类
    @Test
    public void test2(){
        /*
        * 常用方法：
        * abs 绝对值
        * acos, asin, atan, sin, cos, tan 三角函数
        * sqrt 平方根
        * pow(double a, double b) a的b次幂
        * log 自然对数
        * exp e为低指数
        * max(double a, double b)
        * min(double a, double b)
        * random() 返回[0.0, 1.0)的随机数
        * long round(double a) double型数据a转换为long型(四舍五入)
        * toDegrees(double angrad) 弧度 -> 角度
        * toRadians(double angdeg) 角度 -> 弧度
        * */
    }

    //BigInteger和BigDecimal
    @Test
    public void test3(){
        BigInteger bi = new BigInteger("12435678765432456789876543234567898765434567890987654345678987654");
        BigDecimal bd = new BigDecimal("1345.54232");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));//四舍五入的方式
        System.out.println(bd.divide(bd2, 25, BigDecimal.ROUND_HALF_UP));//四舍五入的方式，保留25位小数
    }
}
