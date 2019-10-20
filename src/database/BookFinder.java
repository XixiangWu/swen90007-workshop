package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookFinder {

    private static final String findAvailableBooksStatement =
            "SELECT * from books WHERE copies > 0";

    public List<BookGateway> findAvailableBooks() {
        List<BookGateway> result = new ArrayList<>();
        try {
            PreparedStatement stmt = DBConnection.prepare(findAvailableBooksStatement);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                int id = rs.getInt(1);
                String titleArg = rs.getString(2);
                String authorArg = rs.getString(3);
                int priceArg = rs.getInt(4);
                int qtyArg = rs.getInt(5);
                result.add(new BookGateway(id, titleArg, authorArg, priceArg, qtyArg));
            }
        } catch (SQLException e) {

        }
        return result;
    }
}
