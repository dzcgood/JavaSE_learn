/**
 * @author DzcGood
 * @date 2021/7/30 - 20:49
 */

/*
* 多维数组
* 1、从数组的底层机制来看，没有多维数组。只不过数组的元素又是数组罢了
* 2、二维数组默认值
*   例：
*   int[][] arr = new int[3][2];
*   arr[0], arr[1], arr[2]是地址值
*   arr[0][0], arr[0][1]等的默认值是0
* */
public class MultiArrayTest {
    public static void main(String[] args) {
        //二维数组的声明和初始化
        int[] arr = new int[]{1, 2, 3};
        int[][]arr1 = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};//静态初始化
        String[][]arr2 = new String[3][2];//动态初始化1
        String[][]arr3 = new String[3][];//动态初始化2
        //这时候不能直接去访问arr3的元素，会报错，空指针异常，应该先初始化
        //arr3[1][0] = "Hello"; 空指针异常
        arr3[1] = new String[2];//初始化
        arr3[1][0] = "Hello";//这样才行
        //int[][]arr1 = new int[3][3]{{1, 2, 3}, {4, 5, 9}, {6, 7, 8}};   这样的声明是错误的，静态和动态不能结合使用
        //几种比较奇怪，但又是正确的声明方法
        int[]arr4[] = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};//奇葩方法1
        int arr5[][] = new int[][]{{1, 2, 3}, {4, 5}, {6, 7, 8}};//c, c++声明方法
        int[][]arr6 = {{1, 2, 3}, {4, 5}, {6, 7, 8}};//和c, c++一样, 类型推断
        int []arr7 = {1, 2, 3, 4};//和c, c++一样，类型推断
        /*
        int[]arr8;
        arr8 = {1, 2, 3};     这样是不能类型推断的，是错误的
        */
        //使用二维数组指定位置的元素
        System.out.println("arr1[2][1] = " + arr1[2][1]);//输出
        arr1[2][1] = 3;//赋值
        //获取数组长度
        int length = arr1.length;//是3
        System.out.println("length = " + length);
        int length2 = arr1[1].length;//是2
        System.out.println("length2 = " + length2);
        //遍历数组
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.print(arr1[i][j] + " ");
            }
            System.out.println();
        }


    }
}
