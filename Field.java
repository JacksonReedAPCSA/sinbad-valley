public class Field {
  private Crop[][] land = new Crop[5][5];
  
  public Field() {
  }
  
  public Crop[][] getField() {
    return land;
  }
  
  public void plantCrop(Crop crop, PlayerInventory inv, int r, int c) {
    if(land[r][c] == null && inv.getFunds() >= crop.getBuyValue()) {
      inv.spendMoney(crop.getBuyValue());
      land[r][c] = crop;
      System.out.println(crop.getCropName() + " planted successfully!");
    }
    else {
      System.out.println("Could not place a " + crop.getCropName() + " there. Something might already be growing there or you might have insufficient funds. Amount required: " + crop.getBuyValue() + "$. You have: " + inv.getFunds() + "$");
    }
  }
  
  public boolean plantCropEfficient(Crop crop, int cropID, PlayerInventory inv, int r) {
    boolean canPlant = false;
    if((inv.getFunds() >= crop.getBuyValue() * 5) && (inv.hasEfficientUpgrade())) {
      for(int c = 0; c < land[0].length; c++) {
        switch(cropID){
          case(0):
            Potato p = new Potato();
            plantCrop(p, inv, r, c);
            break;
          case(1):
            Tomato t = new Tomato();
            plantCrop(t, inv, r, c);
            break;
        }
      }
      canPlant = true;
    }
    return canPlant;
  }
  
  public void removeCrop(int r, int c) {
    land[r][c] = null;
  }
  
  public void removeDead(int r, int c) {
    if(!land[r][c].getAliveStatus()) {
      System.out.println("Your " + land[r][c].getCropName() + " at (" + r + "," + c + ") has died!");
      StdAudio.play("augh.wav");
      StdAudio.play(StdAudio.note(0, 0.2, 0.7));
      removeCrop(r, c);
    }
  }
  
  public void age(Crop crop, double farmTemp, int r, int c) {
    if(crop.optimalTempCheck(farmTemp)) {
      crop.increaseGrowthStage(1);
      System.out.println("Your " + crop.getCropName() + " at (" + r + "," + c + ") has grown further!");
    }
    else {
      crop.decreaseHealth(20);
      System.out.println("Your " + crop.getCropName() + " at (" + r + "," + c + ") has been damaged!");
    }
  }
  
  public void ageField(double farmTemp) {
    for(int r = 0; r < land.length; r++) {
      for(int c = 0; c < land[0].length; c++) {
        if(land[r][c] != null) {
          removeDead(r, c);
          if(land[r][c] != null) {
            age(land[r][c], farmTemp, r, c);
          }
        }
      }
    }
  }
  
  public void harvestField(PlayerInventory inv) {
    for(int r = 0; r < land.length; r++) {
      for(int c = 0; c < land.length; c++) {
        if(land[r][c] != null) {
          if(land[r][c].harvest(inv)) {
            System.out.println("You harvested your " + land[r][c].getCropName() + " at (" + r + "," + c + ") and gained " + land[r][c].getSellValue() + "$.");
            removeCrop(r, c);
          }
        }
      }
    }
  }
}
