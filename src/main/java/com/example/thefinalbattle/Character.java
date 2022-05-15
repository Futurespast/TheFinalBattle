package com.example.thefinalbattle;

public abstract class Character {
    protected String name;
    protected int health;
    protected int blindCounter;
    protected int poisonCounter;
    protected boolean blinded =false;
    protected boolean poisoned =false;
    protected int poisonValue;
    protected int blindValue;
    protected boolean Dead=false;

    public boolean isDead(){
        if(health<=0){
            return true;
        }
        return false;
    }

    //gets name of the character
    public String getName() {
        return name;
    }

    //gets the current health of the character
    public int getHealth() {
        return health;
    }

    //checks to see if character is poisoned
    public boolean isPoisoned() {
        if(poisoned==true && poisonCounter<5){
            return true;
        }
        if (poisoned==true && poisonCounter>=5){
            poisoned=false;
            poisonCounter=0;
            return false;
        }
        return false;
    }

    //checks to see if the character is blind
    public boolean isBlind(){
        if(blinded==true && blindCounter<=blindValue){
            return true;
        }
        if (blinded==true && blindCounter>blindValue){
            blinded=false;
            blindCounter=0;
            return false;
        }
        return false;
    }

    //this method allows the character to attack
    public int attack(int damage, int accuracy) {
        if (isBlind()){
            blindCounter++;
            return 0;
        }
        int temp = (int) (Math.random() * 10);
        if (temp <= accuracy && accuracy != 0) {
            return damage;
        } else {
            return 0;
        }
    }

    public int getPoisonValue() {
        return poisonValue;
    }

    //this method allows the character to receive damage
    public boolean takeDamage(int attack){
        health-=attack;
        if(isPoisoned()){
            health-=poisonValue;
            poisonCounter++;
        }
       return isDead();
    }


}
