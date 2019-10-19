package shop;

import java.util.LinkedList;

public class User {

    private static Customer user;

    // Dummy Data
    public static Customer getCustomer() {
        if (User.user == null) {
            User.user = new Customer("albert.einstein@ias.edu",
                                     "Alber Einstein",
                                   "Office 9, IAS, Princeton, USA",
                                            new LinkedList<>(),
                                            new ShoppingCart());
        }
        return User.user;
    }

}
