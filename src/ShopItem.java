import com.google.gson.JsonObject;


public interface ShopItem {
    public void GoToOptions(Customer cust) throws Exception;
    //Print output in JSON format
    default public void printJSON(BookingDetails bookingDetails) {
        JsonObject json = new JsonObject();
        //json.addProperty("totalRentAmount", totalRentAmount);
        json.addProperty("Customer Name ", bookingDetails.getCust().getCustomerName());
        json.addProperty("Item name", bookingDetails.getMovieName());
        System.out.println(json);
    };
}
