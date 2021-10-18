package src1;

/**
 * @author DzcGood
 * @date 2021/10/16 - 19:32
 */
@MyAnnotation("hi")
public class Person extends Creature<String> implements Comparable<Person>, MyInterface{
    private String name;
    int age;
    public int id;

    public Person() {
    }

    private Person(String name) {
        this.name = name;
    }

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String show(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    @Override
    public void display(){
        System.out.println("我是一个人");
    }

    @Override
    @MyAnnotation
    public int compareTo(Person p){
        return this.name.compareTo(p.name);
    }

    public String showInterest(String interests, int age) throws NullPointerException, ClassCastException{
        return interests;
    }
}
