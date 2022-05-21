package com.example.thefinalbattle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Optional;

public class HelloController {

    public Label text;
    public Pane gameplay;
    public TextInputDialog setname = new TextInputDialog();
    public Label levellabel;
    public Label playerhealth;
    public Label enemyhealth;
    public HBox decisions;
    public Button cont;
    Button attack;
    Button useItems;

    Player player;
    
    //updates the label for the players health
    public void UpdatePlayerHealth(){
        playerhealth.setText(setname.getEditor().getText() + "'s health: " + player.health);
    }
    public void Scene1(ActionEvent actionEvent) {
        setname.setHeaderText("enter a name for your character");
        setname.showAndWait();
        player = new Player(setname.getEditor().getText(), 100);
        UpdatePlayerHealth();
        text.setWrapText(true);
        text.setText(player.name + " heard a rumor from the local village of a lair filled with evil."
               + " The villagers were suffering from the evil. Against the warning of the villagers, " + player.name + " set out to vanquish the evil that lurked there.");
        
        // SCENE 1 DONE

        cont.setOnAction(actionEvent1 ->{
            Scene2();
        });
       }

    private void Scene2() {
        text.setText("The outside screams danger, it looks like an abandoned castle. The area seems devoid of life. The cold wind is harsh and you feel a shiver running down your spine." +
                " Every fiber of your body is telling you to turn back but you stay strong and move to enter the castle. Then suddenly...");
        
        cont.setOnAction(actionEvent2 -> {
            Scene3();
        });
    }

    private void Scene3(){
           text.setText("A zombie burst out from the entrance!Pick which sword you want: Sword 1 damage:50 accuracy:50%, Sword 2: damage:30 accuracy:90%, Sword 3: damage 100 accuracy 10% ");
           Zombie zombie = new Zombie("zombie",50,10,4);
           enemyhealth.setText(zombie.name+"'s health: "+zombie.health);
           Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
           alert.setTitle("Pick a Sword!");
           alert.setHeaderText("Which Sword will you pick?");
           alert.setContentText("Choose your option.");

           ButtonType buttonTypeOne = new ButtonType("One");
           ButtonType buttonTypeTwo = new ButtonType("Two");
           ButtonType buttonTypeThree = new ButtonType("Three");

           alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeThree);

           Optional<ButtonType> result = alert.showAndWait();
           if (result.get() == buttonTypeOne){
               Sword sword1 = new Sword(5,50);
               player.setSword(sword1);
           } else if (result.get() == buttonTypeTwo) {
               Sword sword2 = new Sword(9,30);
               player.setSword(sword2);
           } else if (result.get() == buttonTypeThree) {
               Sword sword3 = new Sword(1,100);
               player.setSword(sword3);
           }

            attack = new Button("Attack");
            useItems = new Button("Use Item");
            decisions.getChildren().add(attack);
            decisions.getChildren().add(useItems);
            CombatSequence(player, zombie);
            UseItems(player, zombie);


        cont.setOnAction(event -> {
            if (zombie.isDead()) {
                enemyhealth.setText("No Enemy");
                decisions.getChildren().remove(attack);
                Scene4();
            }
            else{
                Alert zombieAlive = new Alert(Alert.AlertType.ERROR);
                zombieAlive.setContentText("Hey! The zombie is still alive, you can't run from him.");
                zombieAlive.showAndWait();
            }
        });
       }
       
       private void Scene4(){
            text.setText("You defeated the zombie! Good job. You enter the fortress, and find a chest with a healing potion inside. You decide to take it and put it into your backpack.");
            player.items.add(new HealingPotion(30));

            cont.setOnAction(event -> Scene5());
       }

    private void Scene5() {
        text.setText("You look around the first floor but it seems to be completely empty. You enter a room and in front of you is two sets of staircases, they both look identical.");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Pick a Staircase!");
        alert.setHeaderText("Which set of stairs will you pick?");
        alert.setContentText("Choose your option.");

        ButtonType buttonTypeOne = new ButtonType("One");
        ButtonType buttonTypeTwo = new ButtonType("Two");


        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne) {
            player.health-=20;
            if(player.isDead()) {
                Gameover();
            }
            UpdatePlayerHealth();
            text.setText("The moment you set your foot on one of the steps, arrows are launched at you. You take 20 damage. Injured you take the next set of stairs to the next level.");
            levellabel.setText("Level 2");
            cont.setOnAction(event -> Scene6());
        } else if (result.get() == buttonTypeTwo) {
            text.setText("you enter the next level.");
            levellabel.setText("Level 2");
            cont.setOnAction(event -> Scene6());
        }
    }

    private void Scene6() {
        text.setText("The second floor is just as empty and run down as the first floor. Does someone really live here.No who ever is in charge of these monsters can't be human. " +
                " 'I sense the smell of blood....Human blood!' a eerie voice cried out. You steady your sword as you hear footsteps rushing towards you getting louder and louder. A man jumps out at you." +
                "You quickly move away. The moonlight shines on his face and reveals...fangs! It's a vampire! ");
       Vampire vampire = new Vampire("Vampire",70,20,50);
       UseItems(player,vampire);

        enemyhealth.setText(vampire.name+"'s health: "+vampire.health);
        decisions.getChildren().add(attack);
        CombatSequence(player,vampire);
        cont.setOnAction(event -> {
            if (vampire.isDead()) {
                enemyhealth.setText("No Enemy");
                decisions.getChildren().remove(attack);
                Scene7();
            }
            else{
                Alert zombieAlive = new Alert(Alert.AlertType.ERROR);
                zombieAlive.setContentText("Hey! The Vampire is still alive, you can't run from him.");
                zombieAlive.showAndWait();
            }
        });
    }

    private void Scene7() {
        text.setText("The vampire turns to ash. You catch your breath. You walked passed the hall into the main room of the second floor, on the shelf is a bomb. You grab it. This will " +
                "come in handy.");
        player.items.add(new Bomb(40));
        cont.setOnAction(event -> Scene8());
    }

    private void Scene8() {
        text.setText("You look across the hall, there are two doors. You could ignore them and go to the next floor or you could enter one of them.");
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Make a decision!");
        alert.setHeaderText("Where will you go?");
        alert.setContentText("Choose your option.");

        ButtonType upstairs = new ButtonType("Upstairs");
        ButtonType door1 = new ButtonType("Door 1");
        ButtonType door2 = new ButtonType("Door 2");

        alert.getButtonTypes().setAll(upstairs, door1, door2);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == upstairs) {
            text.setText("You ignore the two doors and go to next floor");
            levellabel.setText("level 3");
            cont.setOnAction(event -> Scene9());
        } else if (result.get() == door1) {
            text.setText("You found a new sword! The new Sword is 60 damage and 60% accuracy. Do you want to take it?");
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Make a decision!");
            alert1.setHeaderText("Do you want to change your old sword to this sword?");
            alert1.setContentText("Choose your option.");

            ButtonType yes = new ButtonType("yes");
            ButtonType no = new ButtonType("no");


            alert1.getButtonTypes().setAll(yes, no);

            Optional<ButtonType> result1 = alert1.showAndWait();
            if (result1.get() == yes) {
                player.setSword(new Sword(6, 60));
                text.setText("you obtained a new sword");
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Make a decision!");
                alert2.setHeaderText("Do you want to go upstairs or enter the second door?");
                alert2.setContentText("Choose your option.");

                ButtonType upstairs1 = new ButtonType("upstairs");
                ButtonType door = new ButtonType("door 2");


                alert2.getButtonTypes().setAll(upstairs1, door);

                Optional<ButtonType> result2 = alert2.showAndWait();
                if (result2.get() == upstairs1) {
                    text.setText("You ignore the second door and go to next floor");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                } else if (result2.get() == door) {
                    player.health -= 30;
                    if (player.isDead()) {
                        Gameover();
                    }
                    UpdatePlayerHealth();
                    text.setText("You open the door and it triggers an explosion. You take 30 damage. You go to next floor");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                }
            } else if (result1.get() == no) {
                text.setText("you decide not to take the sword and put it back");
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                alert2.setTitle("Make a decision!");
                alert2.setHeaderText("Do you want to go upstairs or enter the second door?");
                alert2.setContentText("Choose your option.");

                ButtonType upstairs1 = new ButtonType("upstairs");
                ButtonType door = new ButtonType("door 2");


                alert2.getButtonTypes().setAll(upstairs1, door);

                Optional<ButtonType> result2 = alert.showAndWait();
                if (result2.get() == upstairs1) {
                    text.setText("You ignore the second doors and go to next floor");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                } else if (result2.get() == door) {
                    player.health -= 30;
                    if (player.isDead()) {
                        Gameover();
                    }
                    UpdatePlayerHealth();
                    text.setText("You open the door and it triggers an explosion. You take 30 damage. You go to next floor");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                }
            }

        } else if (result.get() == door2) {
            text.setText("You open the door and it triggers an explosion. You take 30 damage");
            player.health -= 30;
            if (player.isDead()) {
                Gameover();
            }
            UpdatePlayerHealth();
            Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
            alert2.setTitle("Make a decision!");
            alert2.setHeaderText("Do you want to go upstairs or enter the second door?");
            alert2.setContentText("Choose your option.");

            ButtonType upstairs1 = new ButtonType("upstairs");
            ButtonType door = new ButtonType("door 1");


            alert2.getButtonTypes().setAll(upstairs1, door);

            Optional<ButtonType> result2 = alert2.showAndWait();
            if (result2.get() == upstairs1) {
                text.setText("You ignore the first door and go to next floor");
                levellabel.setText("level 3");
                cont.setOnAction(event -> Scene9());
            } else if (result2.get() == door) {
                text.setText("You found a new sword! The new Sword is 60 damage and 60% accuracy. Do you want to take it?");
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Make a decision!");
                alert1.setHeaderText("Do you want to change your old sword to this sword?");
                alert1.setContentText("Choose your option.");

                ButtonType yes = new ButtonType("yes");
                ButtonType no = new ButtonType("no");


                alert1.getButtonTypes().setAll(yes, no);

                Optional<ButtonType> result1 = alert1.showAndWait();
                if (result1.get() == yes) {
                    player.setSword(new Sword(6, 60));
                    text.setText("You obtained a new sword! You go to next floor");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                }
                else if (result1.get() == no) {
                    text.setText("You decide not to take the sword and put it back. You got to the next floor.");
                    levellabel.setText("level 3");
                    cont.setOnAction(event -> Scene9());
                }
            }
        }
    }
    private void Scene9() {
        text.setText("you enter the next floor only to find a large room filled with all sorts of witchcraft. A woman stands in front of you. 'Hello there warrior I have been expecting you." +
                " I don't want to fight you however I've been put under a curse to serve the boss that lives on the top floor of this fortress. He is on the floor above me. Please kill me " +
                "and him so you may save the villagers.' ");
        Witch witch = new Witch("Witch",60,20,40);
        UseItems(player,witch);
        enemyhealth.setText(witch.name+"'s health: "+witch.health);
        decisions.getChildren().add(attack);
        CombatSequence(player,witch);
        cont.setOnAction(event -> {
            if (witch.isDead()) {
                enemyhealth.setText("No Enemy");
                decisions.getChildren().remove(attack);
                Scene10();
            }
            else{
                Alert zombieAlive = new Alert(Alert.AlertType.ERROR);
                zombieAlive.setContentText("Hey! The Witch is still alive, you can't run from her.");
                zombieAlive.showAndWait();
            }
        });
    }

    private void Scene10() {
        text.setText("The witch collapses. She looks up at you with a smile. 'Thank you. Before I die I will give you the remaining life I have. Please kill him.' You feel your health restoring" +
                ". You gained 100 health! The witch closes her eyes. She has died with hope in her heart. Before you head on to the boss. You take a moment to pray for her soul before grabbing a poison potion and heading to the last floor. ");
        player.health+=100;
        UpdatePlayerHealth();
        player.items.add(new PoisonPotion(10));
        levellabel.setText("BOSS");
        cont.setOnAction(event -> Scene11());
    }

    private void Scene11() {
        text.setText("You enter the last floor and there he is waiting. The floor is nothing but one small empty room. There's no windows no furniture,just him standing there." +
                " You notice it right away, he is nothing but what seems to be an entity of random symbols, letters and numbers put together and taken the shape of a person." +
                " On closer inspection you realize it. It's not random symbols, it's code. Oh my god, the boss is Java. You have come to slay the programing language Java. (Talk about meta)." +
                " You grip your sword, it's time to end this, with one final battle. ");
        Boss boss = new Boss("Java",200,30,7);
        UseItems(player,boss);
        enemyhealth.setText(boss.name+"'s health: "+boss.health);
        decisions.getChildren().add(attack);
        CombatSequence(player,boss);
        cont.setOnAction(event -> {
            if (boss.isDead()) {
                enemyhealth.setText("No Enemy");
                decisions.getChildren().remove(attack);
                Scene12();
            }
            else{
                Alert zombieAlive = new Alert(Alert.AlertType.ERROR);
                zombieAlive.setContentText("Hey! Java is still alive, you can't run from it.");
                zombieAlive.showAndWait();
            }
        });
    }

    private void Scene12() {
        text.setText("It was no small task but you have defeated Java. You exit the fortress and inform the villagers that they have been saved. They offer you gifts, but you refuse, they need it more then you" +
                " besides the fact that you beat Java is more the enough of a reward for you. The village is now a thriving city and you are remember as the legendary hero who defeated Java. " +
                "The end.");
        Alert gameover = new Alert(Alert.AlertType.INFORMATION);
        gameover.setTitle("You win!");
        gameover.setHeaderText("Congrats you win!");
        gameover.setContentText("Thanks for playing!");
        ButtonType back = new ButtonType("Ok");
        gameover.getButtonTypes().setAll(back);
        Optional<ButtonType> result = gameover.showAndWait();
        if (result.get() == back){
            Platform.exit();
            System.exit(0);
        }

    }

//runs a gameover sequence
    public void Gameover(){
        Alert gameover = new Alert(Alert.AlertType.ERROR);
        gameover.setTitle("Gameover!");
        gameover.setHeaderText("Gameover!");
        gameover.setContentText("You're dead! git gud ");
        ButtonType back = new ButtonType("Ok");
        gameover.getButtonTypes().setAll(back);
        Optional<ButtonType> result = gameover.showAndWait();
        if (result.get() == back){
            Platform.exit();
            System.exit(0);
        }
    
    }

    public String PlayerBlindMessage(Player player){
        if(player.isBlind()){
            return "you are blind, you have been blinded for "+player.blindCounter;
        }
        return "";
    }
    public String PlayerPoisonedMessage(Player player){
        if(player.isPoisoned()){
            return " you are poisoned, you have been poisoned for "+player.poisonCounter;
        }
        return "";
    }
    public String EnemyBlindMessage(Enemy enemy){
        if(enemy.isBlind()){
            return enemy.name+" is blind, they have been blinded for "+enemy.blindCounter;
        }
        return "";
    }
    public String EnemyPoisonedMessage(Enemy enemy){
        if(enemy.isPoisoned()){
            return enemy.name+" is poisoned, they have been poisoned for "+enemy.poisonCounter;

        }
        return "";
    }
    public void CombatSequence(Player player, Enemy enemy){
        attack.setOnAction(actionEvent -> {
            if(enemy.isDead()) return;

            text.setText(EnemyBlindMessage(enemy)+". "+EnemyPoisonedMessage(enemy)+". "+"Enemy took "+enemy.takeDamage(player.attack(player.sword.damage,player.sword.accuracy))+
            " damage. "+PlayerBlindMessage(player)+". "+PlayerPoisonedMessage(player)+". "+player.name+" took "+player.takeDamage(enemy.attack(enemy.damage,enemy.accuracy))+" damage");
             playerhealth.setText(player.name+"'s health: "+player.health);
             enemyhealth.setText(enemy.name+"'s health: "+enemy.health);

             if(player.isDead()){
                 Gameover();
             }
             if(enemy.isDead()){
                 enemyhealth.setText("No Enemy");
             }
        });

    }
    public void UseItems(Player player, Enemy enemy){
        useItems.setOnAction(event -> {
            if(player.items.size() == 0){
                Alert noItems = new Alert(Alert.AlertType.ERROR);
                noItems.setContentText("You don't have any items :(");
                noItems.showAndWait();
                return;
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Pick an Item!");
            alert.setHeaderText("Which item will you pick?");
            alert.setContentText("Choose your option.");

            ArrayList<ButtonType> buttons = new ArrayList<>();
            for (Item item: player.items) {
                buttons.add(new ButtonType(item.getName()));
            }

            alert.getButtonTypes().setAll(buttons);

            Optional<ButtonType> result = alert.showAndWait();
            String chosenItem = result.get().getText();
            int itemIndex = buttons.indexOf(result.get());
            for (Item item : player.items) {
                if (chosenItem.equals(item.getName())){
                    if(item.getType() == ItemType.HealingPotion){
                        player.useItem(itemIndex, player);
                        UpdatePlayerHealth();
                    }
                    else {
                        if (enemy != null && !enemy.isDead()) {
                            player.useItem(itemIndex, enemy);
                            enemyhealth.setText(enemy.name + "'s health: " + enemy.health);
                            }
                        else{
                            Alert error = new Alert(Alert.AlertType.ERROR);
                            error.setContentText("No enemy to use the item on!");
                            error.showAndWait();
                            return;
                        }
                    }
                    text.setText("You used your " + item.getName());
                }
            }
        });
    }


}
