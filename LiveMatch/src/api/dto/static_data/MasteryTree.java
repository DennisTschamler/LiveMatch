/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.static_data;

import java.util.List;

/**
 *
 * @author Dennis
 */
public class MasteryTree {

    private List<MasteryTreeList> Cunning;
    private List<MasteryTreeList> Ferocity;
    private List<MasteryTreeList> Resolve;

    public List<MasteryTreeList> getCunning() {
        return Cunning;
    }

    public List<MasteryTreeList> getFerocity() {
        return Ferocity;
    }

    public List<MasteryTreeList> getResolve() {
        return Resolve;
    }
}
