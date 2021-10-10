package com.jacky.homework.P355Practice;

public class P355Practice {
    public static void main(String[] args) {
        Student s = new Student("Jacky", 'm', 15, 80230531);

        System.out.println(s.play());
        s.study();
        System.out.println(s);

        Teacher t = new Teacher("Linda", 'f', 30, 6);
        System.out.println(t.play());
        t.teach();

        Person[] people = new Person[4];
        people[0]=new Student("Jacky", 'm', 15, 80230531);
        people[1]=new Student("Tom", 'm', 17, 80230566);
        people[2]=new Teacher("Linda", 'f', 30, 6);
        people[3]=new Teacher("Mike", 'm', 24, 10);

        Person tmp;

        for (int i = 0; i < people.length-1; i++) {
            for (int j = 0; j < people.length-1-i; j++) {
                if (people[j].getAge() < people[j+1].getAge()) {
                    tmp = people[j];
                    people[j]=people[j+1];
                    people[j+1]=tmp;
                }
            }
        }

        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
        }

        P355Practice p1 = new P355Practice();
        p1.out(s);
        p1.out(t);
    }

public void out(Person p){
    if (p instanceof Student) {
        ((Student) p).study();
    }else if (p instanceof Teacher) {
        ((Teacher) p).teach();
    }
}
}
