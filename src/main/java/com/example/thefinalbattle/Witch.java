package com.example.thefinalbattle;

public class Witch extends Enemy {
    public Witch(String name, int health, int damage, int accuracy) {
        super(name, health, damage, accuracy);
    }

    @Override
    public int attack(int damage, int accuracy, Character character) {
        int poisonchance = (int) (Math.random() * 10);
        if (poisonchance > 8){
            character.poisoned=true;
            character.poisonValue=5;
        }
        int blindchance = (int) (Math.random() * 10);
        if (blindchance > 8){
            character.blinded=true;
            character.blindValue=5;
        }
        int temp = (int) (Math.random() * 10);
        if (temp <= accuracy) {
            return damage;
        } else {
            return 0;
        }
    }
    }

