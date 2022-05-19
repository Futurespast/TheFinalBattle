package com.example.thefinalbattle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

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



    public void FirstContinue(ActionEvent actionEvent) {
           setname.setHeaderText("enter a name for your character");
           setname.showAndWait();
           Player player = new Player(setname.getEditor().getText(), 100);
           playerhealth.setText(setname.getEditor().getText() + "'s health: " + player.health);
           text.setWrapText(true);
           text.setText(player.name + " heard a rumor from the local village of a lair filled with evil."
                   + " The villagers were suffering from the evil. Against the warning of the villagers, " + player.name + " set out to vanquish the evil that lurked there.");
           decisions.getChildren().remove(cont);
           Button cont1 = new Button("Continue");
           decisions.getChildren().add(cont1);
           cont1.setOnAction(actionEvent1 ->{
               text.setText("The outside screams danger, it looks like an abandoned castle. The area seems devoid of life. The cold wind is harsh and you feel a shiver running down your spine" +
                       " Every fiber of your is telling you to turn back but you stay strong and move to enter the castle. Then suddenly...");

           });
           decisions.getChildren().remove(cont1);
           Button cont2 = new Button("Continue");
           decisions.getChildren().add(cont2);
           cont2.setOnAction(actionEvent2 -> {
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
                /*
                the following is the issue, as you can see I made a function that does the combat sequence. This is where things go to hell. I can't remove count2 like I did with
                count and count1 or count 2 won't show up and do its thing. Button3 shows up for some reason even though the action isn't done. Gameover and if zombie is dead gets totally
                ignored. This is just one massive mess. I don't even know how to lock it to the combat sequence until somebody dies. I haven't even made the use item button yet.
                I'm so lost, this has been a disaster from the get-go.
                 */
               CombatSequence(player, zombie);

               Gameover(player);
               if(zombie.isDead()){
                   enemyhealth.setText("No Enemy");
               }
           });
            Button cont3 = new Button("Continue");
            decisions.getChildren().add(cont3);

       }


    public void Gameover(Player player){
        if(player.isDead()){
            Alert gameover = new Alert(Alert.AlertType.ERROR);
            ButtonType back = new ButtonType("Ok");
            gameover.getButtonTypes().add(back);
            Optional<ButtonType> result = gameover.showAndWait();
            if (result.get() == back){
                Platform.exit();
                System.exit(0);
            }
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
        Button attack = new Button("Attack");
        attack.setOnAction(actionEvent -> {
            text.setText(EnemyBlindMessage(enemy)+". "+EnemyPoisonedMessage(enemy)+". "+"Enemy took "+enemy.takeDamage(player.attack(player.sword.damage,player.sword.accuracy))+
            " damage. "+PlayerBlindMessage(player)+". "+PlayerPoisonedMessage(player)+". "+player.name+" took "+player.takeDamage(enemy.attack(enemy.damage,enemy.accuracy))+" damage");
         playerhealth.setText(player.name+"'s health: "+player.health);
         enemyhealth.setText(enemy.name+"'s health: "+enemy.health);
         player.isDead();
         enemy.isDead();

        });
    decisions.getChildren().add(attack);


    }



}
