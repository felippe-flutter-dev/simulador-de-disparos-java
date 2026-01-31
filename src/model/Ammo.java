package model;

import enuns.GunPowderType;

public class Ammo {
    protected String caliber;
    protected double baseJoules;
    protected GunPowderType gunPowderType;

    public Ammo(String caliber, double baseJoules, GunPowderType gunPowderType) {
        this.caliber = caliber;
        this.baseJoules = baseJoules;
        this.gunPowderType = gunPowderType;
    }

    public String getCaliber() {
        return caliber;
    }

    public double getBaseJoules() {
        return baseJoules;
    }


    public GunPowderType getGunPowderType() {
        return gunPowderType;
    }
}
