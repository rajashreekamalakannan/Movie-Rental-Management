public class Customer {
    String customerName;
    int frequentRenterPoints;
    double finalAmount;

    public void incrementFinalAmount(double bill) {
        this.finalAmount += bill;
    }

    public double getFinalAmount() {
        return this.finalAmount;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
        this.frequentRenterPoints = 0;
        finalAmount = 0;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public void setFrequentRenterPoints(int frequentRenterPoints) {
        this.frequentRenterPoints = frequentRenterPoints;
    }

    public int calculateAmount() {
        return 0;
    }
}
