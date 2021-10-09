import org.junit.Test;

import java.io.*;

/**
 * @author DzcGood
 * @date 2021/10/10 - 0:45
 */

/*
* 对象流的使用
* 1、ObjectInputStream和ObjectOutputStream
* 2、用于存储和读取基本数据类型诗句或对象的处理流。可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来
* 3、自定义类实现序列化和反序列化的操作：需要实现Serializable接口，提供public static final long serialVersionUID
*   > 凡是标识为Serializable的类，就表示该类是可序列化的
*   > Serializable接口下没有具体要实现的方法
*   > 如果不提供serialVersionUID，java运行环境会根据类的内部细节自动生成一个，但是若当前的类发生了变化，serialVersionUID
*     可能发生变化，导致在反序列化的时候出问题。所以建议显示声明
*   > 除了被序列化的类声明为serializable，其内部所有属性也必须是可序列化的（基本数据类型默认都是可视化的）
*   > 声明为static或transient的属性不能被序列化
*
* */
public class ObjectStreamTest {
    /*
    * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    * 使用ObjectOutputStream
    * */
    @Test
    public void test1() throws IOException {
        ObjectOutputStream oos = null;//序列化过程
        try {
            //造对象
            oos = new ObjectOutputStream(new FileOutputStream("Object.dat"));
            //写数据
            oos.writeObject(new String("我爱浙江"));
            oos.writeObject(new Person("Tom", 12));//自定义类的序列化
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null){
                try {
                    //关闭
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    * 反序列化：将磁盘文件中的对象还原为内存中的一个java对象
    * 使用ObjectInputStream来实现
    * */
    @Test
    public void test2(){
        ObjectInputStream ois = null;
        try {
            //造对象
            ois = new ObjectInputStream(new FileInputStream("Object.dat"));
            //读数据，写的时候是什么顺序，读的时候就是什么顺序。
            //开发中，一般都是同一类数据
            String str = (String)ois.readObject();
            Person person = (Person)ois.readObject();//自定义对象的反序列化
            System.out.println(str);
            System.out.println(person);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois != null){
                try {
                    //关闭流
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}



