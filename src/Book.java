import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Book implements ChooseItem {
    static ArrayList<Book> bookList = new ArrayList<Book>();
    static ArrayList<BookingDetails> bookingList = new ArrayList<>();

    int daysLimit;
    double baseAmount;
    double overdueAmount;
    int rentalPoints = 1;

    public double calculateAmount(int daysRented) {
        return 0.0;
    }

    // Fixed rate for buying book
    public double calculateAmount() {
        return 100.0;
    }

    public void GoToOptions(Customer cust) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Collect movie and rent details from user
        do {
            System.out.println("Enter Book Type (Mystery/ Fantasy/ Science Fiction) : ");
            String bookName = br.readLine();

            int daysRented = 0;
            if (cust instanceof ItemRenter) {
                System.out.println("How many days do you want to rent it : ");
                daysRented = Integer.parseInt(br.readLine());
            }

            ItemOptionFactory BookType = new ItemOptionFactory();
            Book B = BookType.getBookType(bookName);

            bookList.add(B);

            BookingDetails binfo = new BookingDetails(cust, bookName, daysRented);
            bookingList.add(binfo);
            //R.setRentDetails();
            //cust.setFrequentRenterPoints(cust.getFrequentRenterPoints() + R.rentalPoints);
            System.out.println("do you want to select another book? Y/N: ");

        }while(br.readLine().equalsIgnoreCase("Y"));

        //Method call to calculate RentAmount and print output in JSON format
        for(int i = 0;i<bookList.size();i++) {
            Book book = bookList.get(i);
            if(cust instanceof Buyer) {
                cust.incrementFinalAmount(book.calculateAmount());
            }
            else {
                cust.incrementFinalAmount(book.calculateAmount(bookingList.get(i).getDaysRented()));
            }
            book.printJSON(bookingList.get(i));
        }
    }


}
