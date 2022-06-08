public abstract class Crop {
  private int health = 100;
  private boolean isAlive = true;
  private int growthStage = 0;
  
  public Crop() {
  }
  
  public boolean optimalTempCheck(double farmTemp) {
    boolean tempCheck = ((farmTemp >= getLTemp())&&(farmTemp <= getUTemp()))? true : false;
    return tempCheck;
  }
  
  public int getHealth() {
    return health;
  }
  
  public String getCropName() {
    return getName();
  }
  
  public void dieCheck() {
    isAlive = ((health <= 0) || (growthStage > getFullGrowth() + 2))? false : true;
  }
  
  public boolean getAliveStatus() {
    dieCheck();
    return isAlive;
  }
  
  public void increaseGrowthStage(int inc) {
    growthStage += inc;
  }
  
  public void decreaseHealth(int dec) {
    health -= dec;
  }
  
  public boolean harvest(PlayerInventory inv) {
    if(getAliveStatus() && growthStage >= getFullGrowth()) {
      inv.gainMoney(getSellVal());
      health = 0;
      return true;
    }
    else {
      if(growthStage > getFullGrowth() + 2) {
        System.out.println("Your " + getCropName() + " is overripe. You can't harvest it anymore and it will die soon.");
      }
      else {
        System.out.println("Your " + getName() + " is not fully grown yet!");
      }
      return false;
    }
  }
  
  public double getSellValue() {
    return getSellVal();
  }
  
  public double getBuyValue() {
    return getBuyVal();
  }
  
  public abstract double getLTemp();
  public abstract double getUTemp();
  public abstract String getName();
  public abstract int getFullGrowth();
  public abstract double getSellVal();
  public abstract double getBuyVal();
}