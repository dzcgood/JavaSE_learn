import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

/**
 * @author DzcGood
 * @date 2021/9/25 - 21:48
 */

/*
* 注解的使用
* 1、理解注解
*   Annotation是代码里的特殊标记，这些标记可以在编译、类加载、运行时被读取，并执行相应的处理。通过使用Annotation，
*   程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息。
* 2、在某种意义上，框架 = 注解 + 映射 + 设计模式
* 3、Annotation的实例
*   > 示例一：生成文档相关的注解
*   > 示例二：在编译时进行格式检查（JDK内置的三个注解）
*       @Override：限定重写父类方法，该注解只能用于方法
*       @Deprecated：用于表示所修饰的元素（类、方法等）已过时。通常是因为所修饰的结构危险或存在更好的选择
*       @SuppressWarnings：抑制编译器警告
*   > 示例三：跟踪代码依赖性，实现替代配置文件功能
* 4、如何自定义注解：参照SuppressWarnings定义
*   ① 注解定义格式为 @interface
*   ② 内部定义成员，通常使用value表示
*   ③ 可以指定成员的默认值，使用default定义
*   ④ 如果自定义注解没有成员，表明是一个“标识”作用
*   如果注解用成员，在使用注自定义注解必须配上注解的信息处理流程（使用反射）才有意义解时，需要指明成员的值
*
* */
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num = 10;//抑制编译器对于”定义的变量未使用”的警告
        @SuppressWarnings({"unused", "rawtypes"})//抑制编译器对于”定义的变量未使用”和"未使用泛型"的警告
        ArrayList list = new ArrayList();
    }

    //通过反射获取注解
    @Test
    public void test(){
        Class student = Student.class;
        Annotation[] annotations = student.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);//@MyAnnotation(value=hi)
        }
    }
}

@MyAnnotation(value = "hi")//使用自定义的注解
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

class Student extends Person{
    @Override//重写父类方法的注释，会在编译的时候强制要求重写方法（可用作检查校验）
    public void walk(){
        System.out.println("学生走路");
    }
}




