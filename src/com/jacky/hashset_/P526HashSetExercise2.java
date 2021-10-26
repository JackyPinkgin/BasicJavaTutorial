package com.jacky.hashset_;

import java.util.HashSet;
import java.util.Objects;

/**
 * 2021/10/26
 */
@SuppressWarnings("all")
public class P526HashSetExercise2 {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee2("Jacky",15));
        hashSet.add(new Employee2("TOM",25));
        hashSet.add(new Employee2("Jacky",15));
        hashSet.add(new Employee2("Jennie",30));
        System.out.println("hashset = "+hashSet);

    }
}


class Employee2 {
    private String name;
    private int age;

    public Employee2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee2 employee2 = (Employee2) o;
        return age == employee2.age && Objects.equals(name, employee2.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}