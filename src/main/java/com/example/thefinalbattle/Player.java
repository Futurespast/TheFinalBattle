package com.example.thefinalbattle;

import java.util.ArrayList;

public class Player extends Character {
protected ArrayList<Item> items = new ArrayList<>(3);
protected Sword sword;
public Player(String name,int health) {
    this.health = health;
    this.name=name;
}
    public void setSword(Sword sword){
        this.sword=sword;
    }

    public Sword getSword() {
        return sword;
    }


    public void removeItem(int index){
        items.remove(index);
    }
    public boolean isMaxInventorySize(){
    if (items.size()==3){
        return true;
    }
    return false;
    }


    // THIS IS ONLY TEMPORARY, ONCE I START IMPLEMENTING JAVAFX I WILL CHANGE THIS OR MOVE THIS TO MAIN
    // AS OF NOW, THE USER IS NOT BEING TAKEN INTO CONSIDERATION IF THE CAPACITY IS FULL
    public boolean addItem(Item item){
        if (isMaxInventorySize()){
            return false;
        }
        items.add(item);

        return true;
    }
   public void useItem(int index, Character character){
    items.get(index).use(character);
    items.remove(index);
   }

}

