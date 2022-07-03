import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) throws Exception {

        String apiKey = new ApiKey().getApiKey();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                .build();

        HttpClient httpClient = HttpClient.newBuilder()
                .build();

        HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
        System.out.println(response.body());

    }
}
