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
public class RateLimit {
    
    int countSeconds = 0;
    int limitSeconds = 1;
    
    int countMinutes = 0;
    int limitMinutes = 1;
    
    public RateLimit(String rateLimit) {
        if(rateLimit != null)
            parse(rateLimit);
    }
    
    private void parse(String rateLimit) {
        String[] rates = rateLimit.split(",");
        
        String[] seconds = rates[0].split(":");
        String[] minutes = rates[1].split(":");
        
        countSeconds = Integer.valueOf(seconds[0]);
        limitSeconds = Integer.valueOf(seconds[1]);
        
        countMinutes = Integer.valueOf(minutes[0]);
        limitMinutes = Integer.valueOf(minutes[1]);
        
        System.out.println(rateLimit);
        
        System.out.println(countSeconds+":"+limitSeconds+","+countMinutes+":"+limitMinutes);
    }
    
    public boolean isSecondsLimitExceeded() {
        return countSeconds >= limitSeconds;
    }
    
    public boolean isMinutesLimitExceeded() {
        return countMinutes >= limitMinutes;
    }
}
