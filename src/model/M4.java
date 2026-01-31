package model;

import enuns.FireMode;
import enuns.GunPowderType;
import interfaces.Fireable;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class M4 extends Gun implements Fireable {

    private Random random = new Random();
    private double currentHeat = 0;

    public M4() {
        this.capacity = 30;
        this.caliber = 5.56;
        LinkedList<Ammo> magazine = new LinkedList<>();
        magazine.addFirst(new Ammo("5.56x45mm NATO", 1479, GunPowderType.STANDARD));
        magazine.addFirst(new Ammo("5.56x45mm NATO", 1479, GunPowderType.HIGH_VELOCITY));
        magazine.addFirst(new Ammo("5.56x45mm NATO", 1479, GunPowderType.PLUS_P));
        this.loadedAmmo = magazine;
        this.baseJoules = 1479;
        this.fireModes = List.of(enuns.FireMode.SEMI_AUTOMATIC, enuns.FireMode.AUTOMATIC, enuns.FireMode.BURST);
        this.currentFireMode = FireMode.SEMI_AUTOMATIC;
    }

    public FireMode getCurrentFireMode() {
        return currentFireMode;
    }

    public int getMaxCapacity() {
        return capacity;
    }

    public int getCurrentAmmoCount() {
        return this.loadedAmmo.size();
    }

    @Override
    public double calculateMuzzleEnergy(Ammo bullet) {
        return bullet.getBaseJoules() * bullet.getGunPowderType().powerMultiplier;
    }

    @Override
    public void fire(FireMode mode) {
        if (loadedAmmo.isEmpty()) return;

        double distance = 400.0; // Seu alvo fixo
        double baseAccuracy = 0.85; // 85% de chance base de acerto da M4 a curta distância

        // Penalidades
        double spreadPenalty = calculateSpread(distance);
        double recoilPenalty = calculateRecoil(mode);

        // Chance final: Base - (Distância/1000) - (Recuo/10)
        double finalHitChance = baseAccuracy - (distance / 1000.0) - (recoilPenalty / 20.0);

        executeShot(finalHitChance);
    }

    private void executeShot(double hitChance) {
        Ammo bullet = ((LinkedList<Ammo>) loadedAmmo).poll();

        // Rola o "dado" (0.0 a 1.0)
        double roll = random.nextDouble();

        System.out.print("Alvo a 400m: ");
        if (roll <= hitChance) {
            System.out.println("🎯 IMPACTO! (Chance: " + String.format("%.2f", hitChance * 100) + "%)");
        } else {
            System.out.println("💨 ERROU! O tiro passou raspando.");
        }
    }

    @Override
    public void reload(Ammo bullet) {
        if (loadedAmmo.size() < capacity) {
            loadedAmmo.add(bullet);
        }
    }

    @Override
    public double calculateRecoil(FireMode mode) {
        return Fireable.super.calculateRecoil(mode);
    }

    @Override
    public double calculateSpread(double distance) {
        return Fireable.super.calculateSpread(distance);
    }
}