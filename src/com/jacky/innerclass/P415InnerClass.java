package com.jacky.innerclass;

public class P415InnerClass {
    public static void main(String[] args) {

        Outer waibu = new Outer();
        waibu.m1();


    }
}


class Outer {
    private int n1 = 100;

    private void m2() {
        System.out.println("Outer has m2()");
    }

    public void m1() {

        String name = "xxx";
        class Inner {
            private int n1 = 800;

            public void f1(int i) {
                System.out.println("内部类n1=" + n1 + "  外部类n1= " + Outer.this.n1 + "  extra=" + i);
                m2();
            }
        }
        new Inner().f1(50);

    }

    public void f1() {
        int c = 100;
        System.out.println(c);
    }

}