/**
 * @author DzcGood
 * @date 2021/8/12 - 22:24
 */

/*
* 方法的重写（override/overwrite）
* 1、子类继承父类后，可以重写父类中的方法，对其进行覆盖
* 2、重写之后，创建子类的对象，调用的方法就会是重写后的方法
* 3、重写的规定
*   3.1 约定速成：子类中的方法叫”重写的方法“，父类中的方法叫做”被重写的方法“
*   3.2 重写的方法和被重写的方法，二者的方法名，形参列表都相同
*   3.3 重写的方法的权限修饰符不小于父类被重写的的权限修饰符
*       特殊情况：子类不能重写父类中权限为private的方法
*   3.4 如果父类被重写的方法的返回值类型是void，则子类重写的方法返回值类型只能是void
*       如果父类被重写的方法的返回值类型是A类，则子类重写的方法返回值类型可以是A类或者A类的子类
*       如果父类被重写的方法的返回值类型是基本数据类型（如double），则子类重写的方法返回值类型只能是相同的基本数据类型（double）
*   3.5 子类重写的方法抛出的异常类型不大于父类被重写方法抛出的异常
* 4、子类和父类中同名同参数的方法，要么都声明为static（不是重写），要么都声明为非static（考虑重写），因为static是不能被重写的
*
*
*
* 面试题：区分方法的重载与重写
* */
public class OverRide {
    public static void main(String[] args) {
        Student s = new Student("计算机科学与技术");
        s.walk(10);
        s.eat();
        s.study();
    }
}

class Person{
    String name;
    int age;

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

    public void eat(){
        System.out.println("Eating");
    }

    public void walk(int distance){
        System.out.println("走路，距离是" + distance +"km");
    }
}

class Student extends Person{
    String major;

    public Student() {
    }

    public Student(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void study(){
        System.out.println("学习，专业是" + major);
    }

    @Override
    public void eat(){//重写Person类的方法
        System.out.println("学生应该多吃有营养的食物");
    }
}
