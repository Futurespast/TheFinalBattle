package com.example.thefinalbattle;

public class FlashBomb implements Item{
    protected int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void use(Character character) {
        character.blindValue=value;
        character.blinded=true;
        character.blindCounter=0;
    }
}
