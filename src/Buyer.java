import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Buyer extends Customer {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Buyer(String name) {
        super(name);
    }
}
