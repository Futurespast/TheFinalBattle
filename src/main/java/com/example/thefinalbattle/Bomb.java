package com.example.thefinalbattle;

public class Bomb implements Item {
    protected int value;

    public Bomb(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void use(Character character) {
      character.health-=value;
    }
}
