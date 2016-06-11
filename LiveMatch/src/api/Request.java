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
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dennis
 */
public class Request {

    private String query;
    private String apiKey;

    private Response response;

    public Request(String query, String apiKey) {
        this.query = query;
        this.apiKey = apiKey;

        execute();
    }

    private void execute() {
        String url = "https://" + query + "api_key=" + apiKey;

        URL obj;
        String response = "";
        int responseCode;
        JsonElement jsonx = null;
        HttpURLConnection connection = null;

        try {
            obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                response += line;
            }
            in.close();

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

        } catch (MalformedURLException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
    }

    public Response getResponse() {
        return response;
    }
}
