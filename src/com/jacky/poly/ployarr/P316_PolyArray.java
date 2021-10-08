package com.jacky.poly.ployarr;

public class P316_PolyArray {
    public static void main(String[] args) {

        Person[] persons = new Person[5];
        persons[0] = new Person("jacky", 20);
        persons[1] = new Student("zhao", 18, 100);
        persons[2] = new Student("qian", 19, 70);
        persons[3] = new Teacher("sun", 30, 20000);
        persons[4] = new Teacher("li", 50, 25000);

        //循环遍历多态数组，调用say方法

        for (int i = 0; i < persons.length; i++) {
            System.out.print(persons[i].say());
            System.out.println();
            if (persons[i] instanceof Student) {
                ((Student) persons[i]).study();
            } else if (persons[i] instanceof Teacher) {
                ((Teacher) persons[i]).teach();
            }
        }

        /*
        * equals和==的对比
        1. ==：既可以判断基本类型，又可以判断引用类型
        2. ==：如果判断基本类型，判断的是值是否相等
        3. ==：如果判断引用类型，判断的是地址是否相等，即判定是不是同一个对象
        4. equals：是object类中的方法，只能判断引用类型
        5. equals：默认判断的是地址是否相等，子类中往往重写该方法，用于判断内容是否相等。比如Integer,String
        *
        * */

        Integer integer = new Integer(5);
        Integer integer1 = new Integer(5);
        System.out.println(integer.equals(integer1));
        System.out.println(integer == integer1);


        String str1 = new String("jacky");
        String str2 = new String("jacky");
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));
    }
}
