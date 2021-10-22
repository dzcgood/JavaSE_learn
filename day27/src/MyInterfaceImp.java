/**
 * 此类实现接口MyInterface
 * @author DzcGood
 * @date 2021/10/22 - 17:22
 */
public class MyInterfaceImp implements MyInterface{
    @Override
    public void methodAbstract() {

    }

    @Override
    public void methodDefault() {
        System.out.println("实现类重写了接口的缺省方法");
    }

    public static void main(String[] args) {
        //接口中的静态方法只能由接口自己调用
        MyInterface.methodStatic();
        /*
        * 实现类不能调用接口的静态方法
        * MyInterfaceImp.methodStatic();
        * */

        MyInterfaceImp myInterfaceImp = new MyInterfaceImp();
        //接口的私有方法不能在接口外使用
        myInterfaceImp.methodDefault();
    }
}
