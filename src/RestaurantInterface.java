
import java.util.Scanner;

public class RestaurantInterface {
    public static void main(String[] args) {
        //Obtaining user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postcode...");
        String name = scanner.nextLine().replaceAll("\\s", "");
        try {
            String url = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/" + name; //API EndPoint
            System.out.println("Searching: " + url);
            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}