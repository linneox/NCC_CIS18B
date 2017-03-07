package pos;

/**
 *
 * @author JAV
 */
public class ThickCrust extends Pizza {

    Pizza pizzaWrap;
    private final double COST = 0.0;

    public ThickCrust(Pizza pizza) {
        this.pizzaWrap = pizza;
    }
    
    @Override
    public String getDescription() {
        return pizzaWrap.getDescription() + "Thick Crust \t\t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }

    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }

}
