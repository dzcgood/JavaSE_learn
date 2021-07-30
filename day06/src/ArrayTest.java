import java.util.Arrays;

/**
 * @author DzcGood
 * @date 2021/7/29 - 21:12
 */

/*
* 数组
* 1、数组是引用数据类型
* 2、数组的元素可以是基本数据类型，也可以是引用数据类型
* 3、数组的长度一旦确定，就不能修改
* */
public class ArrayTest {
    public static void main(String[] args) {
        //一维数组的使用
        //一维数组的声明和使用
        int[] ids = new int[]{1001, 1002, 1003, 1004};//静态初始化
        String[] names = new String[4];//动态初始化
        //使用数组指定位置的元素:通过下标,范围是[0, length - 1]
        names[0] = "DzcGood";
        names[1] = "LHH";
        names[2] = "HZL";
        names[3] = "HYG";
        //names[4] = "...." 下标越界，RunTimeError
        //获取数组长度
        int length = names.length;
        System.out.println("length = " + length);
        //遍历一维数组
        for (String name : names) {//方法一
            System.out.println(name);
        }
        for (int i = 0; i < names.length; i++) {//方法二
            System.out.println(names[i]);
        }
        //数组元素的默认值
        //byte, short, int , long默认值为0
        //float, double默认值为0.0
        //boolean默认值为false
        //char默认值为 '\u0000'
        //引用数据类型的默认值为null
    }
}
