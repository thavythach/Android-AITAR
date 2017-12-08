package com.vuforia.samples.VuforiaSamples.data;

/**
 * Created by Steven Ye on 12/6/2017.
 */

public class Player {

    private String uid;
    private String vuMark;
    private float health;
    private int ammunition;

    public Player(String uid, String vuMark) {
        this.uid = uid;
        this.vuMark = vuMark;
        this.health = 1;
        this.ammunition = 100;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public String getVuMark() {
        return vuMark;
    }

    public void setVuMark(String vuMark) {
        this.vuMark = vuMark;
    }
}
