import com.example.thefinalbattle.Character;
import com.example.thefinalbattle.Enemy;
import com.example.thefinalbattle.Item;
import com.example.thefinalbattle.Sword;

import java.util.ArrayList;

public class Player extends Character {
protected ArrayList<Item> Items = new ArrayList<>(3);
protected Sword sword;
public Player(String name,int health) {
    this.health = health;
    this.name=name;
}
    public void setSword(Sword sword){
        this.sword=sword;
    }

    public void removeItem(int index){
    Items.remove(index);
    }
    public boolean isMaxInventorySize(){
    if (Items.size()==3){
        return true;
    }
    return false;
    }


    // THIS IS ONLY TEMPORARY, ONCE I START IMPLEMENTING JAVAFX I WILL CHANGE THIS OR MOVE THIS TO MAIN
    // AS OF NOW, THE USER IS NOT BEING TAKEN INTO CONSIDERATION IF THE CAPACITY IS FULL
    public void addItem(Item item){
    if (isMaxInventorySize()){
        removeItem(3);
    }
    Items.add(item);
    }
   public void useItem(int index, Enemy enemy){
    Items.get(index).use(enemy);
   }

}

