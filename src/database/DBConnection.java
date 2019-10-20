package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnection {

    // JDBC driver name and database URL
//    private static final String DB_CONNECTION = "jdbc:postgresql://localhost:5432/bookshop";
    private static final String DB_CONNECTION = "postgres://aopdyzhcotqqme:ae5f296058696c800bef11a36bf53752bf2169dfc9f1ca5c9b3c56f2520ef6b5@ec2-174-129-43-40.compute-1.amazonaws.com:5432/dcmimk7i0tg061";


    // Database credentials
//    private static final String DB_USER = "aopdyzhcotqqme";
//    private static final String DB_PASSWORD = "ae5f296058696c800bef11a36bf53752bf2169dfc9f1ca5c9b3c56f2520ef6b5";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "xindefengbao12";

    private static Connection dbConnection = null;

    public static PreparedStatement prepare(String stm) throws SQLException {

        PreparedStatement preparedStatement = null;

        try {
            Connection dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(stm);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return preparedStatement;
    }

    private static Connection getDBConnection() {

        try {
            //Register JDBC driver
            DriverManager.registerDriver(new org.postgresql.Driver());

            //Open a connection
            dbConnection = DriverManager.getConnection(
                    DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Connection problem");
        return null;
    }
}
