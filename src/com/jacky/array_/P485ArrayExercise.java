package com.jacky.array_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2021/10/21
 */
public class P485ArrayExercise {
    public static void main(String[] args) {

        Book[] books = new Book[5];
        books[0] = new Book("java learn",50);
        books[1] = new Book("python learn",75);
        books[2] = new Book("C++ learn",30);
        books[3] = new Book("Go learn",100);
        books[4] = new Book("C# learn",-10);

        //使用Arrays类的sort方法，底层会调用匿名内部类的compare方法
//        Arrays.sort(books, new Comparator<Book>() {
//            @Override
//            public int compare(Book o1, Book o2) {
//                return 0;
//            }
//        });

        SortCustome(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int o11 = (Integer)o1;
                int o22 = (Integer)o2;
//                return o11-o22;
                return o22-o11;
            }
        });

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].toString());
        }

    }

    public static void SortCustome(Book[] arr, Comparator c){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                Book tmp;
                if (c.compare(arr[j].getPrice(),arr[j+1].getPrice())>0) {
                    tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }

    }

}


class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}