package com.jacky.encap;


public class P283_Encap01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("jackyyyyy");
        person.setAge(5000);
        person.setSalary(3000);
        System.out.println(person.getInfo());
        System.out.println(person.getSalary());

        Person wangzhaa = new Person("wangzhaa", 80, 300);
        System.out.println(wangzhaa.getInfo());
    }
}

class Person {

    public String name;
    private int age;
    private double salary;

    //无参构造器
    public Person() {
    }

    //有三个属性的构造器
    public Person(String name, int age, double salary) {
//        this.name = name;
//        this.age = age;
//        this.salary = salary;
        //可以将set方法写在构造器中
        this.setName(name);
        this.setAge(age);
        this.setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入对数据的校验
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("name length should be between 2-6");
            this.name = "佚名";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("age should be 1-120");
            this.age = 18;
        }
    }

    public double getSalary() {
        //增加对当前对象的权限判断
        return salary;
    }

    public void setSalary(double salary) {
        System.out.println("salary is "+salary);
        this.salary = salary;
    }

    public String getInfo() {
        return name + " " + age + " " + salary + " .";
    }


}
