import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author DzcGood
 * @date 2021/10/16 - 1:47
 */
public class ReflectionTest {
    //反射之前，对于Person的操作
    @Test
    public void test1(){
        //1、创建Person类的对象
        Person person = new Person("Tom", 12);
        //2、通过对象，调用其内部的属性、方法
        person.age = 10;
        System.out.println(person.toString());
        person.show();
        //在Person类外部，不可以通过Person类对象调用其内部私有结构
        //比如：name、showNation()以及私有构造器
    }

    //有了反射之后，对于Person的操作
    @Test
    public void test2() throws Exception {
        //1、通过反射，创建类的对象
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        Person person = constructor.newInstance("Ton", 12);
        System.out.println(person.toString());
        //2、通过反射，调用对象指定的属性和方法
        //调用属性
        Field age = personClass.getDeclaredField("age");
        age.set(person, 10);
        System.out.println(person);
        //调用方法
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(person);
        //3、通过反射，调用类的私有结构，如私有属性、私有方法、私有构造器
        //调用私有构造器
        Constructor<Person> declaredConstructor = personClass.getDeclaredConstructor(String.class);
        declaredConstructor.setAccessible(true);
        Person person1 = declaredConstructor.newInstance("Jerry");
        System.out.println(person1);
        //调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person1, "Mike");
        System.out.println(person1);
        //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        //相当于String nation = person1.showNation("中国")
        String nation = (String) showNation.invoke(person1, "中国");

    }

}
