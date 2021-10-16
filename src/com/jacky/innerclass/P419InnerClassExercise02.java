package com.jacky.innerclass;

public class P419InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
        cellPhone.check(new BB(){
            @Override
            public void say() {
                System.out.println("什么都不想说");
            }
        });
        cellPhone.check(new BB());
    }
}


interface Bell{
    void ring();
}

class CellPhone{
    public void alarmClock(Bell bell){
        bell.ring();
    }
    public void check(BB bb){
        bb.say();
    }

}


class BB{
    public void say(){
        System.out.println("说点什么好呢？");
    }
}