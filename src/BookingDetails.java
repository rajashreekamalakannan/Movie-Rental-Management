public class BookingDetails {

    int daysRented;
    String movieName;
    Customer cust;

    public BookingDetails(Customer cust, String movieName, int daysRented) {
        this.cust = cust;
        this.movieName = movieName;
        this.daysRented = daysRented;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public Customer getCust() {
        return cust;
    }

    public void setCust(Customer cust) {
        this.cust = cust;
    }

    public int getDaysRented() {
        return daysRented;
    }
    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

}
