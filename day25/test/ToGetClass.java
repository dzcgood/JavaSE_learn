import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/10/16 - 2:44
 */

/*
* 获取Class实例的四种方式
* */
public class ToGetClass {
    @Test
    public void test1() throws Exception{
        //方式一：类名.class
        Class<Person> personClass1 = Person.class;
        System.out.println(personClass1);//class Person
        //方式二：通过运行时类的对象
        Person person = new Person();
        Class<? extends Person> personClass2 = person.getClass();
        //方式三：调用Class的静态方法：forName(String classPath)，classPath需要带上包名
        Class<?> clazz = Class.forName("Person");
        //以下两行代码说明：加载到内存中的运行时类，会缓存一段时间，在此时间内，我们可以通过不同的方式来获取此运行时类
        System.out.println(personClass1 == personClass2);//true
        System.out.println(personClass1 == clazz);//true
        //方式四：使用类的加载器ClassLoader,所在类名.class.getClassLoader
        ClassLoader classLoader = ToGetClass.class.getClassLoader();
        Class<?> clazz1 = classLoader.loadClass("Person");
    }
}
