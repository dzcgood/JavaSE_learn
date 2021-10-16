import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author DzcGood
 * @date 2021/10/16 - 17:11
 */

/*
* 了解类的加载器
* 1、引导类加载器：加载Java核心库，该加载器无法直接获取
* 2、扩展类加载器：加载jre/lib/ext里面的jar包
* 3、系统类加载器：加载自己写的类，是最常用的加载器
* */
public class ClassLoaderTest {
    @Test
    public void test(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);//sun.misc.Launcher$AppClassLoader@18b4aac2，是系统类加载器
        //调用系统加载器的getParent()，获取扩展类加载器
        System.out.println(classLoader.getParent());//sun.misc.Launcher$ExtClassLoader@2ff4acd0，是扩展类加载器
        //调用扩展类加载器的getParent()，无法获取引导类加载器
        //引导类加载器无法直接获取，无法加载自定义类
        System.out.println(classLoader.getParent().getParent());//null，因为引导类加载器无法加载
        //String是核心类，由引导类加载器加载，所以无法获取
        ClassLoader classLoader1 = String.class.getClassLoader();
        System.out.println(classLoader1);//null
    }

    /*
    * 使用ClassLoader加载配置文件
    * 注意方式一和方式二的文件默认位置
    * */
    @Test
    public void test2() throws Exception{
        Properties properties = new Properties();
        //此时的文件默认在当前的module下
        //读取配置文件的方向一：
//        FileInputStream fis = new FileInputStream("jdbc.properties");
//        properties.load(fis);
        //方法二：
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //此时的文件默认在当前module的src下
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        properties.load(is);
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        System.out.println(user);
        System.out.println(password);
    }
}