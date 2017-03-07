package pos;

/**
 *
 * @author JAV
 */
public class Olives extends Toppings {

    Pizza pizzaWrap;
    private final double COST = 2.00; 
    
    public Olives(Pizza pizza) {
        this.pizzaWrap = pizza;
    }

    @Override
    public String getDescription() {
        return pizzaWrap.getDescription() + "Olives \t\t\t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }

    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }
}
