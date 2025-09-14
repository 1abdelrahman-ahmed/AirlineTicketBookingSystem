package airlineticketbookingsystem.dbconnection;

import airlineticketbookingsystem.models.Airport;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AirportsDAO {

    public boolean addAirport(Airport airport) {
        String query = "INSERT INTO Airport (airport_name, price) VALUES (?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, airport.getAirportName());
            statement.setInt(2, airport.getPrice());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addAirport Error");
            e.printStackTrace();
            return false;
        }
    }

    public List<Airport> getAllAirports() {
        List<Airport> airports = new ArrayList<>();
        String query = "SELECT * FROM Airport";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setId(resultSet.getInt("id"));
                airport.setAirportName(resultSet.getString("airport_name"));
                airport.setPrice(resultSet.getInt("price"));
                airports.add(airport);
            }
        } catch (SQLException e) {
            System.out.println("getAllAirports Error");
            e.printStackTrace();
        }
        return airports;
    }
    
    public int getAirportPrice(String name) {
        String query = "SELECT price FROM Airport WHERE airport_name = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int price = resultSet.getInt("price");
                return price;
            } else {
                System.out.println("No matching airport found.");
            }
        } catch (SQLException e) {
            System.out.println("getAirportPrice Error");
            e.printStackTrace();
        }
        return -1;
    }


    public boolean updateAirport(Airport airport) {
        String query = "UPDATE Airport SET airport_name = ?, price = ? WHERE id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, airport.getAirportName());
            statement.setInt(2, airport.getPrice());
            statement.setInt(3, airport.getId());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getAllAirportsNames() {
        List<String> airportsName = new ArrayList<>();
        String query = "SELECT airport_name FROM airport;";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String airportName;
                airportName = resultSet.getString("airport_name");
                airportsName.add(airportName);
            }
        } catch (SQLException e) {
            System.out.println("getAllAirportsNames Error");
            e.printStackTrace();
        }
        return airportsName;
    }
    
    public boolean deleteAirport(int airportId) {
        String query = "DELETE FROM Airport WHERE id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, airportId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

