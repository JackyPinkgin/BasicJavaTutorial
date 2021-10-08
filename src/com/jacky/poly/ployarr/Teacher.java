package com.jacky.poly.ployarr;

public class Teacher extends Person {
    private double salary;

    public Teacher(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    @Override
    public String say() {
        return super.say() + "\tsalary= " + salary;
    }

    public void teach() {
        System.out.print("老师\t" + getName() + "\t在上课\n");
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
