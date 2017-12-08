package com.vuforia.samples.VuforiaSamples.data;

/**
 * Created by Steven Ye on 12/7/2017.
 */

public class User {

    private String uid;
    private String name;
    private int kills;
    private int deaths;

    public User(String uid, String name) {
        this.uid = uid;
        this.name = name;
        this.kills = 0;
        this.deaths = 0;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }
}
