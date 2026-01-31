package interfaces;

import enuns.FireMode;
import model.Ammo;

public interface Fireable {

    double calculateMuzzleEnergy(Ammo bullet);

    void fire(FireMode mode);

    void reload(Ammo bullet);

    default double calculateRecoil(FireMode mode) {
        return switch (mode) {
            case SEMI_AUTOMATIC -> 1.2;
            case BURST -> 3.5;
            case AUTOMATIC -> 8.0; // Automático gera muito mais recuo
        };
    }

    default double calculateSpread(double distance) {
        // Quanto maior a distância, maior a área de dispersão (MOA)
        return (distance / 100.0) * 0.5;
    }
}