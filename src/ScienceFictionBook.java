public class ScienceFictionBook extends Book {
    public ScienceFictionBook() {
        daysLimit = 3;
        baseAmount = 5;
        overdueAmount = 1.5;
    }

    @Override
    public double calculateAmount(int daysRented) {
        double bill = 0;
        if(daysRented > daysLimit) {
            bill += (this.baseAmount+((daysRented - this.daysLimit) * this.overdueAmount));
        }
        bill += baseAmount;
        return bill;
    }
}
