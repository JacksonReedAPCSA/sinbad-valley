public class PlayerInventory {
  private double funds = 5.0;
  private int waterUses = 5;
  
  public PlayerInventory() {
  
  }
  
  public void spendMoney(double spending) {
    funds = funds - spending;
  }
  
  public void gainMoney(double gain) {
    funds = funds + gain;
  }
  
  public double getFunds() {
    return funds;
  }
  
  public void useWater() {
    waterUses--;
  }
  
  public void gainWater() {
    waterUses++;
  }
  
}