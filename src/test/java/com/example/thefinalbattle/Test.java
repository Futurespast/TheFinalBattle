package com.example.thefinalbattle;
import static org.junit.jupiter.api.Assertions.*;


public class Test {
    @org.junit.jupiter.api.Test
    public void
    PlayerConstructorTest(){
         Player player = new Player("Sam",100);
         Sword sword = new Sword(90,30);
         player.setSword(sword);
         Bomb bomb = new Bomb(30);
         player.addItem(bomb);
         assertEquals(sword,player.getSword());
         assertEquals("Sam",player.getName());
         assertEquals(100,player.getHealth());
        assertEquals(bomb,player.Items.get(0));
    }


@org.junit.jupiter.api.Test
public void
    MaxInventoryTest(){
    Player player = new Player("Sam",100);
    Bomb bomb = new Bomb(30);
    HealingPotion heal = new HealingPotion(50);
    FlashBomb flash = new FlashBomb(5);
    player.addItem(bomb);
    player.addItem(heal);
    player.addItem(flash);
    PoisonPotion poison = new PoisonPotion(5);
    player.addItem(poison);
    assertEquals(poison,player.Items.get(2));
}

    @org.junit.jupiter.api.Test
    public void
    BossConstructor(){
        Boss boss = new Boss("Java",200,30,70);
        assertEquals(200,boss.getHealth());
        assertEquals("Java",boss.getName());
        assertEquals(30,boss.damage);
        assertEquals(70,boss.accuracy);
    }
    @org.junit.jupiter.api.Test
    public void
    PlayerAttackAndBossTakeDamageAndItemUseTest() {
        Player player = new Player("Sam", 100);
        Sword sword = new Sword(100, 30);
        player.setSword(sword);
        Bomb bomb = new Bomb(30);
        player.addItem(bomb);
        Boss boss = new Boss("Java", 200, 30, 100);
        player.useItem(0, boss);
        assertEquals(170, boss.health);
        PoisonPotion poison = new PoisonPotion(5);
        player.addItem(poison);
        player.useItem(0, boss);
        assertEquals(true, boss.poisoned);
        assertEquals(170, boss.health);
        boss.takeDamage(player.attack(sword.damage, sword.accuracy));
        assertEquals(135, boss.health);
        Sword sword2 = new Sword(0, 30);
        boss.takeDamage(player.attack(sword2.damage, sword2.accuracy));
        assertEquals(130, boss.health);
        player.takeDamage(boss.attack(boss.damage, boss.accuracy));
        assertEquals(70, player.health);
        HealingPotion heal = new HealingPotion(30);
        player.addItem(heal);
        player.useItem(0, player);
        assertEquals(100, player.health);
    }

// This test might get marked as fail but that's because the boss can give the player poison damage not the blind actually failing
        @org.junit.jupiter.api.Test
                public void
                BlindTest(){
            Player player = new Player("Sam", 100);
            Boss boss = new Boss("Java", 200, 30, 100);
            FlashBomb flashBomb = new FlashBomb(5);
            player.addItem(flashBomb);
            player.useItem(0,boss);
            int count=0;
            while (count<=6){
                player.takeDamage(boss.attack(boss.damage, boss.accuracy));
                count++;
            }
            assertEquals(70,player.health);
            assertEquals(false,boss.blinded);

        }
        @org.junit.jupiter.api.Test
          public void
    PoisonTest(){
            Player player = new Player("Sam", 100);
            Boss boss = new Boss("Java", 200, 30, 100);
            PoisonPotion poisonPotion = new PoisonPotion(10);
            player.addItem(poisonPotion);
            player.useItem(0,boss);
            int count = 0;
            while (count<=6) {
                boss.takeDamage(0);
                count++;
            }
            assertEquals(150,boss.health);
        }
    }

