package com.jacky.innerclass;

/**
 * 2022/2/14
 */
public class Practive0214 {
    public static void main(String[] args) {


        CellPhone1 cellPhone1 = new CellPhone1();
        cellPhone1.alarmclock(new Bell1() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone1.alarmclock(new Bell1() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });

    }
}

interface Bell1{
    void ring();
}


class CellPhone1{
    public void alarmclock(Bell1 bell){
        bell.ring();
    }
}