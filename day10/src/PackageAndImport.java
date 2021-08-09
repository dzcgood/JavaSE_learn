/**
 * @author DzcGood
 * @date 2021/8/9 - 16:19
 */

/*
* 一、package关键字的使用
*   1、package语句必须放在源文件的第一行
*   2、包名属于标识符，必须符合标识符命名规则（推荐使用全小写），中间用‘.’连接，如java.util.Arrays
*   3、同一个包下，不可创建同名的类或接口
* 二、import关键字的使用
*   1、作用：在源文件中显式导入指定包下的类、接口
*   2、声明位置：在包的声明和类的声明之间
*   3、使用”xxx.*“表示导入该包下的所有类、接口
*   4、如果使用的类或接口定义在java.lang下，则系统会自动导入
*   5、如果源文件中使用了不同包下的同名的类，则必须使用全类名（包名.类名）来调用类名
*   6、import static 表示导入指定类或接口中的静态结构，如import java.lang.System.*，则输出语句可写成 out.println()
*
*
*
* */

public class PackageAndImport {
}
