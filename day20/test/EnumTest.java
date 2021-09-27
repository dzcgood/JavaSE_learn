import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/9/25 - 15:34
 */

/*
* 一、枚举类的使用
*   1、枚举类的理解：类的对象只有有限个，确定的，我们称此类位枚举类
*   2、当需要定义一组常量时，强烈建议使用枚举类
*   3、如果枚举类中只有一个对象，则可以作为单例模式的实现方式
* 二、如何定义枚举类
*   方式一：JDK5.0之前，自定义枚举类
*   方式二：JDK5.0之后，可以使用enum关键字定义枚举类
* 三、Enum类的常用方法
*   1、values()
*   2、valueOf()
*   3、toString()
* 四、使用enum关键字定义的枚举类实现接口的情况
*   1、情况一：实现接口，在enum类中实现抽象方法
*   2、情况二:让枚举类的对象，分别去实现接口中的抽象方法
* */
public class EnumTest {
    @Test
    public void test1(){
        Season spring = Season.SPRING;
        System.out.println(spring);
    }

    @Test
    public void test2(){
        Season1 summer = Season1.SUMMER;
        //toString()方法
        System.out.println(summer);//父类重写了toString，输出为SUMMER
        System.out.println(summer.getClass().getSuperclass());//其父类是java.lang.Enum
        //2、values()方法:返回枚举类中所有常量组成的数组
        Season1[] values = Season1.values();
        for (int i = 0; i < values.length; i++) {
            values[i].show();//调用各自重写的show()方法
        }
        //Thread类中的内部枚举类
        Thread.State[] values1 = Thread.State.values();
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);
        }
        //valueOf(String ovjName)方法：返回枚举类中对象名是objName的对象，找不到的话，会抛出异常
        Season1 winter = Season1.valueOf("WINTER");//按照对象名WINTER去获得对象
    }
}

//自定义枚举类
class Season{
    //1、声明Season对象的属性:用private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2、私有化类的构造器
    private Season(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }
    //3、提供当前枚举类的多个对象，声明为public static final
    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冰天雪地");
    //其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}

interface Info{
    void show();
}

//使用enum定义枚举类
enum Season1 implements Info{
    //1、提供当前枚举类的多个对象，对象之间用",隔开"，最后一个对象以";"结束
    SPRING("春天", "春暖花开"){
        @Override
        public void show(){
            System.out.println("春天在哪里");
        }
    },
    SUMMER("夏天", "夏日炎炎"){
        @Override
        public void show(){
            System.out.println("宁静的夏天");
        }
    },
    AUTUMN("秋天", "秋高气爽"){
        @Override
        public void show(){
            System.out.println("秋天是分手的季节");
        }
    },
    WINTER("冬天", "冰天雪地"){
        @Override
        public void show(){
            System.out.println("大雪纷飞");
        }
    };
    //2、声明Season对象的属性:用private final修饰
    private final String seasonName;
    private final String seasonDesc;
    //2、私有化类的构造器
    private Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //其他诉求：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public void show(){
//        System.out.println("这是一个季节");
//    }
}
