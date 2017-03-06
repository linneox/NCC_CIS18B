package pos;

/**
 *
 * @author JAV
 */
public class LargePizza extends Pizza {
    
    private final double COST = 18.0; 
    public LargePizza() {
        description = "Large Pizza $" + COST + "\n";
    }
    
    @Override
    public double cost() {
        return COST;
    }
}
