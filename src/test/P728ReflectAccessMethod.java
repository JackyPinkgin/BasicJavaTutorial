package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 2021/12/1
 */
public class P728ReflectAccessMethod {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> bossClass = Class.forName("test.Boss");
        Object o = bossClass.newInstance();

//        Method hi = bossClass.getMethod('hi',String.class);
        Method hi = bossClass.getDeclaredMethod("hi", String.class);
        hi.invoke(o, "你好呀");

        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        System.out.println(say.invoke(o, 15, "张三", '男'));

    }
}


class Boss {
    public int age;
    private static String name;

    public Boss() {
    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi" + s);
    }

}