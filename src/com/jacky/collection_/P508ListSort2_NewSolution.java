package com.jacky.collection_;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 2021/10/22
 */
@SuppressWarnings("all")
public class P508ListSort2_NewSolution {
    public static void main(String[] args) {

//        List list = new ArrayList();
          List list = new LinkedList();
//        List list = new Vector();


        list.add(new BookNew("三国","罗贯中",50));
        list.add(new BookNew("西游记","吴承恩",5));
        list.add(new BookNew("水浒传","施耐庵",9));
        list.add(new BookNew("红楼梦","曹雪芹",100));
        list.add(new BookNew("西游记","吴承恩",5));

        for (Object o :list) {
            System.out.println(o);
        }

        System.out.println("-----------");

        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                BookNew book1 = (BookNew)o1;
                BookNew book2 = (BookNew)o2;
                return (int)(book1.getPrice()-book2.getPrice());
            }
        });

        for (Object o :list) {
            System.out.println(o);
        }


    }
    
    public static void sortCuntome(List list, Comparator c){
        int listsize = list.size();
        BookNew tmp;
        for (int i = 0; i < listsize-1; i++) {
            for (int j = 0; j < listsize-1-i; j++) {

                if (c.compare(list.get(j),list.get(j+1)) > 0) {
                    tmp = (BookNew)list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,tmp);
                }
                
            }
        }
    }
    
}


class BookNew {
    private String name;
    private String author;
    private double price;

    public BookNew(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("名称：%s\t价格：%d\t\t作者：%s", name, (int)price, author);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}