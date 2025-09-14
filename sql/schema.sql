--------------------------------------------------------
-- Create Database
--------------------------------------------------------
CREATE DATABASE AirlineReservation;
USE AirlineReservation;

--------------------------------------------------------
-- Users Table
--------------------------------------------------------
CREATE TABLE Users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    phone VARCHAR(20),
    address VARCHAR(255),
    zip VARCHAR(10),
    city VARCHAR(50),
    state VARCHAR(50),
    country VARCHAR(50),
    gender VARCHAR(10),
    age INT
);

--------------------------------------------------------
-- Flights Table
--------------------------------------------------------
CREATE TABLE Flights (
    id INT AUTO_INCREMENT PRIMARY KEY,
    flight_name VARCHAR(100),
    source VARCHAR(100),
    destination VARCHAR(100),
    date VARCHAR(50),
    time VARCHAR(50),
    business_seat INT,
    economy_seat INT,
    bag_number INT
);

--------------------------------------------------------
-- Airport Table
--------------------------------------------------------
CREATE TABLE Airport (
    id INT AUTO_INCREMENT PRIMARY KEY,
    airport_name VARCHAR(100),
    price INT
);

--------------------------------------------------------
-- UserFlights (relation between Users & Flights)
--------------------------------------------------------
CREATE TABLE UserFlights (
    user_id INT,
    flight_id INT,
    Business_seat INT,
    Economic_seat INT,
    Bag_number INT,
    PRIMARY KEY (user_id, flight_id),
    FOREIGN KEY (user_id) REFERENCES Users(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (flight_id) REFERENCES Flights(id) ON UPDATE CASCADE ON DELETE CASCADE
);

--------------------------------------------------------
-- FlightAirports (relation between Flights & Airports)
--------------------------------------------------------
CREATE TABLE FlightAirports (
    flight_id INT,
    airport_id INT,
    PRIMARY KEY (flight_id, airport_id),
    FOREIGN KEY (flight_id) REFERENCES Flights(id) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY (airport_id) REFERENCES Airport(id) ON UPDATE CASCADE ON DELETE CASCADE
);

--------------------------------------------------------
-- Sample Data
--------------------------------------------------------

-- Insert a sample user
INSERT INTO Users (role, email, password, first_name, last_name, phone, address, zip, city, state, country, gender, age)
VALUES ("user", "abdelrahman@gmail.com", "abdelrahman123", "abdelrahman", "ahmed", "01012061940", "egypt, sharqia, zagazig", "11311", "sharqia", "zagazig", "egypt", "male", 20);

-- Insert airports
INSERT INTO Airport (airport_name, price) VALUES ("Cairo", 10000);

-- Insert flights
INSERT INTO Flights (flight_name, source, destination, date, time, business_seat, economy_seat, bag_number)
VALUES ("test", "testsorc", "testdes", "testdate", "testtime", 20, 80, 100);

INSERT INTO Flights (flight_name, source, destination, date, time, business_seat, economy_seat, bag_number)
VALUES ("tests", "Cairo", "Cairo", "20-12-2024", "testtime", 20, 80, 100);

INSERT INTO Flights (flight_name, source, destination, date, time, business_seat, economy_seat, bag_number)
VALUES ("tests", "Cairo", "Aswan", "20-12-2024", "12:00", 20, 80, 100);

--------------------------------------------------------
-- Queries for debugging / testing
--------------------------------------------------------
SELECT * FROM Flights;
SELECT * FROM Users;
