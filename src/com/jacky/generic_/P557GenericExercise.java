package com.jacky.generic_;

import java.util.*;

/**
 * 2021/11/2
 */
public class P557GenericExercise {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jacky",20));
        students.add(new Student("tom",18));
        students.add(new Student("mary",19));

        for (Student student :students) {
            System.out.println(student.name+"--"+student.age);
        }

        System.out.println("======");

        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            Student s = iterator.next();
            System.out.println(s.name + "  " + s.age);
        }
        System.out.println("check to hashmap");


        HashMap<String, Student> hm = new HashMap<>();
        hm.put("first",new Student("first",17));
        hm.put("second",new Student("second",18));
        hm.put("third",new Student("third",19));

        Set<Map.Entry<String, Student>> entries = hm.entrySet();
        for (Map.Entry entry :entries) {
            System.out.println(entry.getKey() + "---" + ((Student)entry.getValue()).name);
        }


    }
}


class Student{
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}