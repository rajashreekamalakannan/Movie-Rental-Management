import com.google.gson.JsonObject;

public abstract class Rental {
    int daysLimit;
    double baseAmount;
    double overdueAmount;
    private double totalRentAmount = 0;
    int rentalPoints = 1;

    public void incrementSubBill(double bill) {
        this.totalRentAmount += bill;
    }

    public double getBill() {
        return this.totalRentAmount;
    }

    //Print footer lines
    static void printStatement(Customer cust){
        System.out.println("Hi " + cust.getCustomerName());
        //System.out.println("Your total Bill is $ " + totalRentAmount);
        System.out.println("You earned " + cust.getFrequentRenterPoints() + " frequent renter points")	;
    }
    //Print output in JSON format
    public void printJSON(BookingDetails bookingDetails) {
        JsonObject json = new JsonObject();
        //json.addProperty("totalRentAmount", totalRentAmount);
        json.addProperty("Customer Name ", bookingDetails.getCust().getCustomerName());
        json.addProperty("Item name", bookingDetails.getMovieName());
        System.out.println(json);
    }

    //Provides runtime implementation as per movie type
    abstract void calculateRentAmount(Rental rent, int daysRented);

}
