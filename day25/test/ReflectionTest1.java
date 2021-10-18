import org.junit.Test;
import src1.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author DzcGood
 * @date 2021/10/18 - 8:39
 */

/*
* 调用运行时类中指定的结构：属性、方法、构造器
* */
public class ReflectionTest1 {
    //属性
    //不理想，只能获取public
    @Test
    public void testField() throws Exception{
        Class<Person> personClass = Person.class;
        //创建运行时类的对象
        Person person = personClass.newInstance();
        //获取指定的属性：要求获取的属性声明为public
        Field id = personClass.getField("id");
        //设置当前属性的值
        //set()：参数1：指明设置哪个对象的属性，参数2：将此属性值设置为多少
        id.set(person, 10);
        /*
        * 获取当前对象属性值
        * get()：参数1：获取哪个对象的当前属性值
        * */
        int i = (int)id.get(person);
        System.out.println(i);//10
    }

    /*
    * 获取属性的方法2，可以获取所有权限的属性。 开发中使用这种
    * */
    @Test
    public void testField1() throws Exception{//
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        //获取属性
        Field name = personClass.getDeclaredField("name");
        //将accessible权限设置为true,保证当前属性是可访问的
        name.setAccessible(true);//对于private属性，默认是false，不可访问
        //设置属性
        name.set(person, "Tom");
        //获取属性
        System.out.println(name.get(person));//Tom
    }

    @Test
    public void testMethod() throws Exception{
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        /*
        * 1、获取指定的某个方法
        *   > 参数1：方法名称
        *   > 参数2：要获取的方法的形参列表
        * */
        Method showInterest = personClass.getDeclaredMethod("showInterest", String.class, int.class);
        //保证当前方法是可访问的
        showInterest.setAccessible(true);
        //方法调用，invoke()：参数1：调用者。 参数2：实参列表
        String nation = (String)showInterest.invoke(person, "China", 10);// String showInterest()
        System.out.println(nation);
        //////////////////////调用静态方法///////////////////////////////
        Method showDesc = personClass.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);
        Object returnVal = showDesc.invoke(Person.class);//静态方法，调用者是当前类
        showDesc.invoke(null);//静态方法，调用者写成null也可以
        System.out.println(returnVal);//因为返回值是void，所以returnVal是null
    }

    /*
    * 调用运行时类中指定的构造器
    * */
    @Test
    public void testConstructor() throws Exception{
        Class<Person> personClass = Person.class;
        /*
        * getDeclaredConstructor()参数1：构造器的形参列表
        * */
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, int.class);
        //保证构造器是可访问的
        constructor.setAccessible(true);
        //创建运行时类的对象
        Person tom = constructor.newInstance("Tom", 10);
    }
}
