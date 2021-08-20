import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author DzcGood
 * @date 2021/8/19 - 0:00
 */
/*
* 方法重写关于Exception的规定
* 1、重写的方法抛出的异常必须不大于父类方法抛出的异常
*    原因见下面Override类的display方法中的注释
* 2、父类方法中如果没有抛出异常，子类重写的方法也不能抛
* 3、父类方法中如果抛出异常，子类重写的方法可以不抛出异常
*       2、3点的原因还是在于当用到多态的时候，能否捕捉到子类重写方法抛出的异常
 */
public class Override {

    static void display(SuperClass s){
        try {
            s.method();
        } catch (IOException e) {//注意，问题出在此处
                                    //因为这里用到了多态，所以在catch的时候，只能写catch到IOException
                                    //一旦子类抛出的异常大于父类的IOException，比如说Exception，而且在执行的时候真的
                                    //抛出了Exception，显然这里的catch语句是捕捉不到异常的，所以说子类抛出的异常不能
                                    //大于父类抛出的异常
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        display(new SubClass());//
    }
}

class SuperClass{
    public void method()throws IOException{
        ////
    }
}

class SubClass extends SuperClass{
    @java.lang.Override
//    public void method()throws Exception{//重写的方法抛出的异常必须不大于父类方法抛出的异常
        /////
//    }
    public void method()throws FileNotFoundException {
    }
}
