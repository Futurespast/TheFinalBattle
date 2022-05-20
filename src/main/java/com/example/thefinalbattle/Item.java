package com.example.thefinalbattle;

public interface Item {
    public int getValue();
    public String getName();
    public void use(Character character);
    public ItemType getType();
}
