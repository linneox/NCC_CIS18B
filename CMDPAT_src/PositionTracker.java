package CIS18B_Assignment06;
import java.util.Scanner;
/**
 *
 * @author johnathon Valles
 */




/*
     TO DOOOO

     - implement the goback method
     - look into queues


*/
public class PositionTracker {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        Position userPosXY = new Position();
        
        Command up = new UpDirectionCommand(userPosXY);
        Command down = new DownDirectionCommand(userPosXY);
        Command left = new LeftDirectionCommand(userPosXY);
        Command right = new RightDirectionCommand(userPosXY);
        
        char direction = ' ';
        
        do {
            displayMenu(userPosXY);
            direction = getDirection(keyboard);

            
            switch(direction) {
                case 'W':
                    up.execute();
                    break; 
                case 'A':
                    left.execute();
                    break;
                case 'S':
                    down.execute();
                    break; 
                case 'D':
                    right.execute();
            }
            
            userPosXY.getCoordinates();
            
            
        } while (direction != '*');
    }
    
    public static void displayMenu(Position userPosXY) {
        System.out.println("\n====================== Postion Tracker " 
                + "======================");
        System.out.println("\tMove:\n\t\tW) Up\n\t\tA) Left\n\t\tS) Down\n\t\tD) Right\n\t\tF) Go Back");
        System.out.println("=======================================" 
                + "======================");
        System.out.print("Current Position: ");
        userPosXY.getCoordinates();
        System.out.print("\nEnter Direction [W,A,S,D]: ");
    }
    
    public static char getDirection(Scanner keybo) {
        char entry = keybo.next().charAt(0);
        entry = Character.toUpperCase(entry);
        
        return entry;
    }
    
    public static boolean validateEntry(char direction) {
        boolean valid = false; 
        
        if (direction == 'W' || direction == 'A' 
           || direction == 'S' || direction == 'D') {
            valid = true;
        }
        
        return valid;   
    }
}