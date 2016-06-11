/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class RequestManager {

    private String apiKey;
    private HttpURLConnection connection;

    public RequestManager(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public JsonElement sendRequest(String query) throws RiotApiException, IOException {
        String url = "https://" + query + "api_key=" + apiKey;

        URL obj;
        String response = "";
        int responseCode;
        JsonElement jsonx = null;

        obj = new URL(url);
        connection = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        connection.setRequestMethod("GET");

        responseCode = connection.getResponseCode();

        /*for (Map.Entry<String, List<String>> entry : connection.getHeaderFields().entrySet()) {
         System.out.println(entry.getKey()+" : "+entry.getValue());
         }*/
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String line;

        while ((line = in.readLine()) != null) {
            response += line;
        }
        in.close();

        jsonx = new JsonParser().parse(response);

        String rateLimit = connection.getHeaderField("X-Rate-Limit-Count");
        RateLimit rl = new RateLimit(rateLimit);

        if (rl.isSecondsLimitExceeded() || rl.isMinutesLimitExceeded()) {
            System.out.println("RATE LIMIT EXCEEDED - SLEEPING");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        connection.disconnect();

        return jsonx;
    }

}
