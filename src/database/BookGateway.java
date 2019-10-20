package database;

import java.rmi.registry.Registry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookGateway {

    private int id;
    private String title;
    private String author;
    private float price;
    private int qty;

    public BookGateway(int id, String title, String author, float price, int qty) {
//        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.qty = qty;
    }

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public float getPrice() {return price;}
    public int getQty() {return qty;}

    public static BookGateway load(ResultSet rs) throws SQLException {
        int id = rs.getInt(1);
        BookGateway result = database.Registry.getBook(id);
        if (result != null)
            return result;
        String titleArg = rs.getString(2);
        String authorArg = rs.getString(3);
        int priceArg = rs.getInt(4);
        int qtyArg = rs.getInt(5);
        result = new BookGateway(id, titleArg, authorArg, priceArg, qtyArg);
        database.Registry.addBook(result);
        return result;
    }



}
