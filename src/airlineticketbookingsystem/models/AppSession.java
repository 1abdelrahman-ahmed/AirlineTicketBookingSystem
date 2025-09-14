package airlineticketbookingsystem.models;

public class AppSession {
    private static User currentUser;
    private static Flight currentFlight;
    
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    public static User getCurrentUser() {
        return currentUser;
    }
    
    public static void setcurrentFlight(Flight flight) {
        currentFlight = flight;
    }

    public static Flight getcurrentFlight() {
        return currentFlight;
    }
}
