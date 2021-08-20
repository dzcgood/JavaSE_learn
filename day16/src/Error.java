/**
 * @author DzcGood
 * @date 2021/8/18 - 20:27
 */

/*
* 一、Java异常体系结构
* 1、java.lang.Throwable
*       | ------ java.lang.Error
*       | ------ java.lang.Exception
*           | ------ 编译时异常（checked）
*               | ------ IOException
*                   | ------ FileNotFoundException
*               | ------ ClassNotFoundException
*           | ------ 运行时异常（unchecked）
*               | ------ NullPointerException
*               | ------ ArrayIndexOutOfBoundException
*               | ------ ClassCastException
*               | ------ NumberFormatException
*
* 二、Java在执行过程中发生的异常事件一般分为两种，Error和Exception
* 1、Error：Java虚拟机无法解决的严重问题，如JVM系统内部错误，内部资源耗尽等，例如StackOverflowError
*           一般不编写针对性代码解决
* 2、Exception：由编写错误或其他偶然的外在因素导致的一般性问题，可以编写针对性代码解决
*           如：空指针异常，网络连接中断、数组角标越界
*   2.1 分类：
*       > 编译时异常（受检异常）：执行javac.exe时出现的异常，不会生成class文件
*       > 运行时异常（不受检异常）：执行java.exe时出现的异常，会生成class文件
* 三、Java异常处理的两种方式
* 1、tyr - catch - finally，IDEA中快捷键，CTRL + ALT + T
*   1.1 格式
*       try{
*               //可能出现异常的代码
*       }catch(异常类型1 变量名1){
*               //处理异常的方式1
*       }catch(异常类型2 变量名2){
*               //处理异常的方式2
*               ......
*       }catch(异常类型n 变量名n){
*               //处理异常的方式n
*       }finally{
*               //一定会执行的代码
*       }
*   1.2说明
*       > try-catch-finally结构是可嵌套的，finally是可选的
*       > 一旦try中的异常对象匹配到某个catch，就进入catch进行异常处理，一旦完成，就不会执行下面的catch，try-catch-finally
*         结构后面的语句正常执行。
*       > try中定义的结构，在try外面就不能使用了（变量生命周期）
*       > catch中的类型如果没有子父类关系，则顺序可以任意；若有子父类关系，则子类必须写在上面
*       > finally语句一定会执行,即使try和catch中有return，或者异常没被catch捕获
*           * try和catch中有return：先执行finally在执行return
*           *异常没被catch捕获：先执行finally后中断程序
*           * 如果try-catch-finally中都出现了return，则最后被执行的是finally中的return，其他地方的return不会执行
*   1.3 常用处理方式
*       > String e.getMessage()
*       > void e.printStackTrace()
*   1.4 什么时候需要把代码写进finally？
*       > 像数据库连接，输入输出流，网络编程socket等资源，JVM是不会自动回收的，我们需要自己手动进行释放，此时的资源释放
*         就需要放在finally中
*   1.5 在开发中，对于运行时异常，一般不使用try-catch-finally处理它。只处理编译时异常
*
* 2、throws + 异常类型
*   2.1 这个结构写在方法的声明处，指明方法在执行时可能抛出的异常类型，一旦方法在执行时发生异常，就会生成对应的异常对象
*       生成的对象满足throws声明的类型时，就会被抛出给上层的调用者。异常代码后面的代码不会被执行
*   2.2 体会
*       > try-catch-finally:真正的将异常处理掉
*       > throws：只是将异常抛给调用者，并没有将异常处理掉
* 3、如何选择try-catch-finally还是throws
*   3.1 如果父类被重写的方法中没有throws，则子类也不能throws，意味着，如果子类有异常抛出，则必须选择try-catch-finally
*   3.2 执行的方法中先后调用了其他的方法，如果这几个方法是递进关系处理的，建议用throws，然后让方法的调用者try-catch-finally
* 四、异常的处理：抓抛模型
* 1、过程一：抛
*   1.1 程序执行的过程中出现异常，就会在异常代码出生成一个对应异常的对象，并将此对象抛出，
*       一旦抛出对象，其后的代码就不再执行
*   1.2 关于异常的产生
*       > 系统自动生成的异常对象
*       > 手动地生成异常对象，并抛出（throw）
* 2、过程二：抓，即异常处理的两种方式
* */
public class Error {
    public static void main(String[] args) {
        //1、java.lang.StackOverflowError，栈溢出
//        main(args);//无限递归
        //2、OutOfMemoryError堆溢出（简称OOM）
//        Integer[] in = new Integer[1024 * 1024 * 1024];
    }

}
