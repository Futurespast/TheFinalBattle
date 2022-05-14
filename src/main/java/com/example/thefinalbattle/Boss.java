package com.example.thefinalbattle;

public class Boss extends Enemy{
    public Boss(String name, int health, int damage, int accuracy) {
        super(name, health, damage, accuracy);
    }

    @Override
    public int attack(int damage, int accuracy, Character character ) {
        int healchance = (int) (Math.random() * 10);
        if (healchance > 5){
            health+=10;
        }
        int poisonchance = (int) (Math.random() * 10);
        if (poisonchance > 8){
           character.poisoned=true;
           character.poisonValue=5;
        }
        int blindchance = (int) (Math.random() * 10);
        if (blindchance > 8){
            character.blinded=true;
            character.blindValue=5;
        }
        if (isBlind()){
            blindCounter++;
            return 0;
        }
        int temp = (int) (Math.random() * 10);
        if (temp <= accuracy) {
            return damage;
        } else {
            return 0;
        }
    }

}
