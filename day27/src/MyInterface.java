/**
 * @author DzcGood
 * @date 2021/10/22 - 17:18
 */
public interface MyInterface {
    //如下的三个方法的权限修饰符都是public

    /**
     * 接口中的普通方法
     * */
    void methodAbstract();

    /**
     * 接口中的静态方法
     * */
    static void methodStatic(){
        System.out.println("我是接口中的静态方法");
    }

    /**
     * 接口中的default方法
     * */
    default void methodDefault(){
        System.out.println("我是接口中的默认方法");
        //接口内部可以调用私有接口的方法
        this.methodPrivate();
    }


    /**
     * 接口中的私有方法
     * */
    private void methodPrivate(){
        System.out.println("我是接口中的私有方法");
    }

}
