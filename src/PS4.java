import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PS4 implements ChooseItem {
    int daysLimit;
    double baseAmount;
    double overdueAmount;
    public PS4() {
        daysLimit = 2;
        baseAmount = 20;
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
        return 300.0;
    }

    public void GoToOptions(Customer cust) throws Exception {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int daysRented = 0;
        if (cust instanceof ItemRenter) {
            System.out.println("How many days do you want to rent : ");
            daysRented = Integer.parseInt(br.readLine());
        }
        PS4 v = new PS4();
        BookingDetails binfo = new BookingDetails(cust, "PS4", daysRented);

        if(cust instanceof Buyer) {
            cust.incrementFinalAmount(v.calculateAmount());
        }
        else {
            cust.incrementFinalAmount(v.calculateAmount(daysRented));
        }
        v.printJSON(binfo);
    }

}
