package NatGeoCode;

import java.util.Scanner;

public class MagSubMenu implements Menu {

    private Scanner keyboard;
    
    public MagSubMenu() {
        keyboard = new Scanner(System.in);
    }
    
    @Override
    public void display() {
        System.out.println("********** SUBSCRIPTION MENU **********");
        System.out.println("  a. ADD NEW SUBSCRIBER");
        System.out.println("  b. REMOVE EXISTING SUBSCRIBER");
        System.out.println("  c. SEND MESSAGE TO ALL SUBSCRIBERS");
        System.out.println("***************************************");
    }
    
    @Override
    public char getChoice() {
        char choice = keyboard.next().charAt(0);
        return choice; 
    }

}
