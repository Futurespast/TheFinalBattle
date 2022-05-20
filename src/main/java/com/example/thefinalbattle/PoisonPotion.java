package com.example.thefinalbattle;

public class PoisonPotion implements Item{
    ItemType type = ItemType.PoisonPotion;

    protected int value;
    protected String name;
    public PoisonPotion(int value){
        this.value=value;
        this.name="Poison "+value+" damage per turn";
    }
    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void use(Character character) {
        character.poisonValue=value;
        character.poisoned=true;
        character.poisonCounter=0;
    }

    public String getName() {
        return name;
    }

    @Override
    public ItemType getType() {
        return type;
    }
}
