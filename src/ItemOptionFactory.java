public class ItemOptionFactory {
    public Customer getBuyRentOption(String buyOrRent, String name) throws Exception {

        if (buyOrRent.equalsIgnoreCase("Buy")) {
            return new Buyer(name);
        } else if (buyOrRent.equalsIgnoreCase("Rent")) {
            return new ItemRenter(name);
        } else {
            throw new Exception("Please input a correct option! Rent : 'Rent' Buy: 'Buy'");
        }

    }

    //Method for calling objects of Buy or Rent Options

    public ChooseItem setItemSelected(int itemNumber) throws Exception {
        if(itemNumber == 1) {
            return new Movie();
        }else if(itemNumber == 2) {
            return new MusicCD();
        }else if(itemNumber == 3) {
            return new Book();
        }else if(itemNumber == 4) {
            return new VideoGame();
        }else if(itemNumber == 5) {
            return new XBox();
        }else if(itemNumber == 6) {
            return new PS4();
        }else {
            throw new Exception("Sorry this item is unavailable or out of stock in our shop. Please enter only items in the list displayed! ");
        }
    }

    public Movie getMovieType(String movieName) throws Exception{
        if(movieName.equalsIgnoreCase("Batman")){
            return new ActionMovie();
        }
        if(movieName.equalsIgnoreCase("Finding nemo")){
            return new AnimationMovie();
        }
        if(movieName.equalsIgnoreCase("Wizard of Oz")){
            return new ClassicMovie();
        }
        else {
            throw new Exception("Oops! Please enter correct movie name from available list!");
        }
    }

    public Book getBookType(String bookName) throws Exception {
        if(bookName.equalsIgnoreCase("Mystery")){
            return new MysteryBook();
        }
        if(bookName.equalsIgnoreCase("Fantasy")){
            return new FantasyBook();
        }
        if(bookName.equalsIgnoreCase("Science Fiction")){
            return new ScienceFictionBook();
        }
        else {
            throw new Exception("Oops! Please select the correct book type!");
        }
    }

    public MusicCD getMusicType(String item) throws Exception {
        if(item.equalsIgnoreCase("Jazz")){
            return new JazzMusic();
        }
        if(item.equalsIgnoreCase("Pop")){
            return new PopMusic();
        }
        else {
            throw new Exception("Oops! Please select correct music type!");
        }
    }

}
