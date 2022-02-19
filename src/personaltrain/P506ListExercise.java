package personaltrain;

import java.util.ArrayList;
import java.util.List;

/**
 * 2021/10/25
 */
@SuppressWarnings("all")
public class P506ListExercise {
    public static void main(String[] args) {

        List list = new ArrayList();
        for (int i = 0; i <= 10; i++) {
            list.add("Hello"+i);
        }

        list.add(1,"韩顺平教育");
        System.out.println("------------");
        System.out.println(list.get(0));
        System.out.println("------------");
        list.remove(6);
        list.set(7,"Jacky7");

        for (Object o : list) {
            System.out.println(o);
        }


    }
}
