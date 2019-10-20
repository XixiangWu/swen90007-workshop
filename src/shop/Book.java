package shop;

import database.BookFinder;
import database.BookGateway;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private String isbn;
    private String author;
    private String title;
    private float price;
    private int copies;

    public Book(String isbn, String author, String title, float price, int copy) {
        this.isbn = isbn;
        this.author = author;
        this.title = title;
        this.price = price;
        this.setCopies(copy);
    }

    public void setCopies(int copy) {
        this.copies = copy;
    }

    public Book() {}

    public String getIsbn() {return isbn;}
    public String getAuthor() {return author;}
    public String getTitle() {return title;}
    public float getPrice() {return price;}
    public int getCopies() {return copies;}

    public static List<Book> getAllAvaliableBooks() {
        BookFinder finder = new BookFinder();
        List<Book> result = new ArrayList<Book>();
        List<BookGateway> booksRecords = finder.findAvailableBooks();

        for(BookGateway br: booksRecords) {
            Book book = new Book(String.valueOf(br.getId()), br.getAuthor(), br.getTitle(), br.getPrice(), br.getQty());
            result.add(book);
        }

        return result;
    }

}
