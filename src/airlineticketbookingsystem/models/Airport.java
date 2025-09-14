package airlineticketbookingsystem.models;

public class Airport {
    private int id;
    private String airportName;
    private int price;

    public Airport() {};
    public Airport(int id, String airportName, int price) {
        this.id = id;
        this.airportName = airportName;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
