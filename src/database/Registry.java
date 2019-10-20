package database;

import java.util.HashMap;
import java.util.Map;

public class Registry {

    private static Map<Integer, BookGateway> bookGateway = new HashMap<>();
    private static Map<Integer, CartItemGateway> cartItemGateway = new HashMap<>();

    public static BookGateway getBook(int id) {
        return bookGateway.get(id);
    }

    public static void addBook(BookGateway bookGateway) {
        Registry.bookGateway.put(bookGateway.getId(), bookGateway);
    }

    public static CartItemGateway getCartItemGateway(int id) {
        return cartItemGateway.get(id);
    }

    public static void addCartItemGateway(CartItemGateway cartItemGateway) {
        Registry.cartItemGateway.put(cartItemGateway.hashCode(), cartItemGateway);
    }


}
