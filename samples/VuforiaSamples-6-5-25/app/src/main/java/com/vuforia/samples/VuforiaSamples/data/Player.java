package com.vuforia.samples.VuforiaSamples.data;

import com.vuforia.samples.VuforiaSamples.R;

/**
 * Created by Steven Ye on 12/6/2017.
 */

public class Player {

    public static final int MAX_HEALTH = 100;

    public static final int TYPE_MAGE = 0;
    public static final int TYPE_RANGER = 1;
    public static final int TYPE_WARRIOR = 2;

    private String name;
    private int health;
    private boolean alive;
    private int type;

    private int minAttackDamage;
    private int maxAttackDamage;

    public Player() {}

    public String getStringType(){
        String type;
        switch (this.type){
            case 0:
                type = "Mage";
                break;
            case 1:
                type = "Ranger";
                break;
            default:
                type = "Warrior";
                break;
        }
        return type;
    }

    public int getDrawableWeapon(){
        int type;
        switch (this.type){
            case 0:
                type = R.drawable.mage_weapon;
                break;
            case 1:
                type = R.drawable.ranger_weapon;
                break;
            default:
                type = R.drawable.warrior_weapon;
                break;
        }
        return type;
    }

    public int getDrawableWeaponIcon(){
        int type;
        switch (this.type){
            case 0:
                type = R.drawable.mage_icon;
                break;
            case 1:
                type = R.drawable.ranger_icon;
                break;
            default:
                type = R.drawable.warrior_icon;
                break;
        }
        return type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Player(String name, int health, boolean alive, int minAttackDamage, int maxAttackDamage, int type){
        this.name = name;
        this.health = health;
        this.alive = alive;
        this.minAttackDamage = minAttackDamage;
        this.maxAttackDamage = maxAttackDamage;
        this.type = type;
    }

    public Player(String name, int minAttackDamage, int maxAttackDamage, int type){
        this(name, MAX_HEALTH, true, minAttackDamage, maxAttackDamage, type);
    }

    public Player(String name){
        this(name, MAX_HEALTH, true, 0, 5, TYPE_WARRIOR);
    }

    public int getMinAttackDamage() {
        return minAttackDamage;
    }

    public void setMinAttackDamage(int minAttackDamage) {
        this.minAttackDamage = minAttackDamage;
    }

    public int getMaxAttackDamage() {
        return maxAttackDamage;
    }

    public void setMaxAttackDamage(int maxAttackDamage) {
        this.maxAttackDamage = maxAttackDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
