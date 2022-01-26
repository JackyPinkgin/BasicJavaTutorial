package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 2021/12/1
 */
public class P726ReflectCreateInstance {
    public static void main(String[] args) throws Exception {

        Class<?> userClass = Class.forName("test.User");
        Object o = userClass.newInstance();
        System.out.println(o);

        Constructor<?> constructor = userClass.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);//爆破，使用反射可以试用private构造器
        Object haha = constructor.newInstance("haha");
        System.out.println(haha);

        Constructor<?> constructor1 = userClass.getDeclaredConstructor(String.class,int.class);
        Object aNew = constructor1.newInstance("new", 100);
        System.out.println(aNew);

    }
}


class User {
    public String name = "Jacky";
    int age = 10;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private User(String name) {
        this.name = name;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}