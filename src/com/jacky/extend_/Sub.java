package com.jacky.extend_;

public class Sub extends Base{



    public Sub() {
        System.out.println("sub is called");
    }
    public Sub(int age){
        super("hello");
        System.out.println("Sub(int age) "+age+" is called");
    }

}
