/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.constants;

/**
 *
 * @author Dennis
 */
public enum GameSubType {

    NONE("NONE"),
    NORMAL("NORMAL"),
    BOT("BOT"),
    RANKED_SOLO_5x5("RANKED_SOLO_5x5"),
    RANKED_PREMADE_3x3("RANKED_PREMADE_3x3"),
    RANKED_PREMADE_5x5("RANKED_PREMADE_5x5"),
    ODIN_UNRANKED("ODIN_UNRANKED"),
    RANKED_TEAM_3x3("RANKED_TEAM_3x3"),
    RANKED_TEAM_5x5("RANKED_TEAM_5x5"),
    NORMAL_3x3("NORMAL_3x3"),
    BOT_3x3("BOT_3x3"),
    CAP_5x5("CAP_5x5"),
    ARAM_UNRANKED_5x5("ARAM_UNRANKED_5x5"),
    ONEFORALL_5x5("ONEFORALL_5x5"),
    FIRSTBLOOD_1x1("FIRSTBLOOD_1x1"),
    FIRSTBLOOD_2x2("FIRSTBLOOD_2x2"),
    SR_6x6("SR_6x6"),
    URF("URF"),
    URF_BOT("URF_BOT"),
    NIGHTMARE_BOT("NIGHTMARE_BOT"),
    ASCENSION("ASCENSION"),
    HEXAKILL("HEXAKILL"),
    KING_PORO("KING_PORO"),
    COUNTER_PICK("COUNTER_PICK"),
    BILGEWATER("BILGEWATER");

    private String name;

    private GameSubType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
