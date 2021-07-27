/**
 * @author DzcGood
 * @date 2021/7/27 - 14:26
 */

/*
* 逻辑运算符 & && | || ! ^
* 作用于boolean类型的变量
* */
public class LogicTest {
    public static void main(String[] args) {
        //区分 & 与 &&
        // &是逻辑与，&&是短路逻辑与
        boolean b1 = true;
        int num1 = 10;
        if(b1 & (num1++ > 0)){
            System.out.println("我现在在北京");
        }else{
            System.out.println("我现在在南京");
        }
        System.out.println("num1 = " + num1);

        boolean b2 = true;
        int num2 = 10;
        if(b2 && (num2++ > 0)){
            System.out.println("我现在在北京");
        }else{
            System.out.println("我现在在南京");
        }
        System.out.println("num2 = " + num2);

        boolean b3 = false;
        int num3 = 10;
        if(b3 & (num3++ > 0)){
            System.out.println("我现在在北京");
        }else{
            System.out.println("我现在在南京");
        }
        System.out.println("num3 = " + num3);

        boolean b4 = false;
        int num4 = 10;
        if(b4 && (num4++ > 0)){
            System.out.println("我现在在北京");
        }else{
            System.out.println("我现在在南京");
        }
        System.out.println("num4 = " + num4);

        // | 与 || 的区别与 & 和 && 的区别类似，此处不再叙述
        int nn = 10;
        int x = 0;
        x += (nn++);
        System.out.println("x = " + x);
    }
}
