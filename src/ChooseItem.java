public interface ChooseItem {
    public void GoToOptions(Customer cust) throws Exception;
    default public void printJSON(BookingDetails bookingDetails) {
        System.out.println("Customer Name: "+ bookingDetails.getCust().getCustomerName());
        System.out.println("Item name: "+ bookingDetails.getMovieName());
    };
}
