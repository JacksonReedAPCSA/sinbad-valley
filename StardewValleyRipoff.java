import java.util.*;

public class StardewValleyRipoff {
  public static void main(String[] args) {
    
    PlayerInventory inv = new PlayerInventory();
    Field f = new Field();
    Scanner scan = new Scanner(System.in);
    double fieldTemp = 0.0;
    String fieldState = "";
    
    System.out.println("Welcome to Stardew Valley Ripoff Simulator.");
    System.out.println("Where would you like to start your field? Options: [NY, TX, AK, HI, NM]");
    String fieldLocation = scan.nextLine().toUpperCase();
    switch(fieldLocation) {
      case("NY"): 
        Location NewYork = new Location("New York", "https://w1.weather.gov/xml/current_obs/KNYC.xml");
        fieldTemp = NewYork.temp();
        fieldState = NewYork.name();
        System.out.println(NewYork);
        break;
      case("TX"):
        Location Texas = new Location("Texas", "https://w1.weather.gov/xml/current_obs/KEDC.xml");
        fieldTemp = Texas.temp();
        fieldState = Texas.name();
        System.out.println(Texas);
        break;
      case("AK"):
        Location Alaska = new Location("Alaska", "https://w1.weather.gov/xml/current_obs/PABT.xml");
        fieldTemp = Alaska.temp();
        fieldState = Alaska.name();
        System.out.println(Alaska);
        break;
      case("HI"):
        Location Hawaii = new Location("Hawaii", "https://w1.weather.gov/xml/current_obs/PHTO.xml");
        fieldTemp = Hawaii.temp();
        fieldState = Hawaii.name();
        System.out.println(Hawaii);
        break;
      case("NM"):
        Location NewMexico = new Location("New Mexico", "https://w1.weather.gov/xml/current_obs/KABQ.xml");
        fieldTemp = NewMexico.temp();
        fieldState = NewMexico.name();
        System.out.println(NewMexico);
        break;                           
    }
    
    
    System.out.println("You have inherited a 5x5 field in " + fieldState + " from the untimely death of a loved one. With 5$ to your name, you set out to turn the field into a veritable money making business.");
    System.out.println("Your current goal is to make 100$ or more. If at any time you are left with 0$ and don't have any plants growing, you will have to give up.");
    
    String userInput = "";
    String cropChoice = "";
    int cropRow = 0;
    int cropCol = 0;
    String buyUpgrade = "";
    boolean keepPlaying = true;
    while(inv.getFunds() < 100 && keepPlaying) {
      System.out.println("What would you like to do? Options: [(P)lant crop, (E)fficient plant crop, (A)ge field, (H)arvest field, (G)ive up, check (B)alance, buy (U)pgrades]");
      userInput = scan.nextLine().toUpperCase();
      switch(userInput) {
        case("P"):
          System.out.println("What type of crop would you like to place? Options: [(P)otato 1$, (T)omato 2$]");
          cropChoice = scan.nextLine().toUpperCase();
          System.out.println("What row would you like to place it in? Options: [0, 1, 2, 3, 4]");
          cropRow = scan.nextInt();
          System.out.println("What column would you like to place it in? Options: [0, 1, 2, 3, 4]");
          cropCol = scan.nextInt();
          switch(cropChoice) {
            case("P"):
              Potato p = new Potato();
              f.plantCrop(p, inv, cropRow, cropCol);
              break;
            case("T"):
              Tomato t = new Tomato();
              f.plantCrop(t, inv, cropRow, cropCol);
              break;
          }
          break;
        case("A"):
          f.ageField(fieldTemp);
          break;
        case("H"):
          f.harvestField(inv);
          break;
        case("G"):
          keepPlaying = false;
          break;
        case("B"):
          System.out.println("You currently have " + inv.getFunds() + "$ to your name.");
          break;
        case("E"):
          System.out.println("What type of crop would you like to place? Options: [(P)otato 1$, (T)omato 2$]");
          cropChoice = scan.nextLine().toUpperCase();
          System.out.println("What row would you like to place the crops in? Options: [0, 1, 2, 3, 4]");
          cropRow = scan.nextInt();
          switch(cropChoice) {
            case("P"):
              Potato p = new Potato();
              f.plantCropEfficient(p, 0, inv, cropRow);
              break;
            case("T"):
              Tomato t = new Tomato();
              f.plantCropEfficient(t, 1, inv, cropRow);
              break;
          }
          break;
        case("U"):
          System.out.println("Welcome to the upgrades shop! Here you can buy efficient crop planting for 40$. Would you like to? Options [Y/N]");
          buyUpgrade = scan.nextLine().toUpperCase();
          switch(buyUpgrade) {
            case("Y"):
              if((inv.getFunds() >= 40) && (!inv.hasEfficientUpgrade())) {
                inv.buyEfficientUpgrade();
                inv.spendMoney(40);
                System.out.println("Efficient crop planting upgrade successfully bought!");
              }
              else {
                System.out.println("Could not buy upgrade, you either have insufficient funds or you've bought the upgrade alreadya!");
              }
              break;
            case("N"):
              System.out.println("Come again!");
              break;
                
          }
      }
    }
    if(keepPlaying) {
      System.out.println("Well done! You've made 100$ or more and beat the game!");
    }
    else {
      System.out.println("What a shame! Your business venture has failed. Game over!");
    }
  }
}
