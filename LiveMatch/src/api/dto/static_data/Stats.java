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
public class Stats {

    private double armor;
    private double armorperlevel;
    private double attackdamage;
    private double attackdamageperlevel;
    private double attackrange;
    private double attackspeedoffset;
    private double attackspeedperlevel;
    private double crit;
    private double critperlevel;
    private double hp;
    private double hpperlevel;
    private double hpregen;
    private double hpregenperlevel;
    private double movespeed;
    private double mp;
    private double mpperlevel;
    private double mpregen;
    private double mpregenperlevel;
    private double spellblock;
    private double spellblockperlevel;

    public double getArmor() {
        return armor;
    }

    public double getArmorPerLevel() {
        return armorperlevel;
    }

    public double getAttackDamage() {
        return attackdamage;
    }

    public double getAttackDamagePerLevel() {
        return attackdamageperlevel;
    }

    public double getAttackRange() {
        return attackrange;
    }

    public double getAttackSpeedOffset() {
        return attackspeedoffset;
    }

    public double getAttackSpeedPerLevel() {
        return attackspeedperlevel;
    }

    public double getBaseAttackSpeed() {
        return (0.625 / (1.0 + attackspeedoffset));
    }

    public double getCrit() {
        return crit;
    }

    public double getCritPerLevel() {
        return critperlevel;
    }

    public double getHp() {
        return hp;
    }

    public double getHpPerLevel() {
        return hpperlevel;
    }

    public double getHpRegen() {
        return hpregen;
    }

    public double getHpRegenPerLevel() {
        return hpregenperlevel;
    }

    public double getMoveSpeed() {
        return movespeed;
    }

    public double getMp() {
        return mp;
    }

    public double getMpPerLevel() {
        return mpperlevel;
    }

    public double getMpRegen() {
        return mpregen;
    }

    public double getMpRegenPerLevel() {
        return mpregenperlevel;
    }

    public double getSpellBlock() {
        return spellblock;
    }

    public double getSpellBlockPerLevel() {
        return spellblockperlevel;
    }
}
