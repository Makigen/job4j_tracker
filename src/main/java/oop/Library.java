package oop;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[] {new Book("Bible", 1376), new Book("War and Piece", 956), new Book("Head First Java", 722), new Book("Clean Code", 464)};
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
