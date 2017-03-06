package pos;

/**
 *
 * @author JAV
 */
public class ExtraLargePizza extends Pizza {

    private final double COST = 22.0;
    public ExtraLargePizza() {
        description = "Extra Large Pizza $ " + COST + "\n";
    }

    @Override
    public double cost() {
        return COST;
    }
}
