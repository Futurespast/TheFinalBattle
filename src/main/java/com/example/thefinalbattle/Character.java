package com.example.thefinalbattle;

public abstract class Character {
    protected String name;
    protected int health;
    protected int blindCounter;
    protected int poisonCounter;
    protected boolean blinded =false;
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }
    public boolean isBlind(){
        if(blinded==true && blindCounter<=5){
            return true;
        }
        if (blinded==true && blindCounter>5){
            blinded=false;
            blindCounter=0;
            return false;
        }
        return false;
    }
    public int attack(int damage, int accuracy) {
        if (isBlind()){
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
