package com.example.thefinalbattle;

public class HealingPotion implements Item{
    protected int value;
    public HealingPotion(int value){
        this.value=value;
    }
    @Override
    public int getValue() {
        return value;
    }

    public void use( Character character) {
        character.health+=value;
    }
}
