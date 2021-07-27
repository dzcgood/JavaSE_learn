/**
 * @author DzcGood
 * @date 2021/7/28 - 0:02
 */

/*
* switch - case 语句
* 格式：
* switch(表达式){
*   case 情况1:
*       执行语句;
*       [break;]
*   ……
*   case 情况n:
*      执行语句;
*      [break;]
*   default:
*       执行语句;
* }
*
* 表达式只能是如下六种类型之一：byte, short, int, char, 枚举类型(JDK5.0新增), String(JDK7.0新增)
* case之后，只能放常量，不能是范围
* default是可选的，而且放在哪效果都是一样的
*
* */
public class SwitchTest {
    public static void main(String[] args) {
        int num = 2;
        switch(num){
            case 1:
                System.out.println("one");
                break;
            case 2:
                System.out.println("two");
                //如果没有break，找到第一个符合条件的case之后，后面的case会继续执行，而不必判断是否符合条件
                //直到遇见break或者default
            case 3:
                System.out.println("three");
            default:
                System.out.println("--");
        }
        //例题，学生成绩 > 60的输出合格，不然输出不合格

        int score = 70;
        switch (score / 60){
            case 1:
                System.out.println("合格");
                break;
            case 0:
                System.out.println("不合格");
                break;
            default:
                System.out.println("非法数据");
        }

        //或者
        switch (score / 10){
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("不合格");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                System.out.println("合格");
                break;
        }
    }
}
