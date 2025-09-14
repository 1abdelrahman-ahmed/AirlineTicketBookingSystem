package airlineticketbookingsystem.dbconnection;

import airlineticketbookingsystem.models.Flight;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightsDAO {
    public boolean addFlight(Flight flight) {
        String query = "INSERT INTO flights (flight_name, source, destination, date, time, business_seat, economy_seat, bag_number) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, flight.getFlightName());
            statement.setString(2, flight.getSource());
            statement.setString(3, flight.getDestination());
            statement.setString(4, flight.getDate());
            statement.setString(5, flight.getTime());
            statement.setInt(6, flight.getBusinessSeat());
            statement.setInt(7, flight.getEconomySeat());
            statement.setInt(8, flight.getBagNumber());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("addFlight Error");
            e.printStackTrace();
            return false;
        }
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM Flights";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightName(resultSet.getString("flight_name"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDate(resultSet.getString("date"));///////////////////////
                flight.setTime(resultSet.getString("time"));//////////////////////
                flight.setBusinessSeat(resultSet.getInt("business_seat"));
                flight.setEconomySeat(resultSet.getInt("economy_seat"));
                flight.setBagNumber(resultSet.getInt("bag_number"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("getAllFlights Error");
            e.printStackTrace();
        }
        return flights;
    }
    
    public List<Flight> searchFlights(String source, String destination, String date) {
        List<Flight> flights = new ArrayList<>();
        String query = "SELECT * FROM Flights WHERE source = ? AND destination = ? AND date = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, source);
            statement.setString(2, destination);
            statement.setString(3, date);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Flight flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightName(resultSet.getString("flight_name"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDate(resultSet.getString("date"));
                flight.setTime(resultSet.getString("time"));
                flight.setBusinessSeat(resultSet.getInt("business_seat"));
                flight.setEconomySeat(resultSet.getInt("economy_seat"));
                flight.setBagNumber(resultSet.getInt("bag_number"));
                flights.add(flight);
            }
        } catch (SQLException e) {
            System.out.println("searchFlights Error");
            e.printStackTrace();
        }
        return flights;
    }
    
    public Flight searchFlightsID(int id) {
        String query = "SELECT * FROM Flights WHERE id = ?";
        Flight flight = null;
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                flight = new Flight();
                flight.setId(resultSet.getInt("id"));
                flight.setFlightName(resultSet.getString("flight_name"));
                flight.setSource(resultSet.getString("source"));
                flight.setDestination(resultSet.getString("destination"));
                flight.setDate(resultSet.getString("date"));
                flight.setTime(resultSet.getString("time"));
                flight.setBusinessSeat(resultSet.getInt("business_seat"));
                flight.setEconomySeat(resultSet.getInt("economy_seat"));
                flight.setBagNumber(resultSet.getInt("bag_number"));
            }
        } catch (SQLException e) {
            System.out.println("searchFlights Error");
            e.printStackTrace();
        }
        return flight;
    }
    
    public boolean updateFlight(Flight flight) {
        String query = "UPDATE Flights SET flight_name = ?, source = ?, destination = ?, date = ?, time = ?, business_seat = ?, economy_seat = ?, bag_number = ? " +
                       "WHERE id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, flight.getFlightName());
            statement.setString(2, flight.getSource());
            statement.setString(3, flight.getDestination());
            statement.setString(4, flight.getDate());
            statement.setString(5, flight.getTime());
            statement.setInt(6, flight.getBusinessSeat());
            statement.setInt(7, flight.getEconomySeat());
            statement.setInt(8, flight.getBagNumber());
            statement.setInt(9, flight.getId());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("updateFlight Error");
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFlight(int flightId) {
        String query = "DELETE FROM Flights WHERE id = ?";
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, flightId);
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.out.println("deleteFlight Error");
            e.printStackTrace();
            return false;
        }
    }
    
}
