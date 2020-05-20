import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ItemRenter extends Customer {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public ItemRenter(String name) {
        super(name);
    }
}
