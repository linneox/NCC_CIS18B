package pos;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author JAV
 */
public class PizzaPOS {

    // Implement way of displaying two decimal points for prices: format specifiers
    public static void main(String[] args) {

        char choice = 'Y';
        Pizza tempPizza;
        double deliveryFee = 0.0;
        double total;

        boolean pizzacomp = false;

        while (choice != 'X') { // First Loop for DeliveryMenu
            displayDeliveryMenu();
            choice = getChoice();
            if (choice == 'A') {
                deliveryFee += 5.0;
            }

            while (choice != 'X') {
                displaySizeMenu();
                choice = getChoice();
                tempPizza = createPizza(choice);

                while (choice != 'X') {
                    displayCrustMenu();
                    choice = getChoice();
                    tempPizza = createCrust(choice, tempPizza);

                    while (tempPizza.getClass().getSimpleName().equals("SmallPizza")) {
                        displayCrustMenu();
                        choice = getChoice();
                        tempPizza = createCrust(choice, tempPizza);
                    }

                    while (choice != 'X') {
                        displayToppingsMenu();
                        choice = getChoice();
                        tempPizza = createTopping(choice, tempPizza);

                        System.out.print("Add another topping[Y/N]: ");
                        choice = getChoice();

                        while (choice == 'Y') {
                            displayToppingsMenu();
                            choice = getChoice();
                            tempPizza = createTopping(choice, tempPizza);
                            System.out.print("Add another topping[Y/N]: ");
                            choice = getChoice();
                        }

                        if (deliveryFee != 0.0) {
                            System.out.println("Delivery Fee $" + deliveryFee);
                        }

                        System.out.println(tempPizza.getDescription());
                        total = deliveryFee + tempPizza.cost();
                        System.out.println("Total: $" + total);

                        System.out.print("Create another pizza order[Y/N]: ");
                        choice = getChoice();

                        if (choice == 'Y') {
                            tempPizza = null;
                            deliveryFee = 0.0;
                            break;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void displayDeliveryMenu() {
        System.out.println("***************** Order Type ********************");
        System.out.println("\n\ta) Delivery ($5 Delivery Fee)"
                + "\n\tb) Carry Out\n");
        System.out.println("*************************************************");
        System.out.print("Enter Delivery Type[a-b]: ");
    }

    public static void displaySizeMenu() {
        System.out.println("***************** Pizza Size *******************");
        System.out.println("\n\ta) Small Pizza"
                + "\n\tb) Medium Pizza"
                + "\n\tc) Large Pizza"
                + "\n\td) Extra Large Pizza\n");
        System.out.println("*************************************************");
        System.out.print("Enter Pizza Size[a-d]: ");
    }

    public static void displayCrustMenu() {
        System.out.println("***************** Pizza Crust *******************");
        System.out.println("\n\ta) Thin Crust"
                + "\n\tb) Thick Crust"
                + "\n\tc) Stuffed Crust ($4, not compatible with small size)"
                + "\n");
        System.out.println("*************************************************");
        System.out.print("Enter Pizza Crust[a-c]: ");
    }

    public static void displayToppingsMenu() {
        System.out.println("***************** Toppings **********************");
        System.out.println("\n\ta) Pepperoni"
                + "\n\tb) Olives"
                + "\n\tc) Mushrooms"
                + "\n");
        System.out.println("*************************************************");
        System.out.print("Enter Pizza Toppings[a-c]: ");
    }

    public static char getChoice() {
        Scanner keyboard = new Scanner(System.in);
        char choice = keyboard.next().charAt(0);
        choice = Character.toUpperCase(choice);
        return choice;
    }

    public static Pizza createPizza(char choice) {

        Pizza pizzaType = null;

        switch (choice) {
            case 'A':
                pizzaType = new SmallPizza();
                break;
            case 'B':
                pizzaType = new MediumPizza();
                break;
            case 'C':
                pizzaType = new LargePizza();
                break;
            case 'D':
                pizzaType = new ExtraLargePizza();
                break;
        }
        return pizzaType;
    }

    public static Pizza createCrust(char choice, Pizza pizza) {

        Pizza pizzaCrust = pizza;
        boolean smallPizza;
        smallPizza = pizza.getClass().getSimpleName().equals("SmallPizza");
        if (choice == 'A') {
            pizzaCrust = new ThinCrust(pizza);
            return pizzaCrust;
        } else if (choice == 'B') {
            pizzaCrust = new ThickCrust(pizza);
            return pizzaCrust;
        } else if (!smallPizza && choice == 'C') {
            pizzaCrust = new StuffedCrust(pizza);
            return pizzaCrust;
        } else if (smallPizza && choice == 'C') {
            System.out.println("Stuffed Crust not compatible with a small pizza.\n");
            return pizza;

        }
        return pizzaCrust; // If all fails. 
    }

    public static Pizza createTopping(char choice, Pizza pizza) {

        Pizza pizzaTop = pizza;

        switch (choice) {
            case 'A':
                pizzaTop = new Pepperoni(pizza);
                break;
            case 'B':
                pizzaTop = new Olives(pizza);
                break;
            case 'C':
                pizzaTop = new Mushrooms(pizza);
                break;
        }
        return pizzaTop;
    }
}
