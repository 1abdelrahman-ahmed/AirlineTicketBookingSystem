package airlineticketbookingsystem.models;

public class FlightAirport {
    private int flightId;
    private int airportId;

    public FlightAirport(int flightId, int airportId) {
        this.flightId = flightId;
        this.airportId = airportId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
