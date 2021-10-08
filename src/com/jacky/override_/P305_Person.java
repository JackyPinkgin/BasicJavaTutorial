package com.jacky.override_;

public class P305_Person {
    private String name;
    private int age;

    public P305_Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String say(){
        return "My name is "+name+" , my age is "+age;
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
}
