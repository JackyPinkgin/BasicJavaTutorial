package personaltrain;

public class P221Practice_this {
    public static void main(String[] args) {
        PersonNew p1 = new PersonNew("mary",20);
        PersonNew p2 = new PersonNew("mary",20);
        System.out.println(p1.CompareTo(p2));
    }
}


class PersonNew {
    String name;
    int age;

    PersonNew(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public boolean CompareTo(PersonNew p) {
        return this.name.equals(p.name) && this.age == p.age;
    }
}