package database;

import shop.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder {

    private static final String findAvailableBooksStatement =
            "SELECT * from books WHERE copies > 0";
    private static final String newBookStatement =
            "INSERT INTO books VALUES (?, ?, ?, ?, ?);";
    private static final String updateBookCopiesStatement =
            "UPDATE books SET copies = copies - 1 WHERE isbn = ?;";


    public List<BookGateway> findAvailableBooks() {
        List<BookGateway> result = new ArrayList<>();
        try {
            PreparedStatement stmt = DBConnection.prepare(findAvailableBooksStatement);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                result.add(BookGateway.load(rs));

//                System.out.println(rs.getInt(1));
//                int id = rs.getInt(1);
//                String titleArg = rs.getString(2);
//                String authorArg = rs.getString(3);
//                int priceArg = rs.getInt(4);
//                int qtyArg = rs.getInt(5);
//                result.add(new BookGateway(id, titleArg, authorArg, priceArg, qtyArg));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }


    public static Book getBook(int isbn) {
        BookFinder finder = new BookFinder();
        List<Book> result = new ArrayList<Book>();
        List<BookGateway> booksRecords = finder.findAvailableBooks();

        for(BookGateway br: booksRecords) {
            if (br.getId() == isbn) {
                return new Book(String.valueOf(br.getId()), br.getAuthor(), br.getTitle(), br.getPrice(), br.getQty());
            }
        }
        return null;
    }


    public static void newBook(int id, String title, String author, float price, int qty) {
        try {
            PreparedStatement stm = DBConnection.prepare(newBookStatement);
            stm.setInt(1,id);
            stm.setString(2, title);
            stm.setString(3,author);
            stm.setFloat(4, price);
            stm.setInt(5, qty);
            stm.executeUpdate();
            System.out.println("new book(" + id + ") insert successfully");
        } catch (SQLException e) {
            System.out.print("ERROR: method: newBook: ");
            System.out.println(e.getMessage());
        }
    }

    public static void addToCart(int bookId) {
        try {
            PreparedStatement stm = DBConnection.prepare(updateBookCopiesStatement);
            stm.setInt(1,bookId);
            stm.executeUpdate();
            System.out.println("Book(" + bookId + ") Copies update successfully");
        } catch (SQLException e) {
            System.out.print("ERROR: method: addToCart: ");
            System.out.println(e.getMessage());
        }
    }

}
