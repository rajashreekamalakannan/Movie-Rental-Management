import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Driver {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello! Please enter your name : ");
        String customerName = br.readLine();

        System.out.println("Welcome " + customerName + "!");

        ItemOptionFactory itemOptionFactory = new ItemOptionFactory();
        try {
            System.out.println(" Rent or buy items in our Shop. Please enter initial 'Rent' for Renting or 'Buy' for buying :");
            String buyOrRent = br.readLine();
            Customer cust = itemOptionFactory.getBuyRentOption(buyOrRent, customerName);
            do {
                System.out.println(
                        "Enter Item number you want from list\n1. Movie\n2. Music CD\n3. Books\n4. Video Game\n5. XBox\n6. PS4");
                ChooseItem item = itemOptionFactory.setItemSelected(Integer.parseInt(br.readLine()));
                item.GoToOptions(cust);
                System.out.println("Do you wish to continue (y/n)");
            } while (br.readLine().equalsIgnoreCase("y"));
            System.out.println("Final Amount: $" + cust.getFinalAmount());

            System.out.println("Select the type of customer: \n1. New customer\n2. Referenced customer\n3. Loyalty card customer \n4. Normal customer");
            int option= Integer.parseInt(br.readLine());
            NewlyRegisteredDiscount newlyRegisteredDiscount = new NewlyRegisteredDiscount();
            ReferencedUserDiscount referencedUserDiscount = new ReferencedUserDiscount(newlyRegisteredDiscount);
            LoyaltyDiscount loyaltyPlanDiscount = new LoyaltyDiscount(referencedUserDiscount);
            BigDecimal discountPrice;
            if(option==1)
                discountPrice = newlyRegisteredDiscount.apply(new BigDecimal(cust.getFinalAmount()));
            else if(option==2)
                discountPrice = referencedUserDiscount.apply(new BigDecimal(cust.getFinalAmount()));
            else if(option==3)
                discountPrice = loyaltyPlanDiscount.apply(new BigDecimal(cust.getFinalAmount()));
            else
                discountPrice= new BigDecimal(cust.getFinalAmount());

            System.out.println("Final Amount after discount: " +discountPrice);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
