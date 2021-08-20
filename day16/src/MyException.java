/**
 * @author DzcGood
 * @date 2021/8/19 - 22:43
 */

/*
* 用户自定义异常类
* 1、如何自定义异常类
*   1.1
*       > 声明一个类去继承现有的异常体系
*       > 一般选择继承RuntimeException（编译时不必检查）或者Exception（编译时必须检查）
*   1.2
*       > 提供serialVersionUID
*   1.3
*       > 提供重载的构造器，一般提供两个（空参的和以message为形参的）
* */
public class MyException extends Exception{
    static final long serialVersionUID = -3445151398138953018L;

    public MyException() {
    }

    public MyException(String msg){
        super(msg);
    }
}
