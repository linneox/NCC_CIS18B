package pos;

/**
 *
 * @author JAV
 */
public class LargePizza extends Pizza {
    
    private final double COST = 18.0; 
    public LargePizza() {
        description = "Large Pizza \t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }
    
    @Override
    public double cost() {
        return COST;
    }
}
