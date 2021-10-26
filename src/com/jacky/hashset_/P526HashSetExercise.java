package com.jacky.hashset_;

import java.util.HashSet;

/**
 * 2021/10/26
 */
@SuppressWarnings("all")
public class P526HashSetExercise {
    public static void main(String[] args) {

        HashSet hashSet = new HashSet();
        hashSet.add(new Employee2("Jacky",15));
        hashSet.add(new Employee2("TOM",25));
        hashSet.add(new Employee2("Jacky",15));
        hashSet.add(new Employee2("Jennie",30));
        System.out.println("hashset = "+hashSet);

    }
}


class Employee{
    private String name;
    private int age;

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

    public Employee(String name, int age) {
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
    public boolean equals(Object obj){
        if (obj instanceof Employee) {
            Employee employee =(Employee)obj;
            return this.age == employee.age&&this.name.equals(employee.name);
        }else {
            System.out.println(obj.getClass());
            System.out.println("类型不是employee");
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 100;
    }
}