package pos;

import java.util.Scanner;

/**
 *
 * @author JAV
 */
public class PizzaPOS {

    public static void main(String[] args) {

        char choice = 'Y';                                                      // choice, Hold user input after each menu displayed. 
        Pizza tempPizza;                                                        // tempPizza, Holds a reference to the Pizza object as it is wrapped by its decorators. 
        double deliveryFee = 0.0;                                               // deliveryFee, 0 if first no deilvery, 5.0 if delivery. 
        double total;                                                           // total, used at end to display total. 

        while (choice != 'X') {                                                 // FIRST LOOP for DeliveryMenu
            displayDeliveryMenu();                                              // Displays carryout or delivery option
            choice = getChoice();                                               // Prompts user for choice, A or B
            if (choice == 'A') {                                                // If user enters 'A', add $5 to deliveryFee
                deliveryFee += 5.0;                                             // deliveryFee = 5.0
            }   

            while (choice != 'X') {                                             // SECOND LOOP for pizza SizeMenu
                displaySizeMenu();                                              // Prompts user for choice, A through B
                choice = getChoice();                                           // Choice = input
                tempPizza = createPizza(choice);                                // tempPizza references a [size]Pizza object

                while (choice != 'X') {                                         // THIRD LOOP for pizzaCrustMenu
                    displayCrustMenu();                                         // Display crust options 
                    choice = getChoice();                                       // Gets user choice
                    tempPizza = createCrust(choice, tempPizza);                 // Previous tempPizza reference wrapped by new [crust]Pizza

                    while (tempPizza.getClass()                                 // If the createCrust menu returns the original reference, it means
                            .getSimpleName().equals("SmallPizza")) {            // user entered SmallPizza and StuffedCrust (not compatible).
                        displayCrustMenu();                                     // Re-runs CrustMenu
                        choice = getChoice();                                   // Gets user input
                        tempPizza = createCrust(choice, tempPizza);             // If SmallPizza and not StuffedCrust not references a Crust Object
                    }

                    while (choice != 'X') {                                     // FOURTH LOOP for ToppingsMenu
                        displayToppingsMenu();                                  // Display toppings menu
                        choice = getChoice();                                   // Get user input
                        tempPizza = createTopping(choice, tempPizza);           // Wrap previous reference with a new Toppings Object

                        System.out.print("Add another topping[Y/N]: ");         // For multiple Toppings entry
                        choice = getChoice();                                   // Get user input

                        while (choice == 'Y') {                                 // FIFTH RE-LOOP for extra toppings
                            displayToppingsMenu();                              // Displays Toppings Menu
                            choice = getChoice();                               // Get user input
                            tempPizza = createTopping(choice, tempPizza);       // TempPizza wrapped by another toppings object
                            System.out.print("Add another topping[Y/N]: ");     
                            choice = getChoice();                               // Get user input
                        }

                        System.out.println("\n\n******************" 
                                + "*******************************");
                        if (deliveryFee != 0.0) {
                            System.out.println("Delivery Fee \t\t$" 
                                    + String.format("%.2f", deliveryFee));
                        }

                        System.out.println(tempPizza.getDescription());         // Display Description of pizza
                        total = deliveryFee + tempPizza.cost();                 // Display individual costs
                        System.out.printf("TOTAL: $%.2f", total);              
                        System.out.println("\n\n******************" 
                                + "*******************************");
                        System.out.print("\nCreate another pizza order[Y/N]: ");
                        choice = getChoice();

                        if (choice == 'Y') {                                    // Reset Everything
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
            System.out.println("Stuffed Crust not " 
                    + " compatible with a small pizza.\n");
            return pizza;

        }
        return pizzaCrust; // If all fails, returns original reference, not wrapped. 
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
