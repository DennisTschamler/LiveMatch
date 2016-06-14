/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Dennis
 */
public class RequestResponse {
    private int code;
    private String body;
    private Map<String, List<String>> headerFields;

    public RequestResponse(int code, String body, Map<String, List<String>> headerFields) {
        this.code = code;
        this.body = body;
        this.headerFields = headerFields;
    }

    public int getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

    public Map<String, List<String>> getHeaderFields() {
        return headerFields;
    }
    
    
}
