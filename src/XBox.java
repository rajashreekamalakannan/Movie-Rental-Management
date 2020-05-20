import java.io.BufferedReader;
import java.io.InputStreamReader;

public class XBox implements ChooseItem {

    int daysLimit;
    double baseAmount;
    double overdueAmount;
    public XBox() {
        daysLimit = 2;
        baseAmount = 50;
        overdueAmount = 1.5;

    }

    public double calculateAmount(int daysRented) {
        double bill = 0;
        if(daysRented > daysLimit) {
            bill += (this.baseAmount+((daysRented - this.daysLimit) * this.overdueAmount));
        }
        bill += baseAmount;
        return bill;
    }

    // Fixed rate for buying book
    public double calculateAmount() {

        return 500.0;
    }

    public void GoToOptions(Customer cust) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int daysRented = 0;
        if (cust instanceof ItemRenter) {
            System.out.println("How many days do you want to rent : ");
            daysRented = Integer.parseInt(br.readLine());
        }
        XBox v = new XBox();
        BookingDetails binfo = new BookingDetails(cust, "XBox", daysRented);

        if(cust instanceof Buyer) {
            cust.incrementFinalAmount(v.calculateAmount());
        }
        else {
            cust.incrementFinalAmount(v.calculateAmount(daysRented));
        }
        v.printJSON(binfo);
    }

}
