package NatGeoCode;

import java.util.Scanner;

/**
 *
 * @author Johnathon Valles
 */
public class SubscribersDriver {

    public static void main(String[] args) {

        NatGeoMag list1 = new NatGeoMag();
        MagSubMenu menu1 = new MagSubMenu();
        Scanner keyboard = new Scanner(System.in);
        
        menu1.display();
        System.out.print("Enter Choice: ");
        char choice = menu1.getChoice();
        String addrsInput; 
        boolean search; 
        
        
        switch (choice) {
            case 'a':
            case 'A':
                System.out.print("Enter Address: ");
                addrsInput = keyboard.nextLine();
                search = list1.searchSubscriber(addrsInput);
                
                if (search == false) {
                    new Subscriber(addrsInput, list1);
                    System.out.println("Subscriber added.");
                }
                else {
                    System.out.println("Subscriber already in the list");
                }
                break;
                
                
            case 'b':
            case 'B':
                System.out.print("Enter Address: ");
                addrsInput = keyboard.nextLine();
                search = list1.searchSubscriber(addrsInput);
                
                if (search == true) {
                    list1.removeObserver(addrsInput);
                }
                else {
                    System.out.println("subsriber not found.");
                }      
                break; 
                
            case 'c':
            case 'C':
                break; 
            default:
                 break;
        }
    }
}    


    
