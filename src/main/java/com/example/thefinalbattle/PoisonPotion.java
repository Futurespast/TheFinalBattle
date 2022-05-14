package com.example.thefinalbattle;

public class PoisonPotion implements Item{
    protected int value;

    public PoisonPotion(int value){
        this.value=value;
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
}
