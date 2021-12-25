package personaltrain;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class P729Practice_Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> privateTestClass = Class.forName("personaltrain.PrivateTest");
        Object o = privateTestClass.newInstance();
        Field name = privateTestClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(o));
        System.out.println("+++++++++++++");

        name.set(o,"jacky");

        Method method = privateTestClass.getMethod("getName");
        System.out.println(method.invoke(o));


    }
}

class PrivateTest {
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
