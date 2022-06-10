public class PlayerInventory {
  private double funds = 50;
  private boolean efficientUpgrade = false;
  
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
  
  public boolean hasEfficientUpgrade() {
    return efficientUpgrade;
  }
  
  public void buyEfficientUpgrade() {
    efficientUpgrade = true;
  }
}
