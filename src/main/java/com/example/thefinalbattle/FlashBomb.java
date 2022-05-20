package com.example.thefinalbattle;

public class FlashBomb implements Item{
    ItemType type = ItemType.FlashBomb;
    protected int value;
    protected String name;
    public FlashBomb(int value){
        this.value=value;
        this.name="Flash Bomb (Blinds for "+value+" turns";
    }
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

    public String getName() {
        return name;
    }
    @Override
    public ItemType getType() {
        return type;
    }

}
