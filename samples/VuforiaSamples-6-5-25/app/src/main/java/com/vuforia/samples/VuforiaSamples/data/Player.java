package com.vuforia.samples.VuforiaSamples.data;

/**
 * Created by Steven Ye on 12/6/2017.
 */

public class Player {

    public static final int MAX_HEALTH = 100;
    public static final int ATTACK_DAMAGE = 5;

    private String name;
    private int health;

    public Player() {}

    public Player(String name) {
        this.name = name;
        this.health = MAX_HEALTH;
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
}
