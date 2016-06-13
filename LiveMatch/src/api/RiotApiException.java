/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

/**
 *
 * @author Dennis
 */
public class RiotApiException extends Exception {

    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int DATA_NOT_FOUND = 404;
    public static final int METHOD_NOT_ALLOWED = 405;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final int UNPROCESSABLE_ENTITY = 422;
    public static final int RATE_LIMITED = 429;
    public static final int SERVER_ERROR = 500;
    public static final int UNAVAILABLE = 503;
    public static final int PARSE_FAILURE = 600;
    public static final int IOEXCEPTION = 601;
    public static final int NULLPOINTEREXCEPTION = 602;
    public static final int TIMEOUT_EXCEPTION = 603;

    private final int errorCode;

    public RiotApiException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public RiotApiException(int errorCode) {
        this(errorCode, getMessage(errorCode));
    }
    
    public int getErrorCode() {
        return errorCode;
    }

    public static String getMessage(final int errorCode) {
        switch (errorCode) {
            case BAD_REQUEST:
                return "Bad request";
            case FORBIDDEN:
                return "Forbidden";
            case DATA_NOT_FOUND:
                return "Requested data not found";
            case IOEXCEPTION:
                return "I/O Exception thrown";
            case METHOD_NOT_ALLOWED:
                return "Method not allowed";
            case NULLPOINTEREXCEPTION:
                return "NullPointerException thrown";
            case PARSE_FAILURE:
                return "Failed to parse the JSON response";
            case UNPROCESSABLE_ENTITY:
                return "Summoner has an entry, but hasn't played since the start of 2013";
            case UNSUPPORTED_MEDIA_TYPE:
                return "Unsupported media type";
            case RATE_LIMITED:
                return "Rate limit exceeded";
            case SERVER_ERROR:
                return "Internal server error";
            case TIMEOUT_EXCEPTION:
                return "Request timed out";
            case UNAUTHORIZED:
                return "Unauthorized";
            case UNAVAILABLE:
                return "Service unavailable";
            default:
                return "Unknown API error (Code " + errorCode + ")";
        }
    }
}
