/**
 * @author DzcGood
 * @date 2021/8/6 - 20:00
 */

/*
* 1、可变个数的形参,参数个数可以是0个或者多个
*   格式： 数据类型 ... 形参名
*   调用形参的方法：调用的时候当成数组即可
*   要求：可变个数的形参只能放在末尾，且最多只能声明一个可变形参
*
* 2、值传递  非常重要！！！！
*   基本数据类型：赋值的是变量保存的数据值
*   引用数据类型：赋值的是变量保存的地址值
*
* 3、一个坑
*   int[] arr = new int[]{1, 2, 3};
*   System.out.println(arr)  //输出结果为地址
*
*   char[] arr1 = new char[]{'a', 'b', 'b'};
*   System.out.println(arr1)  //输出结果为abc
*   原因：自动调用了System.out.println(char[])方法，该方法的功能是遍历数组，类似于c++的char*
* */
public class VarArgsTest {
    //可变个数的形参
    public void show(String ... str){//形参等价于 String[] str
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
/*
    public void show(String[] str){//形参等价于 String ... str

    }
*/

}
