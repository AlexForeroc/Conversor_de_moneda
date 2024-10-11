package API;

import Modelo.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaApi {
    public Moneda buscaMoneda(String monedaDeOrigen, String monedaDeDestino, double montoAConvertir){
        String apiKey = "TU_API_KEY"; // Reemplaza con tu clave API
        URI api_url = URI.create("https://v6.exchangerate-api.com/v6/91844ca894a5dfd7aa865081/pair/" +
                monedaDeOrigen + "/" +
                monedaDeDestino + "/" +
                montoAConvertir);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(api_url)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e){
            throw new RuntimeException("No se pudo encontrar la moneda: " + e.getMessage());
        }
    }
}