package com.example.thefinalbattle;

public class HealingPotion implements Item{
    protected int value;
    protected String name;
    public HealingPotion(int value){
        this.value=value;
        this.name="Healing potion (heals "+value+" health)";
    }
    @Override
    public int getValue() {
        return value;
    }

    public void use( Character character) {
        character.health+=value;
    }

    public String getName() {
        return name;
    }
}
