package personaltrain;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2021/10/29
 */
@SuppressWarnings("all")
public class P549CollectionPractice02 {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        Car car = new Car("宝马", 400000);
        Car car2 = new Car("宾利", 50000000);
        arrayList.add(car);
        arrayList.add(car2);
        System.out.println(arrayList);

        arrayList.remove(car);
        System.out.println(arrayList.contains(car));

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

//        arrayList.clear();
        System.out.println(arrayList);
        arrayList.addAll(arrayList);
        System.out.println(arrayList);

//        arrayList.removeAll(arrayList);
//        System.out.println(arrayList);

        for (Object o :arrayList) {

            System.out.println(o);
        }

        System.out.println("------");

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}


class Car{
    private String name;
    private double price;

    public Car(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}