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

