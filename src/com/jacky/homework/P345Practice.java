package com.jacky.homework;

public class P345Practice {

    public static void main(String[] args) {
        Professor professor = new Professor("Jacky", 55, "教授", 50000);
        professor.introduce();
    }

}

class Teacher {
    private String name;
    private int age;
    private String position;
    private double salary;

    public Teacher(String name, int age, String position, double salary) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
    }

    void introduce() {
        String info = "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
        System.out.println(info);
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

class Professor extends Teacher {

    public Professor(String name, int age, String position, double salary) {
        super(name, age, position, salary);
    }

    void introduce() {
        double salary_level = 1.3;
        String info = "Teacher{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", position='" + super.getPosition() + '\'' +
                ", salary=" + super.getSalary() +
                ", salarylevel=" + salary_level +
                '}';
        System.out.println(info);
    }
}
