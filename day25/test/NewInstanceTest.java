import org.junit.Test;

import java.util.Random;

/**
 * @author DzcGood
 * @date 2021/10/16 - 18:51
 */

/*
* 通过反射创建运行时类的对象
* */
public class NewInstanceTest {
    @Test
    public void test1() throws Exception{//记得用try-catch-finally
        Class<Person> personClass = Person.class;
        /*
        * newInstance()：调用此方法，创建运行时类的对象。不鼓励使用。内部调用了Person的空参构造器
        * 要想此方法正常地创建运行时类的对象，要求：
        * 1、运行时类必须提供空参的构造器
        * 2、空参的构造器的访问权限得够，通常设置为public
        * 在JavaBean中，要求提供一个public的空参构造器。原因“
        * 1、便于通过反射创建运行时类的对象
        * 2、便于子类继承此运行时类时，默认调用super()空时，保证父类有此构造器
        * */
        Person person = personClass.newInstance();
        System.out.println(person);
    }

    //体会反射的动态性
    @Test
    public void test2() throws Exception{
        for (int i=0;i < 100; i++) {
            int j = new Random().nextInt(3);//0,1,2
            String classPath = "";
            switch (j){
                case 0:
                    classPath = "java.util.Date";
                    break;
                case 1:
                    classPath = "java.lang.Object";
                    break;
                case 2:
                    classPath = "Person";
                    break;
            }
            System.out.println(getInstance(classPath));
        }
    }

    /*
    * 创建一个指定类的对象
    * classPath：指定类的全类名
    * */
    public Object getInstance(String classPath) throws Exception{
        Class<?> aClass = Class.forName(classPath);
        return aClass.newInstance();
    }
}
