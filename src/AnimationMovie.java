public class AnimationMovie extends Movie {

    public AnimationMovie() {
        daysLimit = 3;
        baseAmount = 15;
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
