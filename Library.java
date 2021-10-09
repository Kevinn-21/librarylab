package librarylab;

import java.util.ArrayList;

public class Library {
    // Add the missing implementation to this class

    //need array
    ArrayList<Book> books = new ArrayList<Book>();
    String address;

    public Library() {
    }
    public Library(String address) {
        this.address = address;
    }
    public void addBook(Book b) {
        books.add(b);
    }
    public static void printOpeningHours() {
        System.out.println("9:00AM - 5:00PM");
    }
    public void printAddress() {
        System.out.println(address);
    }
    public void borrowBook(String title) {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).getTitle().equals(title)) {
                if(books.get(i).isBorrowed()==false) {
                    books.get(i).borrowed();
                    return;
                }
                else {
                    System.out.println(title + " is not available.\n");
                    return;
                }
            }
        }
        System.out.println("Book does not exist in this library.");
    }
    public void printAvailableBooks() {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).isBorrowed() == false) {
                System.out.println(books.get(i).getTitle());
            }
        }
    }
    public void returnBook(String title) {
        for(int i=0; i<books.size(); i++) {
            if(books.get(i).getTitle().equals(title)) {
                books.get(i).returned();
            }
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");//
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        firstLibrary.printAvailableBooks();
        //can check if book is borrowed by modifying printAvailableBooks to only 
        //non-borrowed-books

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();//
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");//
        System.out.println();

        // // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();//
    }
}