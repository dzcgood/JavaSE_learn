/**
 * @author DzcGood
 * @date 2021/7/27 - 20:27
 */
/*
* 1、分支结构 if - else
* */
public class IfTest {
    public static void main(String[] args) {
        // if - else
        //第一种
        int heartBeats = 178;
        if(heartBeats < 60 || heartBeats > 100){
            System.out.println("需要做进一步检查");
        }
        System.out.println("检查结束");
        //第二种 二选一结构
        int age = 23;
        if(age < 18){
            System.out.println("你还可以看动画片");
        }else{
            System.out.println("你可以看成人电影了");
        }
        //第三种 多选一
        if(age < 0){
            System.out.println("您输入的数据非法");
        }else if(age < 18){
            System.out.println("青少年时期");
        }else if(age < 35){
            System.out.println("青壮年时期");
        }else if(age < 60){
            System.out.println("中年时期");
        }else{
            System.out.println("老年时期");
        }

    }
}
