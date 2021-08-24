import sun.security.jca.GetInstance;

/**
 * @author DzcGood
 * @date 2021/8/23 - 17:24
 */

/*
* 使用同步机制实现懒汉式单例模式的线程安全
*
* */
public class Singleton {
}

class Bank{
    private Bank(){};
    private static Bank instance = null;
    public static Bank getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//                instance = new Bank();
//                return instance;
//            }
//            return instance;
//        }
//    }
        //方式二：效率更高
        if(instance == null){
            synchronized (Bank.class) {
                if(instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}
