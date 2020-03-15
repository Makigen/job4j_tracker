package oop;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Bible", 1376);
        Book book2 = new Book("War and Piece", 956);
        Book book3 = new Book("Head First Java", 722);
        Book book4 = new Book("Clean Code", 464);
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("Swap books with index 0 and 3");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Show only books with name 'Clean Code'");
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            if (bk.getName().equals("Clean Code")) {
            System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
