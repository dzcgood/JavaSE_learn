import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/17 - 17:00
 */

/*
* 接口的应用：代理模式（屏蔽了对真实对象的直接访问）
*1、举例说明：类似于明星和经纪人，要联系明星，则通过经纪人来联系。
* */
public class Proxy {
    //代理模式
    @Test
    public  void test1(){
        Server network = new Server();
        new ProxyServer(network).browse();//执行代理操作
    }

    //补充说明
    interface A{
        int x = 1;
    }

    class B{
        int x = 0;
    }

    class C extends B implements A{
        public void method(){
//            System.out.println(x);//会报错，因为没有指定是从A获得的X还是从B继承的X
            System.out.println(A.x);//显示声明是A的x
            System.out.println(super.x);//显示声明是B的x
        }
    }
    @Test
    public void test2(){
        new C().method();
    }

    @Test
    public void test3(){


    }
}

interface Network{
    public abstract void browse();
}

class Server implements Network{
    @Override
    public void browse(){
        System.out.println("服务器访问网络");
    }
}

class ProxyServer implements Network{
    private Network network;

    public ProxyServer(Network network) {
        this.network = network;
    }

    @Override
    public void browse(){
        check();
        network.browse();//执行代理操作
    }

    public void check(){
        System.out.println("联网之前的检查工作");
    }
}