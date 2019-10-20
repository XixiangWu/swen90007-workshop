package database;

import shop.Book;

import java.util.List;

public class CartItemGateway {

    private int id;
    private String title;
    private String author;
    private float price;
    private int qty;

    public CartItemGateway() {
//        super();
    }

    public int getId() {return id;}
    public String getTitle() {return title;}
    public String getAuthor() {return author;}
    public float getPrice() {return price;}
    public int getQty() {return qty;}

}
