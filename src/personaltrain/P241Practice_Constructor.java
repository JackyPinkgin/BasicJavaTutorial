package personaltrain;

public class P241Practice_Constructor {
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person("wangjun", 11);
        System.out.println(p2.hashCode());
        System.out.println(p1.name + " " + p1.age);
        System.out.println(p2.name + " " + p2.age);
        p2.info();
    }
}

class Person {
    String name = "Jacky";
    int age = 55;

    Person() {
        this("hello",999);
//        age = 100;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println(this.name + " " + this.age + " " + this.hashCode());
    }



}