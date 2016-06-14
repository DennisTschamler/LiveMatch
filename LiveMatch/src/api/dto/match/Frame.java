/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.match;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Dennis
 */
public class Frame {
    private ArrayList<Event> events;
    private Map<String, ParticipantFrame> participantFrames;
    private long timeStamp;
}
