package airlineticketbookingsystem.dbconnection;
import java.sql.*;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/airlinereservation";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection connection;
    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connection Done");
        } catch(SQLException e) {
            System.out.println("Database Connection Error");
            e.printStackTrace();
        }
        return connection;
    }
}


