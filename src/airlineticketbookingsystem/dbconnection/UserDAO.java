package airlineticketbookingsystem.dbconnection;

import airlineticketbookingsystem.models.Flight;
import airlineticketbookingsystem.models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public boolean addUser(User user) {
        String query = "INSERT INTO users (role, email, password, first_name, last_name, phone, address, zip, city, state, country, gender, age)"
                     + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getRole());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getZip());
            statement.setString(9, user.getCity());
            statement.setString(10, user.getState());
            statement.setString(11, user.getCountry());
            statement.setString(12, user.getGender());
            statement.setInt(13, user.getAge());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addUser Error");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean checkEmailFound(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("checkEmailFound Error");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean checkUserLogin(String email, String passw) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            statement.setString(2, passw);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("checkUserLogin Error");
            e.printStackTrace();
            return false;
        }
    }
    
    public User getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setRole(resultSet.getString("role"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setPhone(resultSet.getString("phone"));
                user.setAddress(resultSet.getString("address"));
                user.setZip(resultSet.getString("zip"));
                user.setCity(resultSet.getString("city"));
                user.setState(resultSet.getString("state"));
                user.setCountry(resultSet.getString("country"));
                user.setGender(resultSet.getString("gender"));
                user.setAge(resultSet.getInt("age"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("getUserByEmail Error");
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean updateUser(User user) {
        String query = "UPDATE users SET `password` = ?, first_name = ?, last_name = ?, phone = ?, address = ?, zip = ?, city = ?, state = ?, country = ?, gender = ?, age = ? WHERE email = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, user.getPassword());
            statement.setString(2, user.getFirstName());
            statement.setString(3, user.getLastName());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getZip());
            statement.setString(7, user.getCity());
            statement.setString(8, user.getState());
            statement.setString(9, user.getCountry());
            statement.setString(10, user.getGender());
            statement.setInt(11, user.getAge());
            statement.setString(12, user.getEmail());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("updateUser Error");
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean addUserFlight(int userId, int flightId, int businessSeats, int economicSeats, int bagNumbers) {
        String query = "INSERT INTO UserFlights (user_id, flight_id, Business_seat, Economic_seat, Bag_number) "
                     + "VALUES (?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, flightId);
            statement.setInt(3, businessSeats);
            statement.setInt(4, economicSeats);
            statement.setInt(5, bagNumbers);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addUserFlight Error");
            e.printStackTrace();
            return false;
        }
    }

    public List<Flight> getPreviousFlights(int userId) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT f.* FROM Flights f " +
                       "INNER JOIN UserFlights uf ON f.id = uf.flight_id " +
                       "WHERE uf.user_id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightName(resultSet.getString("flight_name"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDate(resultSet.getString("date"));
                flight.setTime(resultSet.getString("time"));
                flight.setBusinessSeat(resultSet.getInt("Business_seat"));
                flight.setEconomySeat(resultSet.getInt("Economy_seat"));
                flight.setBagNumber(resultSet.getInt("Bag_number"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("getPreviousFlights Error");
            e.printStackTrace();
        }
        return flights;
    }
    
    public boolean deleteUserFlight(int userId, int flightId) {
        String query = "DELETE FROM UserFlights WHERE user_id = ? AND flight_id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, userId);
            statement.setInt(2, flightId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
