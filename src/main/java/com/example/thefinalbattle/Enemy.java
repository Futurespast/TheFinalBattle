package com.example.thefinalbattle;

public abstract class Enemy extends Character {
    protected int damage;
    protected int accuracy;
    public Enemy(String name,int health, int damage, int accuracy ){
        this.name=name;
        this.health=health;
        this.damage=damage;
        this.accuracy=accuracy;}

    abstract public int attack(int damage, int accuracy, Character character );

}
