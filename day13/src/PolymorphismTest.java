/**
 * @author DzcGood
 * @date 2021/8/13 - 20:04
 */

/*
* 多态性练习
* */

class Base{
    int count = 10;
    public void display(){
        System.out.println("count = " + count);
    }
}

class Sub extends Base{
    int count = 20;
    public void display(){
        System.out.println("count = " + count);
    }
}
public class PolymorphismTest {
    public static void main(String[] args) {
        Sub s = new Sub();
        System.out.println("s.count = " + s.count);//20
        s.display();//20
        Base b = s;
        // ==运算符作用于引用数据类型，其作用是比较二者的地址是否相同
        System.out.println(b == s);//true
        System.out.println("b.count = " + b.count);//10，多态不做用于属性
        b.display();//20，多态

    }
}
