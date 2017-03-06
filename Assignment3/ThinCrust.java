package pos;

/**
 *
 * @author JAV
 */
public class ThinCrust extends Pizza {

    Pizza pizzaWrap;
    private final double COST = 0.0;

    public ThinCrust(Pizza pizza) {
        this.pizzaWrap = pizza;
    }

    public String getDescription() {
        
        return pizzaWrap.getDescription() + "Thin Crust $" + COST + "\n";
    }
    
    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }

}
