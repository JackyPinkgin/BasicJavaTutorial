package com.jacky.object_;

import javax.swing.*;

//重写equals方法

public class P322_EqualsExercise {
    public static void main(String[] args) {
        Person person1 = new Person("jacky", 15, 'm');
        Person person2 = new Person("jacky", 15, 'm');

        //没有重新equals方法
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person1));
    }
}

class Person {

    private String name;
    private int age;
    private char gender;

    //重新object的equals方法
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Person) {
            Person p = (Person) obj;
            return this.age == p.age && this.name.equals(p.name) && this.gender == p.gender;
        }
        return false;
    }

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }


}
