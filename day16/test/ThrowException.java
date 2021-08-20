/**
 * @author DzcGood
 * @date 2021/8/19 - 0:26
 */

/*
* 手动抛出异常的测试
* */
public class ThrowException {
    public static void main(String[] args) {
        try {
            Student student = new Student();
            student.regist(1001);
            System.out.println(student);
            student.regist(-1001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Student{
    private int id;

    public void regist(int id)throws Exception{
        if(id > 0){
            this.id = id;
        }else{
//            System.out.println("输入的id非法");
            //手动抛出异常对象
//            throw new RuntimeException("输入的id非法");//也可以这样操作
            //或者
            throw new Exception("输入的id非法");//因为Exception包括编译时异常，所以需要在方法体加上throws
                                                //抛出RuntimeException时不必throws，因为是非受检异常
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @java.lang.Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}
