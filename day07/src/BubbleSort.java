/**
 * @author DzcGood
 * @date 2021/7/31 - 22:35
 */

/*
* 冒泡排序
* */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {43, 32, 76, -98, 0, 64, 33, -21, 32, 99};
        for (int i = 0; i < arr.length - 1; i++) {//共执行arr.length - 1轮
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
