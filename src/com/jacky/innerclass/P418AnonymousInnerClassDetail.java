package com.jacky.innerclass;

public class P418AnonymousInnerClassDetail {
    public static void main(String[] args) {
        Outer05 outer05 = new Outer05();
        outer05.f1();

//        new Person(){
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//            }
//        }.ok("sheishuode");
    }
}

class Outer05{
    private int n1= 99;
    public void f1() {
        Person person = new Person() {
            int n1 = 88;

            @Override
            public void hi(int i) {
                System.out.println("匿名内部类重写了hi方法  匿名内部类的参数n1= "+n1+"外部类的n1="+Outer05.this.n1);
            }
        };
        person.hi(8000);

        //也可以直接调用
//        new Person() {
//            @Override
//            public void hi(int i) {
//                System.out.println("匿名内部类重写了hi方法  新的哈哈哈 "+i);
//            }
//            @Override
//            public void ok(String str) {
//                super.ok(str);
//                System.out.println("new Person ok() "+str);
//            }
//        }.ok("你好");
    }
}


class Person{
    public void hi(int i ){
        System.out.println("Person hi()");
    }
    public void ok(String str){
        System.out.println("Person ok() "+ str);
    }
}

//抽象类//接口