package com.jacky.poly.polyparameter;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

public class P318_Polyparameter {
    public static void main(String[] args) {

        Worker tom = new Worker("tom", 2500);
        Manager milan = new Manager("milan", 5000, 200000);
        P318_Polyparameter pp = new P318_Polyparameter();
        pp.showEmpAnnual(tom);
        pp.showEmpAnnual(milan);

        pp.testWork(tom);
        pp.testWork(milan);

    }

    public void showEmpAnnual(Employee e){
        System.out.println(e.getAnnual());
    }

    public void testWork(Employee e){
        if (e instanceof Worker) {
            ((Worker)e).work();
        }else if (e instanceof Manager) {
            ((Manager)e).manage();
        }
    }


}
