/**
 * @author DzcGood
 * @date 2021/10/18 - 19:19
 */
/*
* 静态代理示例：被代理类和代理类在编译期就已经确定下来了
* */
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象
        NikeClothFactory nike = new NikeClothFactory();
        //创建代理类的对象
        ProxyClothFactory proxy = new ProxyClothFactory(nike);
        //调用代理类的方法
        proxy.produceCloth();
    }
}

interface ClothFactory{
    void produceCloth();
}

//代理类
class ProxyClothFactory implements ClothFactory{
    private ClothFactory factory;//用被代理类的对象进行实例化

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }
    @Override
    public void produceCloth(){
        System.out.println("代理工厂准备一些工作");
        factory.produceCloth();
        System.out.println("代理工厂做后续工作");
    }
}

class NikeClothFactory implements ClothFactory{
    @Override
    public void produceCloth(){
        System.out.println("Nike工厂生产一批运动服");
    }
}