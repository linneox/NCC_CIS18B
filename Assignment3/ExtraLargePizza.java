package pos;

/**
 *
 * @author JAV
 */
public class ExtraLargePizza extends Pizza {

    private final double COST = 22.0;
    public ExtraLargePizza() {
        description = "Extra Large Pizza \t$ " + Double.toString(COST).format("%.2f", COST) + "\n";
    }

    @Override
    public double cost() {
        return COST;
    }
}
