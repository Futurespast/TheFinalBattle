# TheFinalBattle
This is a short text based rpg game developped completely in Java and Javafx <br>

I actually faced a massive challange of figuring out how to handle the logic of the game and also just making the GUI for this game which is embarrassing since this is  mostly text based. I hope to add actual settings like sound and window resizing, as well as just making the game longer.  

The following is the UML diagram for the game.
![UMLJava (1)](https://user-images.githubusercontent.com/104465572/169670019-b634d7a9-9596-441d-88d5-792404a688ed.png)

Character class:<br>
This is the super class that both the enemy and player class inherit from. <br>
The following is it's methods with an explanation of it's purpose (not including getters and setters).<br>
public boolean isBlind() <br>
checks to see if character is blind and returns a true or false depending on if they are blind <br>
public boolean isPoisoned() <br>
checks to see if character is poisoned and returns a true or false depending on if they are poisoned. <br>
public int attack(int damage, int accuracy) <br>
takes an int for damage and accuracy and then attacks by doing the following steps. 1. checks is the attacker is blind, if yes then returns 0 damage. 
2. get a random number between 0 and 10 and then if the random number is less than the accuracy it retuns the damage, if not then it returns 0. <br>
 public int takeDamage(int attack) <br>
 this takes a damage integer and then minus the health from it. It also checks to see if the character is poisoned and then minus the health based off the poison value
 of the poison and then add one to the poison counter. <br>
<br>
Enemy class: <br>
The enemy is a super class in which all enemy types inherit from. <br>
The enemy just has a constructor and a abstract attack method. <br>
<br>
Zombie Class: <br>
has an attack method that's the same as character.<br>
<br>
Vampire class: <br>
Has the same attack method except it has a chance to heal itself when it attacks <br>
<br>
Witch class: <br>
Has the same attack method except it has a chance to blind and poison the player when it attacks <br>
<br>
Boss class: <br>
has the same attack method except it has a chance to heal itself and blind and poison the player when it attacks <br>
<br>
Player class <br>
public void removeItem(int index) <br>
This method removes an item from the arraylist at a specified index. <br>
public boolean isMaxInventorySize() <br>
This method checks if the player has reached it's max inventory size. <br>
 public boolean addItem(Item item) <br>
This method will try to add an item to the arraylist but if it is at max invetory size it will not add the item and return false. <br>
 public void useItem(int index, Character character) <br>
 This method takes the index of the item it wants to use and the character it wants to use the item on. <br>
 <br>
Item interface: <br>
This is an interface used by every item. <br>
public void use(Character character) <br>
Method to use the item. <br>
public ItemType getType(); <br>
Method to get the type of item. <br>
<br>
Itemtype enum: <br>
Basically has every item type: Bomb,FlashBomb, HealingPotion,PoisonPotion <br>
<br>
Bomb class: <br>
public void use(Character character) <br>
When you use it it removes the characters health based on the bombs value <br>
<br>
FlashBomb class: <br>
public void use(Character character) <br>
Sets the character's blind value to the flash's value, also sets the character as blinded and set's the characters blind count to zero. <br>
<br>
PoisonPotion class: <br>
The same as flash bomb except for poison <br>
<br>
HealingPotion class: <br>
public void use(Character character) <br>
the character's health increases by the healing potions value. 
<br>
Sword class: <br>
Just has a constructor that set's the swords damage and accuracy. Plus getters and Setters <br>
<br>
HelloController.java <br>
The helloController contains probably the most important methods of the entire project. <br>
public void UpdatePlayerHealth() <br>
Updates the label that shows the players health.<br>
public void Scene1(ActionEvent actionEvent) - Scene12 <br>
Just the scenes of the game, it's how most of the game logic is handled. <br>
public void Gameover() <br>
Tells the player they are dead and closes the game <br>
public String PlayerBlindMessage(Player player) <br>
Tells the player that they are blind and for how long <br>
public String PlayerPoisonedMessage(Player player) <br>
The same thing except with poison <br>
public String EnemyBlindMessage(Enemy enemy) and public String EnemyPoisonedMessage(Enemy enemy) <br>
The same thing except for the enemy.<br>
public void CombatSequence(Player player, Enemy enemy) <br>
This is the sequence of what happens when the player clicks the attack button. First the enemy takes damage and then the player takes damage. It then changes the text label to show what happened and also updates both the enemy health label and player label. <br>
public void UseItems(Player player, Enemy enemy) <br>
This was by far the most complicated to make, it first checks if the playes has items. If they don't then it tells them they have no items to use and returns. If they do have an item it then makes a button for each item. Then if you click on it, it check to see if it's a healing potion using the enum. If it's a healing potion then it takes the player as the recepient and updates the players health label. If it isn't the healing potion then it take the enemy as the recepient and then updates the enemy's health label. <br>
<br>
The following are screenshots of the game: <br>
![image](https://user-images.githubusercontent.com/104465572/169671775-51cc0174-ed2f-420f-aeed-594fad9765d9.png) 
Main Menu <br>
![image](https://user-images.githubusercontent.com/104465572/169671790-517bd99b-0c02-41aa-aeee-57e63f1d6907.png)
Settings (Which doesn't have anything to set) <br>
![image](https://user-images.githubusercontent.com/104465572/169671810-5e53ad84-32cf-44b8-a5b1-d10cebe65a38.png) <br>
GamePlay <br>
![image](https://user-images.githubusercontent.com/104465572/169671837-affddc80-ce34-4bff-8ac3-e396837768d0.png) <br>
Example of a decision <br>
![image](https://user-images.githubusercontent.com/104465572/169671869-5fa9fccb-eacc-49cc-824c-82c11367ec7d.png) <br>
Combat Sequence <br>
![image](https://user-images.githubusercontent.com/104465572/169671883-4485d7b2-c892-4e5f-9a60-b0dbb5604767.png) <br>
Item Selection <br>
![image](https://user-images.githubusercontent.com/104465572/169672068-a7ceea6d-5b72-4386-9d73-3ee6f761478c.png) <br>
Gameover <br>
![image](https://user-images.githubusercontent.com/104465572/169672105-ecfca828-dc7d-4a68-af40-879d3684dd0c.png) <br>
Victory <br>





