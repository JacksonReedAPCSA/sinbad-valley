import java.util.*;

public class StardewValleyRipoff {
  public static void main(String[] args) {
    
    PlayerInventory inv = new PlayerInventory();
    Field f = new Field();
    Scanner scan = new Scanner(System.in);
    Location NewYork = new Location("New York", "https://w1.weather.gov/xml/current_obs/KNYC.xml");
    Location Texas = new Location("Texas", "https://w1.weather.gov/xml/current_obs/KEDC.xml");
    System.out.println("Welcome to Stardew Valley Ripoff Simulator.");
    System.out.println(Texas);
    System.out.println(NewYork);
    
    Potato p = new Potato();
    
    f.plantCrop(p, inv, 3, 2);
    String userInput = scan.nextLine();
    while(userInput.equals("a")){
      f.ageField(Texas.temp());
      userInput = scan.nextLine();
    }
  }
}