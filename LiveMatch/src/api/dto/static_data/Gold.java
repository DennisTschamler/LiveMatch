/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api.dto.static_data;

/**
 *
 * @author Dennis
 */
public class Gold {

    private int base;
    private boolean purchasable;
    private int sell;
    private int total;

    public int getBase() {
        return base;
    }

    public int getSell() {
        return sell;
    }

    public int getTotal() {
        return total;
    }

    public boolean isPurchasable() {
        return purchasable;
    }
}
