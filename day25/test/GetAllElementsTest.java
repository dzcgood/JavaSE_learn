import org.junit.Test;

import src1.Person;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

/**
 * @author DzcGood
 * @date 2021/10/16 - 19:43
 */

/*
* 获取运行时类的所有结构
* */
public class GetAllElementsTest {
    //获取属性
    @Test
    public void test1(){
        Class<Person> personClass = Person.class;
        //获取属性结构
        //getFields()：获取当前运行时类及其所有父类中声明为public的属性
        Field[] fields = personClass.getFields();//只能获取权限为public的属性
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("/////////////////////////////////////");
        //getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类）
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
    }

    //权限修饰符，数据类型，变量名
    @Test
    public void test2(){
        Class<Person> personClass = Person.class;
        //getDeclaredFields()：获取当前运行时类中声明的所有属性（不包含父类）
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            //1、权限修饰符，public对应1，private是2,protected是4，default是0
            int modifiers = declaredField.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");//可以转换为字符串
            //2、数据类型
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + "\t");
            //3、变量名
            String name = declaredField.getName();
            System.out.println(name);
        }
    }


    //获取方法
    @Test
    public void test3(){
        Class<Person> personClass = Person.class;
        //getMethods()：获取该运行类及其父类所有声明为public的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("////////////////////////////////");
        //getDeclaredMethods()：获取当前类声明的所有方法（不包括父类）
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
    }

    /*
    @Xxxx
    权限修饰符 返回值类型 方法名(参数类型1 形参名1, ...) throws XxxException
    */
    @Test
    public void test4(){
        Class<Person> personClass = Person.class;
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            //1、获取注解（只能获取Retention.RUNTIME的注解）
            Annotation[] annotations = declaredMethod.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation);
            }
            //2、权限修饰符
            int modifiers = declaredMethod.getModifiers();
            System.out.print(Modifier.toString(modifiers) + "\t");
            //3、返回值
            System.out.print(declaredMethod.getReturnType().getName() + "\t");
            //4、方法名
            System.out.print(declaredMethod.getName());
            //5、形参列表
            System.out.print("( ");
            Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
            if(!(parameterTypes == null || parameterTypes.length == 0)){
                //表示有参数
                for (int i = 0; i < parameterTypes.length; i++){
                    System.out.print(parameterTypes[i].getName() + " args_" + i);
                    if(i < parameterTypes.length -1) System.out.print(", ");
                }
            }
            System.out.print(" )");
            //6、抛出的异常
            Class<?>[] exceptionTypes = declaredMethod.getExceptionTypes();
            if(!(exceptionTypes == null || exceptionTypes.length == 0)){
                //有抛出异常
                System.out.print("throws ");
                for (int i = 0; i < exceptionTypes.length; i++) {
                    System.out.print(exceptionTypes[i].getName());
                    if(i != exceptionTypes.length -1){
                        System.out.print(", ");
                    }
                }
            }
        }
    }

    /*
    获取构造器结构
    */
    @Test
    public void test5(){
        Class<Person> personClass = Person.class;
        //getConstructors()：获取当前运行时类中声明为public的构造器（不包含父类）
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        //getDeclaredConstructors()：获取当前运行时类中声明的所有构造器（不包含父类）
        Constructor<?>[] declaredConstructors = personClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
    }


    /*
    * 获取运行时类的父类
    * */
    @Test
    public void test6(){
        Class<Person> personClass = Person.class;
        Class<? super Person> superclass = personClass.getSuperclass();
        System.out.println(superclass);//class src1.Creature
    }

    /*
     * 获取运行时类的带泛型的父类
     * */
    @Test
    public void test7(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        System.out.println(genericSuperclass);//src1.Creature<java.lang.String>
    }


    /*
     * 获取运行时类的带泛型的父类的泛型
     * */
    @Test
    public void test8(){
        Class<Person> personClass = Person.class;
        Type genericSuperclass = personClass.getGenericSuperclass();
        //强转
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        System.out.println(actualTypeArguments[0]);//class java.lang.String
        System.out.println(actualTypeArguments[0].getTypeName());//java.lang.String
        System.out.println(((Class)(actualTypeArguments[0])).getName());//java.lang.String
    }

    /*
    * 获取运行时类的接口
    * */
    @Test
    public void test9(){
        Class<Person> personClass = Person.class;
        //返回当前运行时类的接口（不包括父类）
        Class<?>[] interfaces = personClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        //获取运行时类父类的接口
        Class<?>[] interfaces1 = personClass.getSuperclass().getInterfaces();
        for (Class<?> aClass : interfaces1) {
            System.out.println(aClass);
        }
    }

    /*
    * 获取运行时类所在的包
    * */
    @Test
    public void test10(){
        Class<Person> personClass = Person.class;
        Package aPackage = personClass.getPackage();
        System.out.println(aPackage);//package src1
    }

    /*
    * 获取运行时类声明的注解
    * */
    @Test
    public void test11(){
        Class<Person> personClass = Person.class;
        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.print(annotation + "\t");//@src1.MyAnnotation(value=[hi])
        }
    }
}
