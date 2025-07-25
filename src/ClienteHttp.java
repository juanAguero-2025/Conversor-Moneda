import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;



public class ClienteHttp {
    private final HttpClient client;
    private final Gson gson;
     private final String apiKey = "API_KEY"; 

    public ClienteHttp() {
        this.client = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public double obtenerTasa(String base, String destino) {
        String url = String.format("https://v6.exchangerate-api.com/v6/3758d155fe765ce824711c83/latest/USD", apiKey, base);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            RespuestaTasaCambio respuesta = gson.fromJson(response.body(), RespuestaTasaCambio.class);

            if (!"success".equalsIgnoreCase(respuesta.getResult()) || respuesta.getConversionRates() == null) {
                System.out.println("Error en la API:");
                System.out.println(response.body());
                return 0.0;
            }

            return respuesta.getConversionRates().getOrDefault(destino, 0.0);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error en la solicitud HTTP", e);
        }
    }
}
