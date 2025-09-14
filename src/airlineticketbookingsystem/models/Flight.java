package airlineticketbookingsystem.models;


public class Flight {
    private int id;
    private String flightName;
    private String source;
    private String destination;
    private String date;
    private String time;
    private int businessSeat;
    private int economySeat;
    private int bagNumber;

    public Flight(){};
    
    public Flight(int id, String flightName, String source, String destination, String date, String time,
                  int businessSeat, int economySeat, int bagNumber) {
        this.id = id;
        this.flightName = flightName;
        this.source = source;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.businessSeat = businessSeat;
        this.economySeat = economySeat;
        this.bagNumber = bagNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(int businessSeat) {
        this.businessSeat = businessSeat;
    }

    public int getEconomySeat() {
        return economySeat;
    }

    public void setEconomySeat(int economySeat) {
        this.economySeat = economySeat;
    }

    public int getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(int bagNumber) {
        this.bagNumber = bagNumber;
    }
}
