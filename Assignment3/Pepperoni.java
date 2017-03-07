package pos;

/**
 *
 * @author JAV
 */
public class Pepperoni extends Toppings {

    Pizza pizzaWrap;
    private final double COST = 1.00; 
    
    public Pepperoni(Pizza pizza) {
        this.pizzaWrap = pizza;
    }

    @Override
    public String getDescription() {
        return pizzaWrap.getDescription() + "Pepperoni \t\t$" + Double.toString(COST).format("%.2f", COST) + "\n";
    }

    @Override
    public double cost() {
        return COST + pizzaWrap.cost();
    }
}
