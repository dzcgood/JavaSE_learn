import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * @author DzcGood
 * @date 2021/10/3 - 16:49
 */
public class PropertiesTest {
    //Properties：常用来处理配置文件，key和value都是String类型
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        FileInputStream fis;
        fis = new FileInputStream("jdbc.properties");
        properties.load(fis);
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");
        System.out.println("name = " + name + ", password = " + password);//name = Tom, password = abc123
        fis.close();
    }
}
