package pos;

/**
 *
 * @author JAV
 */
public class SmallPizza extends Pizza {
    private final double COST = 10.0;
    public SmallPizza() {
        description = "Small Pizza \t\t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }
    
    @Override
    public double cost() {
        return COST;
    }
}
