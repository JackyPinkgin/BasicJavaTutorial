package com.jacky.hashmap_;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2021/10/27
 */
@SuppressWarnings("all")
public class P535MapExercise {
    public static void main(String[] args) {

        HashMap emp = new HashMap();
        emp.put(1000,new Employee("jacky",5000,1000));
        emp.put(2000,new Employee("tom",25000,2000));
        emp.put(3000,new Employee("marry",35000,3000));

        Set set = emp.keySet();
        for (Object key :set) {
            Employee e = (Employee) emp.get(key);
            if(e.getSalary()>18000){
                System.out.println(e);
            }
        }
        System.out.println("-----------");

        Set set1 = emp.entrySet();
        for (Object o :set1) {
            Map.Entry me = (Map.Entry)o;
            Employee e = (Employee)me.getValue();
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }

        }


    }
}

class Employee{
    private String name;
    private int salary;
    private int id;

    public Employee(String name, int salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }
}