/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.dennistschamler.riotapi.api.utils;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class TextUtils {

    public static <T> String seperateListByComma(List<T> list) {
        String text = "";

        for (int i = 0; i < list.size(); i++) {
            text += list.get(i);

            if (i != (list.size() - 1)) {
                text += ",";
            }
        }

        return text;
    }
    
    public static String normalizeSummonerName(String name) {
        name.replaceAll("%20", "");
        return name.toLowerCase();
    }
}
