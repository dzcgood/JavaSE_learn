package src1;

import java.io.Serializable;

/**
 * @author DzcGood
 * @date 2021/10/16 - 19:30
 */
public class Creature<T> implements Serializable {
    private char gender;
    public  double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }
}
