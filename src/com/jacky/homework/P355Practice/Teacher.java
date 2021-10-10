package com.jacky.homework.P355Practice;

public class Teacher extends Person{
    private int work_age;

    public Teacher(String name, char sex, int age, int work_age) {
        super(name, sex, age);
        this.work_age = work_age;
    }

    void teach(){
        System.out.println("我承诺会认真教学");
    }

    @Override
    String play() {
        return super.getName()+"爱玩象棋";
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + getName() + '\'' +
                ", sex=" + getSex() +
                ", age=" + getAge() +
                ", work_age=" + work_age +
                '}';
    }
}
