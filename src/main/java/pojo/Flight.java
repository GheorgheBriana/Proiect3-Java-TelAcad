package pojo;

public class Flight {
    private int id;
    private String city;
    private String departureDate;
    private String arrivalDate;
    private String airline;

    // Constructors
    public Flight(int id, String city, String departureDate, String arrivalDate, String airline) {
        this.id = id;
        this.city = city;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.airline = airline;
    }

    public Flight() {
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    //Override toString method
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", arrivalDate='" + arrivalDate + '\'' +
                ", airline='" + airline + '\'' +
                '}';
    }
}
