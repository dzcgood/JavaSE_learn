import java.lang.annotation.*;
import java.util.ArrayList;

/**
 * @author DzcGood
 * @date 2021/9/25 - 23:51
 */

/*
* 自定义注解
* */
@Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
public @interface MyAnnotation {
    String value() default "hello";//这个是成员，不是方法。默认值是hello
}

/*
 * 实现可重复注解：
 * 1、JDK8之前的写法：
 *     public @interface MyAnnotations {
 *       MyAnnotation[] value;
 *    }
 *    @MyAnnotations({@MyAnnotation(value = "hi"), @MyAnnotation(value = "hello")})
 * 2、JDK8之后的写法：
 *   @Repeatable(MyAnnotations.class)
 *   public @interface MyAnnotation {
 *    String value() default "hello";//这个是成员，不是方法。默认值是hello
 *   }
 *   ①在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class
 *   ②MyAnnotation的Target、Retention等元注解必须和MyAnnotations相同
 * */

/*
* 类型注解
* 1、TYPE_PARAMETER：表示该注解能写在类型变量的声明语句中，如泛型声明
* 2、TYPE_USE：表示该注解能写在使用类型的任何语句中
* */
//TYPE_PARAMETER
class Generic<@MyAnnotation T>{//声明为TYPE_USE后，注解可以出现在任何类型前
    public void show()throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int)10L;
    }
}
