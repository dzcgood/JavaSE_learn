import java.util.Arrays;

/**
 * @author DzcGood
 * @date 2021/8/1 - 0:20
 */

/*
*Arrays工具类的使用
* */
public class ClassArrays {
    public static void main(String[] args) {
        //Arrays.equals 判断两个数组是否相等
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {1, 3, 2, 4};
        System.out.println(Arrays.equals(arr1, arr2));//false
        //Arrays.toString 输出数组信息
        System.out.println(Arrays.toString(arr1));
        //Arrays.fill(arr, value) 将指定值填入数组(把原来数组的值全部替换为另外一个值)
        Arrays.fill(arr1, 10);
        System.out.println(Arrays.toString(arr1));
        //Arrays.sort(arr) 排序,从小到大的顺序
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
        //Arrays.binarySearch(arr, value)，如果找不到，就会返回一个负数
        int index = Arrays.binarySearch(arr2, 3);
        System.out.println(index);

    }
}
