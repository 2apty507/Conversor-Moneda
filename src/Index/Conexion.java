package Index;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conexion {
    public static DatosJson api(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/You-API-key/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(direccion).build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatosJson.class);
        } catch ( IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
