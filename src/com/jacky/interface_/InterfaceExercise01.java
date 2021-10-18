package com.jacky.interface_;

public class InterfaceExercise01 {
}

interface AA{
    int x = 0;
}
class BB{
    int x =1;
}

class C extends BB implements AA{
    public void pX(){
        System.out.println(AA.x);
        System.out.println(super.x);
    }

    public static void main(String[] args) {
        new C().pX();
    }
}