import dzc.good.*;

/**
 * 如果在一个模块需要用到另外一个模块的类，就需要：
 * ①在两个类的src目录下都建立module-info.java文件夹
 * ②被引用类module-info.java中，将被使用的类所在的包名exports，格式： exports 包名;
 * ③在引用别的模块的类的module-info.java中，格式为：requires 模块名;
 * ④最后，在project structures的使用者module下配置依赖dependencies
 * @author DzcGood
 * @date 2021/10/22 - 16:32
 */
public class ModuleTest {
    public static void main(String[] args) {
        Person person = new Person("Tom",12);
    }
}
