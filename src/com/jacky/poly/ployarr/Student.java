package com.jacky.poly.ployarr;

public class Student extends Person {

    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "\tscore= " + score;
    }

    public void study() {
        System.out.print("学生\t" + getName() + "\t正在学习\n");
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
