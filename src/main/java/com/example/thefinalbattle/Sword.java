package com.example.thefinalbattle;

public class Sword {
    protected int accuracy;
    protected int damage;

    public Sword(int accuracy, int damage) {
        this.accuracy = accuracy;
        this.damage = damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getDamage() {
        return damage;
    }
}
