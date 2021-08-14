import org.junit.Test;

/**
 * @author DzcGood
 * @date 2021/8/14 - 20:12
 */

/*
 * Java中的JUnit单元测试
 * 步骤：
 *       1、创建Java测试类，进行测试，要求类是公共的，提供公共、无参的构造器
 *       2、在类中声明单元测试方法，要求方法的权限是public，返回类型为void，没有形参，方法上面加上注解@Test，
 *          导入org.junit.Test
 *       3、声明好方法后，就可以在方法体内测试相关的代码
 *       4、选中类名或方法名，右键run即可。若选中类名，则所有测序方法都会执行，若选择方法名，则只测试被选中的方法
 *在测试类中，不需要创建类的对象，就可以访问类的属性
 * */
public class JUnit {
    int num = 10;
    @Test
    public void testEquals(){
        String s1 = "MM";
        String s2 = "MM";
        System.out.println(s1.equals(s2));
        int[] arr = new int[]{1, 3, 5};
        //System.out.println(arr[3]);
        System.out.println(num);//在这里直接就可以访问到，不需要创建类的对象
    }

    @Test
    public void ObjectTest(){
        System.out.println("ggggg");
    }
}
