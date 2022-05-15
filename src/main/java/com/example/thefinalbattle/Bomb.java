package com.example.thefinalbattle;

public class Bomb implements Item {
    protected int value;
    protected String name;
    public Bomb(int value) {
        this.value = value;
        this.name="Bomb (does "+value+" damage)";
    }

    public String getName() {
        return name;
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
