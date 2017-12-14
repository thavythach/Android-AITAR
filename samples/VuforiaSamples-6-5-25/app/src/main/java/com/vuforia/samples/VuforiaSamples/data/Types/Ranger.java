package com.vuforia.samples.VuforiaSamples.data.Types;

import com.vuforia.samples.VuforiaSamples.data.Player;

/**
 * Created by Thavy Thach on 12/11/2017.
 */

public class Ranger extends Player {

    public static final int MIN_ATTACK_DAMAGE = 0;
    public static final int MAX_ATTACK_DAMAGE = 23;
    private static final int CLASS_TYPE = 1;

    public Ranger(String name){
        super(name, MIN_ATTACK_DAMAGE, MAX_ATTACK_DAMAGE, CLASS_TYPE);
    }
}
