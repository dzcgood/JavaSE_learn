/**
 * @author DzcGood
 * @date 2021/9/27 - 0:36
 */

/*
* JDK提供的四种元注解
*   1、元注解：对现有的注解进行解释说明的注解
*   2、说明：
*       ① Retention：指明所修饰的Annotation的生命周期
*          其包括一个RetentionPolicy类型的成员变量，使用@Retention时必须为该value成员变量指定值
*           {RetentionPolicy.SOURCE, RetentionPolicy.CLASS, RetentionPolicy.RUNTIME}，
*           分别代表：
*                   源文件中有效：该注解会被编译器抛弃；
*                   class文件中有效：该注解在程序运行时会被抛弃（默认状态）；
*                    运行时有效：该注解在程序运行时有效
*       ② Target：指明所修饰的注解能够修饰什么程序元素，包括TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR,
*                   LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER,TYPE_USE
*       ③ Documented：表示所修饰的注解在被javadoc解析时，被提取成文档，
*                      定义为Documented的注解必须设置Retention值为RUNTIME
*       ④ Inherited:被修饰的注解将具有继承性
*          例如MyAnnotation被Inherited修饰，且被用于修饰Person类，那么Person类的子类也自动被MyAnnotation修饰
*   3、自定义注解通常都会指明两个元注解：Retention和Target
* */
public class MetaAnnotation {
}
