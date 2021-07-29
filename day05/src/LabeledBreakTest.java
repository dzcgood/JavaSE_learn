/**
 * @author DzcGood
 * @date 2021/7/28 - 16:47
 */

/*
* 带标签的break和continue语句使用，可以用来跳出或结束外层循环
* 标签的使用格式为   标签名 :
* 例如   label1:
*
*/
public class LabeledBreakTest {
    public static void main(String[] args) {
        label:for (int i = 1; i <= 4; i++) {
                for (int j = 1; j <= 10; j++) {
                    if(j % 4 == 0){
                        //break label;      这样就能跳出外层循环了
                        //continue label;   这样就能结束外层此次循环了
                    }
                    System.out.println(j);
                }
        }
    }
}
