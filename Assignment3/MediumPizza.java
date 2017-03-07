package pos;

/**
 *
 * @author JAV
 */
public class MediumPizza extends Pizza {
    
    private final double COST = 14.0;

    public MediumPizza() {
        description = "Medium Pizza \t$" + Double.toString(COST).format("%.2f", COST) +"\n";
    }

    @Override
    public double cost() {
        return COST;
    }

}
