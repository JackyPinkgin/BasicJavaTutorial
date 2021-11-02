package com.jacky.generic_;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * 2021/11/2
 */
public class P560GenericExercise {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("jacky", 2000, new MyDate(1993, 10, 5)));
        employees.add(new Employee("tom", 3500, new MyDate(1992, 1, 7)));
        employees.add(new Employee("amary", 7000, new MyDate(1998, 6, 6)));
        employees.add(new Employee("amary", 7000, new MyDate(1998, 9, 6)));
        employees.add(new Employee("amary", 7000, new MyDate(1994, 6, 6)));
        employees.add(new Employee("liming", 7000, new MyDate(1995, 5, 1)));

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("排序后");

        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int result = o1.getName().compareTo(o2.getName());
                if (result != 0) {
                    return result;
                } else {
                    return o2.getBirthday().compareTo(o1.getBirthday());
                }
            }
        });

        for (Employee e : employees) {
            System.out.println(e);
        }

    }

}


class Employee {
    private String name;
    private double sal;
    private MyDate birthday;

    public Employee(String name, double sal, MyDate birthday) {
        this.name = name;
        this.sal = sal;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sal=" + sal +
                ", birthday=" + birthday +
                '}';
    }
}

class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;


    public MyDate(int year, int month, int day) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public int compareTo(MyDate o) {
        if (year == o.getYear() && month == o.getMonth() && day == o.getDay()) {
            return 0;
        } else if (year != o.getYear()) {
            return year - o.getYear();
        } else if (month != o.getMonth()) {
            return month - o.getMonth();
        } else if (day != o.getDay()) {
            return day - o.getDay();
        } else return 0;
    }
}