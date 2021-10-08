package personaltrain;

public class P254 {
    public static void main(String[] args) {

        Book book = new Book(70);
        book.updatePrice();
        System.out.println(book.price);
    }
}

class Book {

    int price;

    public Book(int price) {
        this.price = price;
    }

    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        } else if (this.price > 100) {
            this.price = 100;
        } else {
            System.out.println("book price is less than 100, is " + this.price);
        }
    }
}