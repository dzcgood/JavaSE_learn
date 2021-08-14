import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/14 - 20:37
 */

/*
* 包装类的使用
* 1、原因：基本数据类型是和Object继承树毫无关系
*         他们不是类，这就不能很好体现面向对象思想，所以把基本数据类型封装到包装类中，使得基本数据类型有类的特征
* 2、对应关系：数值型的包装类有共同的父类Number类
*   byte -> Byte
*   short -> Short
*   int -> Integer
*   long -> Long
*   char -> Character
*   float -> Float
*   double -> Double
*   boolean -> Boolean
* 3、包装类的默认值是null
* */
public class Wrapper {
    //基本数据类型转换成包装类：调用包装类的构造器
    @Test
    public void test1(){
        int num = 10;
        Integer in1 = new Integer(num);
        System.out.println(in1.toString());
        Integer in2 = new Integer("123");//字符串构造器
//        Integer in2 = new Integer("123abc");//字符串构造器,会报字符串格式异常
        System.out.println(in2);
        double num2 = 12.3;
        Double d1 = new Double(num2);
        Double d2 = new Double("12.3");//字符串构造器
//        Double d2 = new Double("12.3abc");//字符串构造器,会报字符串格式异常
        Boolean b = new Boolean("true123");//不会报错，只要字符串不等于true（忽略大小写），那就是false
    }

    //包装被转换成基本数据类型:调用包装类的xxxValue()方法
    @Test
    public void test2(){
        Integer in1 = new Integer(10);
        int num1 = in1.intValue();//10
        Float f1 = new Float(12.3f);
        float num2 = f1.floatValue();//12.3f
    }


    //JDK5.0新特性：自动装箱与拆包
    @Test
    public void test3(){
        int num1 = 10;
        method(new Integer(num1));//本来应该这样才能调用
        method(num1);//这里进行了自动装箱
        int num2 = 12;
        Integer in1 = num2;//自动装箱
        int num3 = in1;//自动拆箱
    }

    public void method(java.lang.Object o){
        //do something
    }

    //基本数据类型、包装类转换成String类
    @Test
    public void test4(){
        //方法一，使用 + 运算符
        int num1 = 1001;
        String str1 = num1 + "";//"1001"
        //方法二，使用String重载的valueOf()方法
        float f1 = 123.45f;
        String str2 = String.valueOf(f1);//返回一个String
    }

    //String类转基本数据类型、包装类：使用包装类的parseXxx()方法
    @Test
    public void test5(){
        //可能会抛出NumberFormatException
        String str = "123.45";
        double d1 = Double.parseDouble(str);
        boolean b = Boolean.parseBoolean(str);//false
        System.out.println(b);
    }

    //面试题
    @Test
    public void test6(){
        java.lang.Object o = true ? new Integer(1) : new Double(2.0);
        System.out.println("o = " + o);//此处的输出结果是1.0
        /*
        * 两个大坑
        * 1、有的人会以为输出的是地址值，原因：由于多态性，调用的是Integer中重写过的toString
        * 2、有的人以为输出1，原因：因为：？运算符存在自动类型提升，所以实际上赋值给o的是 new Double(1.0)
        * */
    }

    //面试题
    @Test
    public void test7(){
        Integer i = new Integer(1);
        Integer j = new Integer(1);
        System.out.println(i == j);//false,比较的是地址值

        Integer m = 1;
        Integer n = 1;
        System.out.println(m == n);//true，常量池的原因，m和n的地址相同

        Integer u = 128;//等价于 u = new Integer(128); 自动包装
        Integer v = 128;//等价于 v = new Integer(128); 自动包装
        System.out.println(u == v);//false，常量池范围是-128 - 127
        // 128超出常量池范围，所以是new出来的，比较的是地址值
        /*
        * Integer内部定义了IntegerCache结构，IntegerCache中定义了Integer[]，保存了-128 ~ 127范围的整数
        * 如果使用自动装箱的方式，给Integer赋值的数在Integer[]范围内，可以直接使用数组中的元素，不会再去重新new
        * 主要目的是提高效率，因为我们使用的数字很大概率就落在-128 ~ 127这个范围内，所以提前加载在内存中了
        * */
    }
}


