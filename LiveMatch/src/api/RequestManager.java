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

    public static final int CODE_SUCCESS_OK = 200;
    public static final int CODE_SUCCESS_NO_CONTENT = 204;
    public static final int CODE_ERROR_BAD_REQUEST = 400;
    public static final int CODE_ERROR_UNAUTHORIZED = 401;
    public static final int CODE_ERROR_FORBIDDEN = 403;
    public static final int CODE_ERROR_NOT_FOUND = 404;
    public static final int CODE_ERROR_METHOD_NOT_ALLOWED = 405;
    public static final int CODE_ERROR_UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int CODE_ERROR_UNPROCESSABLE_ENTITY = 422;
    public static final int CODE_ERROR_RATE_LIMITED = 429;
    public static final int CODE_ERROR_SERVER_ERROR = 500;
    public static final int CODE_ERROR_SERVICE_UNAVAILABLE = 503;

    private String apiKey;
    private HttpURLConnection connection;

    private Request request;
    private Response response;
    private Exception exception;

    public RequestManager(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void execute() throws RiotApiException, IOException {
        String url = "https://" + request.getQuery() + "api_key=" + apiKey;

        try {
            URL obj;
            String response = "";
            int responseCode;
            JsonElement jsonx = null;

            obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            connection.setRequestMethod("GET");

            responseCode = connection.getResponseCode();

            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);

            if (responseCode == CODE_ERROR_RATE_LIMITED) {
                System.out.println("RATE LIMIT EXCEEDED - SLEEPING");

                if (connection.getHeaderField("Retry-After") != null) {
                    int retryAfter = Integer.parseInt(connection.getHeaderField("Retry-After"));
                    try {
                        Thread.sleep(retryAfter * 1000);
                    } catch (InterruptedException ex) {
                        Logger.
                                getLogger(RequestManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                execute();
                return;

            } else if (responseCode < 200 || responseCode >= 300) {
                System.out.println("BAM");
                throw new RiotApiException(responseCode);
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            String line;

            while ((line = in.readLine()) != null) {
                response += line;
            }
            in.close();

            this.response = new Response(responseCode, response, connection.getHeaderFields());

        } catch (IOException ex) {
            RiotApiException e = new RiotApiException(RiotApiException.IOEXCEPTION);
            setException(e);
            Api.log.log(Level.SEVERE, "[" + url + "] Request > IOException", e);
            throw e;
        } catch (RiotApiException ex) {
            setException(ex);
            System.out.println("Logging");
            Api.log.info("[" + url + "] Request > RiotApiException: " + ex.getMessage());
            throw ex;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    public Response getResponse() {
        return response;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

}
