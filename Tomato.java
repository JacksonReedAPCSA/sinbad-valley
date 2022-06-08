public class Tomato extends Crop {
  private static final double lTemp = 12.7;
  private static final double uTemp = 26.6;
  private static final double sellVal = 3.0;
  private static final double buyVal = 2.0;
  private static final String name = "Tomato";
  private static final int fullGrowth = 6;
  
  public Tomato() {
    super();
  }
  
  public double getLTemp() {
    return lTemp;
  }
  
  public double getUTemp() {
    return uTemp;
  }
  
  public String getName() {
    return name;
  }
  
  public double getSellVal() {
    return sellVal;
  }
  
  public int getFullGrowth() {
    return fullGrowth;
  }
  
  public double getBuyVal() {
    return buyVal;
  }
}