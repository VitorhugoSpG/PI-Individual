package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import org.json.JSONObject;
import util.Log;
import util.LogLevel;

public class SlackApi {
    
    private static final String webhook = "https://hooks.slack.com/services/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";

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {
        HttpRequest.newBuilder(URI.create(webhook))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();
    }
    
    public static void verificarOcorrencia(Double cpu, Double memoria, Double disco, Log log){
        if(memoria > 80.0 || cpu > 80.0 || disco > 80.0){
            JSONObject json = new JSONObject();

            if(cpu > 80.0){
                json.put("text", "O limite de 80% de uso da cpu foi atingido!");
                log.makeLog(LogLevel.WARNING, "Limite de 80% de uso da cpu foi atingido!");
            }

            if(memoria > 80.0){
                json.put("text", "O limite de 80% de uso da memória foi atingido!");
                log.makeLog(LogLevel.WARNING, "Limite de 80% de uso da memória foi atingido!");
            }

            if(disco > 80.0){
                json.put("text", "O limite de 80% de uso do disco foi atingido!");
                log.makeLog(LogLevel.WARNING, "Limite de 80% de uso da disco foi atingido!");
            }

            try {
                SlackApi.sendMessage(json);
            } catch (IOException | InterruptedException e) {
                log.makeLog(LogLevel.ERROR, e.toString());
            }

        }
        
    }
    
}
