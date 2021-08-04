/**
 * @author DzcGood
 * @date 2021/7/31 - 15:47
 */
public class ArrayTest {
    public void testOne(){        //数组遍历求和
        int[][] arr = new int[][]{{3, 5, 8}, {12, 9}, {7, 0, 6, 4}};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("sum = " + sum);
    }

    public void testTwo(){        //打印杨辉三角前十行
        int[][] arr = new int[10][];
        //第n行有n个元素，每行第一个和最后一个元素都是1
        for (int i = 0; i < 10; i++) {
            arr[i] = new int[i + 1];
            arr[i][0] = arr[i][i] = 1;
        }
        //arr[i][j] = arr[i - 1][j] + arr[i- 1][j - 1];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < arr[i].length - 1; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i- 1][j - 1];
            }
        }
        //输出
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void testThree(){
        int[] arr1 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] arr2;
        arr2 = arr1;//则arr1和arr2指向同一数组对象（浅复制）
        //数组的复制
        arr2 = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            arr2[i] =arr1[i];
        }//arr2和arr1指向堆种两个数组变量，但二者元素值相同（深复制）
    }

    public void testFour(){     //数组的反转
        String[] arr = {"11", "22","33", "44", "55"};
        for (int i = 0; i < arr.length / 2; i++) {
            String temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int testFive(int desc){//二分查找，要求数组是有序的
        int[] arr = {1, 3, 5, 6, 7, 9, 11};
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        while(left <= right){
            if(arr[mid] == desc){
                return mid;
            }
            if(desc < arr[mid]){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
            mid = (left + right) / 2;
        }
        return -1;//未找到
    }

    public static void main(String[] args) {
        ArrayTest test = new ArrayTest();
        test.testOne();
        test.testTwo();
        test.testThree();
        test.testFour();
        System.out.println(test.testFive(13));
    }
}
