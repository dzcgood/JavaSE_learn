/**
 * @author DzcGood
 * @date 2021/8/8 - 23:06
 */

/*
* this关键字的使用
*   this可用于区分成员变量和形参，可用于修饰属性、方法、构造器
*   通常选择省略this，但若方法的形参和类的属性同名时，必须使用this加以区分
*   使用成员变量： this.变量名 = 值
*   在一个构造器中调用另外一个构造器：  this(参数列表)，this()和super()必须放在第一行
*   构造器不能调用自己，不然就相当于没有终点的递归，永远不能结束；构造器的相互调用关系不能构成环，否则无出口
* */
public class This {
    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(10);
    }
}

class Person{
    private String name;
    private int age;

    public Person() {
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
}
