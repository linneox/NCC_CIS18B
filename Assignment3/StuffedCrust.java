package pos;

/**
 *
 * @author JAV
 */
public class StuffedCrust extends Pizza {

    Pizza pizzaWrap;
    private final double COST = 4.00; 

    public StuffedCrust(Pizza pizza) {
        this.pizzaWrap = pizza;
    }

    @Override
    public String getDescription() {
        return pizzaWrap.getDescription() + "Struffed Crust \t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }

    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }
}
