package model;

import enuns.FireMode;

import java.util.List;

public class Gun {
    protected int capacity;
    protected double caliber;
    protected List<Ammo> loadedAmmo;
    protected double baseJoules;
    protected List<FireMode> fireModes;
    protected FireMode currentFireMode;

    public void cycleFireMode() {
        int currentIndex = fireModes.indexOf(currentFireMode);
        int nextIndex = (currentIndex + 1) % fireModes.size();
        currentFireMode = fireModes.get(nextIndex);
    }

    public int getCapacity() {
        return loadedAmmo.size();
    }
}