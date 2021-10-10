package com.jacky.homework.P355Practice;

public class Student extends Person{

    private int stu_id;

    public Student(String name, char sex, int age, int stu_id) {
        super(name, sex, age);
        this.stu_id = stu_id;
    }

    void study(){
        System.out.println("我承诺会好好学习");
    }

    @Override
    String play() {
        return super.getName()+"爱玩足球";
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                ", stu_id=" + stu_id +
                                '}';
    }
}
