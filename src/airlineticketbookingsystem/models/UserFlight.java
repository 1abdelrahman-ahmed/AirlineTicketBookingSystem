package airlineticketbookingsystem.models;

public class UserFlight {
    private int userId;
    private int flightId;

    public UserFlight(int userId, int flightId) {
        this.userId = userId;
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
}
