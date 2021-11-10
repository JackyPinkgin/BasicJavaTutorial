package com.jacky.iostream;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

/**
 * 2021/11/10
 */
public class P644Homework03 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\JavaLearn\\src\\com\\jacky\\iostream\\dog.properties";
        Properties properties = new Properties();
        properties.load(new FileReader(path));

        Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("age")), properties.getProperty("color"));
        System.out.println(dog);

        String serFilePath = "D:\\dog.dat";
        //序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(serFilePath));
        objectOutputStream.writeObject(dog);
        objectOutputStream.close();

    }
    @Test
    public void m1() throws IOException, ClassNotFoundException {
        String serFilePath = "D:\\dog.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(serFilePath));
        Dog dog = (Dog)objectInputStream.readObject();
        System.out.println("-----dog info-----");
        System.out.println(dog);
        objectInputStream.close();


    }
}

class Dog implements Serializable {
    public String name;
    public int age;
    public String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
