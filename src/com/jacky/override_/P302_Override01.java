package com.jacky.override_;

public class P302_Override01 {
    public static void main(String[] args) {
        P305_Student jacky = new P305_Student("jacky", 80,80230531,90.5);
        System.out.println(jacky.say());

        P305_Person tom = new P305_Person("tom", 100);
        System.out.println(tom.say());
    }
}
