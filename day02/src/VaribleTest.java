/**
 * @author DzcGood
 * @date 2021/7/26 - 19:52
 */
public class VaribleTest {
    public static void main(String[] args) {
        byte b1 = 2;
        short y =12;
        int i1 = 12;
        //高等级向低等级转换需要显式强制类型转换，可能会损失精度
        byte b2 = (byte) (b1 + i1);
        System.out.println("b2 = " + b2);
        //低等级向高等级转换是自动的隐式转换
        int b3 = b1 + i1;
        System.out.println("b3 = " + b3);
        //从低到高的顺序为
        //byte, short, char -> int -> long -> float -> double
        //byte, short, char 之间的运算结果为int
        float c = 12.3f;
        long d = 123L;
        double e = c + d;
        System.out.println("e = " + e);
        //有char参与的运算结果至少为int型
        char a = 'a';
        short x = 12;
        //short y = a + x;  (×)
        //声明long型变量时，必须在末尾加上l或L
        long longNumber = 123l;
        //否则，默认为int型，然后发生隐式类型转换，这种转换有时候会出问题
        //long x = 12443113464647626;
        //右边的数超过了int所能表示的范围，会报错
        long longNumber2 = 12345478736246378L;//这样才是对的
        //整型常量，默认为int，如 123 是int类型
        //小数常量，默认为double，如 1.23 是double类型
    }
}
