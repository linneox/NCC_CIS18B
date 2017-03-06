package pos;

/**
 *
 * @author JAV
 */
public class Mushrooms extends Toppings {

    Pizza pizzaWrap;
    private final double COST = 3.00; 

    public Mushrooms(Pizza pizza) {
        this.pizzaWrap = pizza;
    }

    @Override
    public String getDescription() {
        return pizzaWrap.getDescription() + "Mushrooms $" + COST + "\n";
    }

    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }
}
