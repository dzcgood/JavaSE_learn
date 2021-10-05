import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author DzcGood
 * @date 2021/10/5 - 22:07
 */

/*
* File类的使用
* 1、File类的一个对象，代表一个文件或一个文件目录（俗称：文件夹）
* 2、File类声明在java.io下
* 3、File类中涉及到关机文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法，并未涉及到写入或读取文件内容的操作，
*   如果需要读取或写入文件内容，必须使用IO流来完成
* 4、后续File类对象通常会作为参数传递到流的构造器中，指明读取或写入的“目标”
* */
public class FileTest {
    /*
    * 1、如何创建File类对象
    * 2、
    *   相对路径：相较于某个路径下，指明的路径
    *   绝对路径：包含盘符在内的文件或文件目录的路径
    * 3、路径分隔符和系统有关
    *   windows和dos系统中，是'\'
    *   Unix和URL中，是'/'
    * */
    @Test
    public void test1(){
        //构造器一：File(String pathName)
        File file1 = new File("hello.txt");//表示在当前路径下的hello.txt文件
        File file2 = new File("G:\\JAVA\\learn\\day23");
//        File.separatorChar：如果不记得是'\'还是'/'，可以使用File.separatorChar
        System.out.println(file1);
        System.out.println(file2);//尽管磁盘中没有这个文件/目录，也不会报错

        //构造器二：File(String parent, String child)：在parent路径下新建child路径/文件
        File file3 = new File("G:\\JAVA\\learn\\day23", "JavaSenior");
        System.out.println(file3);//G:\JAVA\learn\day23\JavaSenior

        //构造器三：File(File parent, String child)：类似于构造器二
        File file4 = new File(file3, "hello.txt");
        System.out.println(file4);//G:\JAVA\learn\day23\JavaSenior\hello.txt
    }

    /*
    * File类常用方法
    * 1、public String getAbsolutePath()：获取绝对路径
    * 2、public String getPath()：获取路径
    * 3、public String getName()：获取名称
    * 4、public String getParent()：获取上层文件目录路径，若无，返回null
    * 5、public long length()：获取文件长度（即：字节数）。不能获取目录的长度
    * 6、public long lastModified()：获取最后一次的修改时间，毫秒值
    * 如下的两个方法适用于文件目录
    * 7、public String[] list()：获取指定目录下的所有文件或者文件目录的名称数组
    * 8、public File[] listFiles()：获取指定目录下的所有文件或者文件目录的File数组
    * */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("G:\\JAVA\\learn\\day23\\JavaSenior\\hello.txt");
        System.out.println(file1.getAbsolutePath());//G:\JAVA\learn\day23\hello.txt
        System.out.println(file1.getPath());//hello.txt
        System.out.println(file1.getName());//hello.txt
        System.out.println(file1.getParent());//null，以相对路径创建的file不能获取parent
        System.out.println(file1.length());//0，因为文件不存在
        System.out.println(file1.lastModified());//0。因为文件不存在

        System.out.println();

        System.out.println(file2.getAbsolutePath());//G:\JAVA\learn\day23\JavaSenior\hello.txt
        System.out.println(file2.getPath());//G:\JAVA\learn\day23\JavaSenior\hello.txt
        System.out.println(file2.getName());//hello.txt
        System.out.println(file2.getParent());//G:\JAVA\learn\day23\JavaSenior
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

        File file = new File("G:\\JAVA\\learn\\day23");
        String[] list = file.list();
        for (String s : list) {
            //day23.iml src test
            System.out.print(s + " ");
        }
        System.out.println();
        File[] files = file.listFiles();
        for (File file3 : files) {
            //G:\JAVA\learn\day23\day23.iml G:\JAVA\learn\day23\src G:\JAVA\learn\day23\test
            System.out.print(file3 + " ");
        }
    }

    /*
    * public boolean renameTo(File desc)：把文件重命名喂指定的文件路径
    * 比如：file1.renameTo(file2)
    *       要想保证操作成功：必须保证file1必须存在于硬盘中，且file2不能在硬盘中存在
    * */
    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        File file2 = new File("E:\\hi.txt");
        boolean renameTo = file1.renameTo(file2);
    }

    /*
    * 判断相关
    * public boolean isDirectory()：是否是文件目录
    * public boolean isFile()：是否是文件
    * public boolean exists()：是否存在
    * public boolean canRead()：是否可读
    * public boolean canWrite()：是否可写
    * public boolean isHidden()：是否隐藏
    * */
    @Test
    public void test4(){
        File file = new File("hello.txt");
        System.out.println(file.isFile());//true
        System.out.println(file.isDirectory());//false
        System.out.println(file.exists());//true
        System.out.println(file.canRead());//true,目录也是可读可写的
        System.out.println(file.canWrite());//true
        System.out.println(file.isHidden());//false
    }

    /*
    * 增删相关
    * public boolean createNewFile()：若文件不存在，则创建文件
    * public boolean mkdir()：创建目录，若目录存在或上级目录不存在，则不创建
    * public boolean mkdirs()：创建目录，若上级目录不存在，则一并创建
    * public boolean delete()：删除文件或文件夹，若要删除一个目录，必须保证该目录下没有别的文件和目录
    * */
    @Test
    public void test5(){
        //文件的创建与删除
        File file = new File("hello1.txt");
        if(!file.exists()){
            try {
                file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file.delete();
            System.out.println("删除成功");
        }
        //目录的创建与删除
        //父目录存在的情况下
        File file1 = new File("G:\\JAVA\\learn\\day23\\createDirectoryTest");
        if(!file1.exists()){
            file1.mkdir();
            System.out.println("创建成功");
        }else{
            file1.delete();
            System.out.println("删除成功");
        }

        //父目录不存在的情况下，使用mkdirs()
        File file2 = new File("G:\\JAVA\\learn\\day23\\createDirectoryTest1\\test");
        if(!file2.exists()){
            file2.mkdirs();
            System.out.println("创建成功");
        }else{
            file2.delete();
            System.out.println("删除成功");
        }
    }
}
