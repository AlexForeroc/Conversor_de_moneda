package PJson;

import Modelo.Moneda;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeneradorJson {
    public void guardarArchivo(Moneda conversion, String origen, String destino) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String nombreArchivo = origen + "-" + destino + ".json";
        try (FileWriter escritura = new FileWriter(nombreArchivo)) {
            escritura.write(gson.toJson(conversion));
        }
    }
}