# Airline Ticket Booking System ✈️

A Java desktop application for booking airline tickets with **role-based access**, **SQL database integration**, and a clean **OOP modular design**.  
The system allows both users and admins to interact with flights, bookings, and accounts through a simple GUI.

---

## ⚡ Features

### 👥 User Roles

- **Guest**
  - Browse available flights without logging in.
  - Redirected to Sign Up / Login when attempting to book.
- **User**
  - Create account & login.
  - Search available flights.
  - Book flights & view previous bookings.
  - Manage account details.
- **Admin**
  - Manage flights (add, update, search, delete).
  - Manage airports and their prices.

### 🛠️ Technical Highlights

- **OOP Design**: Each entity (User, Flight, Airport…) implemented as a separate model class.
- **DAO Pattern**:
  - `AirportsDAO` → get, update, delete airports.
  - `FlightsDAO` → add, search, update, delete flights.
  - `UserDAO` → user registration, login, booking history, booking management.
  - `DatabaseConnection` → centralized connection handling.
- **Reusability**: Shared GUI components (`AdminToolBar`, `UserToolBar`, `MainToolBar`).
- **10+ Pages**: Login, Sign Up, User Home, Admin Home, and more.
- **SQL Integration**: Data persistence for flights, users, airports, and bookings.
- **Build Automation**: Configured with **Ant** for compilation and packaging.

---

## 📂 Project Structure

The following structure represents the **`src`** directory (source code) of the project.

```

arlineticketbookingsystem/
├─ assets/                  # Icons, images used in the UI
│
├─ components/              # Reusable toolbars
│   ├─ AdminToolBar.java
│   ├─ MainToolBar.java
│   └─ UserToolBar.java
│
├─ dbconnection/            # DAO classes & DB connection
│   ├─ AirportsDAO.java
│   ├─ DatabaseConnection.java
│   ├─ FlightsDAO.java
│   └─ UserDAO.java
│
├─ models/                  # Domain entities
│   ├─ Airport.java
│   ├─ AppSession.java
│   ├─ Flight.java
│   ├─ FlightAirport.java
│   ├─ User.java
│   └─ UserFlight.java
│
├─ pages/                   # GUI pages (11 total)
│   ├─ MainPage.java
│   ├─ SignUpPage.java
│   ├─ LoginPage.java
│   ├─ UserHomePage.java
│   └─ ...
│
├─ build.xml                # Ant build file
└─ README.md

```

---

## ⚙️ Technologies Used

- **Java (Swing, AWT)** – for GUI and business logic.
- **MySQL** – relational database.
- **NetBeans + Ant** – project management and build.
- **OOP principles** – modular and reusable design.

---

## ▶️ How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/1abdelrahman-ahmed/AirlineTicketBookingSystem.git
   cd AirlineTicketBookingSystem
   ```

2. Open the project in **NetBeans IDE**.

3. Set up the database:

   - Make sure you have **MySQL** installed and running.
   - Create a new database (e.g., `AirlineReservation_db`).
   - Import the schema from `sql/schema.sql`.

4. Update database connection settings:

   - Go to `src/dbconnection/DatabaseConnection.java`.
   - Update the username, password, and database name to match your setup.

5. Run the project from NetBeans:
   - The main window may appear (starting from the **MainPage**).

---

## 🗄️ Database Schema

The SQL schema required to set up the database is included in the [`sql`](./sql) folder.

- You can directly check the schema file here: [schema.sql](./sql/schema.sql)

---

## 🎨 Project Design

The initial design and UI mockups for the application were created using Canva.
You can view the full design here:
[View Project Mockups on Canva](https://www.canva.com/design/DAGy6CeVY9c/5QghkJWAWIcZOnMy54Ppdw/edit)

---

## 👥 Team Contribution

This project was developed as a team. I contributed across multiple stages of the project, with my main responsibility being the **integration between the GUI and the database**, ensuring smooth data flow and functionality.

---

## 📜 License

This project is released under the MIT License.
