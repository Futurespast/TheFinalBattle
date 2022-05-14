package com.example.thefinalbattle;

public class Vampire extends Enemy{
    public Vampire(String name, int health, int damage, int accuracy) {
        super(name, health, damage, accuracy);
    }

    @Override
    public int attack(int damage, int accuracy, Character character) {
        int healchance = (int) (Math.random() * 10);
        if (healchance > 5){
            health+=10;
        }
        int temp = (int) (Math.random() * 10);
        if (temp <= accuracy) {
            return damage;
        } else {
            return 0;
        }
    }
}
