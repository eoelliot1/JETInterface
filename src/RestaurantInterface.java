
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class RestaurantInterface {
    public static void main(String[] args) {
        //Obtaining user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter postcode...");
        try {

            String input = scanner.nextLine().replaceAll("\\s", "");
            String API_ENDPOINT = "https://uk.api.just-eat.io/discovery/uk/restaurants/enriched/bypostcode/" + input; //API EndPoint
            System.out.println("Searching: " + API_ENDPOINT);

            // Initiate HTTP Client
            HttpClient client = HttpClient.newHttpClient();

            // Initiate GET request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_ENDPOINT))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse JSON response as new ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(response.body());
            JsonNode restaurants = jsonResponse.path("restaurants"); //Extract restaurants field.


            if (restaurants.isArray()) {
                for (int i = 0; i < 10; i++) {
                    JsonNode name = restaurants.get(i).findPath("name");
                    JsonNode address = restaurants.get(i).findPath("address");
                    JsonNode rating = restaurants.get(i).findPath("rating").findPath("count"); //MAYBE REMOVE COUNT AND JUST DISPLAY WHOLE THING? ITS WHAT THEY ASK FOR
                    JsonNode Cuisines = restaurants.get(i).findPath("cuisines");


                    System.out.println("User No." + i + "---------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.println("Name: " + name);
                    System.out.println("Address: " + address);
                    System.out.println("Rating: " + rating);
                    System.out.print("Cuisines: ");
                    for (int j = 0; j < Cuisines.size(); j++ ) {
                        System.out.println(Cuisines.get(j));
                    }
                }
            }


            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}