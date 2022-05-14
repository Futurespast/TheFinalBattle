package com.example.thefinalbattle;

public class Zombie extends Enemy {
    public Zombie(String name, int health, int damage, int accuracy) {
        super(name, health, damage, accuracy);
    }

    @Override
    public int attack(int damage, int accuracy, Character character) {
        int temp = (int) (Math.random() * 10);
        if (temp <= accuracy) {
            return damage;
        } else {
            return 0;
        }
    }

    }
