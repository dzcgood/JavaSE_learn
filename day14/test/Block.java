/**
 * @author DzcGood
 * @date 2021/8/15 - 20:12
 */
/*
* 代码块（初始化块）
* 1、功能：用于初始化类、对象
* 2、只能使用static关键字修饰代码块
* 3、分类：静态代码块、非静态代码块
* 4、静态代码块
*   > 内部可以有输出语句
*   > 随着类的加载而执行，只会执行一次，除非类被多次加载
*   > 作用：初始化类的信息
*   > 一个类可以定义多个静态代码块，代码块之间的执行顺序按照声明的顺序（翻译：谁写在上面谁就先执行）
* 5、非静态代码块
*   > 内部可以有输出语句
*   > 随着类对象的加载而执行，每new一个类对象，就会执行一次
*   > 作用：在创建对象时，对对象初始化
*   > 一个类可以定义多个非静态代码块，代码块之间的执行顺序按照声明的顺序（翻译：谁写在上面谁就先执行）
* 6、一般不会写多个静态代码块或非静态代码块。写成一个就行了
* 7、类的结构初始化顺序：由父及子，静态优先；代码块的执行顺序先于构造器
* 8、对属性赋值的顺序
*   ①默认初始化
*   ②显式初始化
*   ③构造器
*   ④代码块
*   ⑤通过对象.属性名修改
*   执行顺序为 ① --> ②/④ -->③ --> ⑤，其中②④的顺序由声明顺序决定，谁写在上面，谁先执行
* */
public class Block {
    public static void main(String[] args) {
        new Person();
    }
}


class Person{
    String name;
    int age;
    static String desc = "我是一个人";

    //代码块
    static{
        System.out.println("HELLO STATIC BLOCK");
        desc = "我是一个爱学习的人";
    }

    //代码块
    {
        System.out.println("HELLO  BLOCK");
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Block{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

