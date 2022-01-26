package test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2021/12/1
 */
public class P729Homework01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {

//        Class<?> aClass = Class.forName("test.PrivateTest");
        Class<PrivateTest> aClass = PrivateTest.class;
        Object o = aClass.newInstance();

        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"jacky");

//        System.out.println(o);

        Method getName = aClass.getMethod("getName");
        Object invoke = getName.invoke(o);
        System.out.println(invoke);

    }
}


class PrivateTest {
    private String name = "helloKitty";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PrivateTest{" +
                "name='" + name + '\'' +
                '}';
    }
}