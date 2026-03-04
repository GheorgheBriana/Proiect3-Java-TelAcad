package pojo;

public class Reservation {
    private int idUser;
    private int idZbor;
    private int numberOfChildrens;
    private int numberOfAdults;

    // Constructors
    public Reservation(int idUser, int idZbor, int numberOfChildrens, int numberOfAdults) {
        this.idUser = idUser;
        this.idZbor = idZbor;
        this.numberOfChildrens = numberOfChildrens;
        this.numberOfAdults = numberOfAdults;
    }

    public Reservation() {
    }

    // Getters and Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdZbor() {
        return idZbor;
    }

    public void setIdZbor(int idZbor) {
        this.idZbor = idZbor;
    }

    public int getNumberOfChildrens() {
        return numberOfChildrens;
    }

    public void setNumberOfChildrens(int numberOfChildrens) {
        this.numberOfChildrens = numberOfChildrens;
    }

    public int getNumberOfAdults() {
        return numberOfAdults;
    }

    public void setNumberOfAdults(int numberOfAdults) {
        this.numberOfAdults = numberOfAdults;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Reservation{" +
                "idUser=" + idUser +
                ", idZbor=" + idZbor +
                ", numberOfChildrens=" + numberOfChildrens +
                ", numberOfAdults=" + numberOfAdults +
                '}';
    }
}
