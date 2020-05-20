import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Movie implements ChooseItem {
    int daysLimit;
    double baseAmount;
    double overdueAmount;
    //private double totalRentAmount = 0;
    int rentalPoints = 1;

    //Print footer lines
    static void printStatement(Customer cust){
        System.out.println("Hi " + cust.getCustomerName());
        //System.out.println("Your total Bill is $ " + totalRentAmount);
        System.out.println("Congratulations! You earned " + cust.getFrequentRenterPoints() + " frequent renter points")	;
    }

    public double calculateAmount(int daysRented) {
        return 0.0;
    }

    // Fixed rate for buying movie
    public double calculateAmount() {
        return 50.0;
    }

    static ArrayList<Movie> rentalList = new ArrayList<>();
    static ArrayList<BookingDetails> bookingList = new ArrayList<>();

    public void GoToOptions(Customer cust) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Collect movie and rent details from user
        do {
            System.out.println("Enter Movie name (Wizard of Oz/ Finding Nemo/ Batman) : ");
            String movieName = br.readLine();
            int daysRented = 0;
            if (cust instanceof ItemRenter) {
                System.out.println("How many days do you want to rent : ");
                daysRented = Integer.parseInt(br.readLine());
            }

            BookingDetails binfo = new BookingDetails(cust, movieName, daysRented);
            bookingList.add(binfo);

            //ContextMovieType contextMovieType = new ContextMovieType(movieName);
            ItemOptionFactory BookType = new ItemOptionFactory();
            Movie R = BookType.getMovieType(movieName);

            rentalList.add(R);
            // R.setRentDetails();
            cust.setFrequentRenterPoints(cust.getFrequentRenterPoints() + R.rentalPoints);
            System.out.println("Want to select another movie? Y/N: ");

        } while (br.readLine().equalsIgnoreCase("Y"));

        // Method call to calculate RentAmount and print output in JSON format
        for (int i = 0; i < rentalList.size(); i++) {
            Movie movie = rentalList.get(i);
            if(cust instanceof Buyer) {
                cust.incrementFinalAmount(movie.calculateAmount());
            }
            else {
                cust.incrementFinalAmount(movie.calculateAmount(bookingList.get(i).getDaysRented()));
            }
            movie.printJSON(bookingList.get(i));
        }
        // Method call to print footer lines
        Movie.printStatement(cust);
    }
}
