/**
 * TODO: Class description, author tag!
 */
public class Potato extends Crop {
  private static final double lTemp = 10.0;
  private static final double uTemp = 32.2;
  private static final double sellVal = 2.0;
  private static final double buyVal = 1.0;
  private static final String name = "Potato";
  private static final int fullGrowth = 5;
  
  public Potato() {
    super();
  }
  
  public double getLTemp() {
    return lTemp;
  }
  
  public double getUTemp() {
    return uTemp;
  }
  
  public String getCropName() {
    return name;
  }
  
  public double getSellValue() {
    return sellVal;
  }
  
  public int getFullGrowth() {
    return fullGrowth;
  }
  
  public double getBuyValue() {
    return buyVal;
  }
}