import java.util.*;

public class StardewValleyRipoff {
  public static void main(String[] args) {
    
    PlayerInventory inv = new PlayerInventory();
    Field f = new Field();
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Welcome to Stardew Valley Ripoff Simulator.");
    
    
    Potato p = new Potato();
    
    f.plantCrop(p, inv, 3, 2);
    String userInput = scan.nextLine();
    while(userInput.equals("a")){
      f.ageField(1000);
      userInput = scan.nextLine();
    }
  }
}