package test;

import java.lang.reflect.Field;

/**
 * 2021/12/1
 */
public class P727ReflectAccessProperty {
    public static void main(String[] args) throws Exception {

        Class<?> stuClass = Class.forName("test.Student");

        Object o = stuClass.newInstance();
        System.out.println(o.getClass());

        Field age = stuClass.getField("age");
        age.set(o,88);
        System.out.println(o);
        System.out.println(age.get(o));

        Field name = stuClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o,"Jacky");
        name.set(null,"吉喆");

        System.out.println(o);


    }
}

class Student {
    public int age;
    private static String name;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age + " name=" + name +
                '}';
    }
}