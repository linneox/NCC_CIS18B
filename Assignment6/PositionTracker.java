import java.util.Scanner;

/**
 *
 * @author Johnathon Valles
 */

public class PositionTracker {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        Position userPosXY = new Position();
        Position undoRef = new Position();

        Command up = new UpDirectionCommand(userPosXY);
        Command down = new DownDirectionCommand(userPosXY);
        Command left = new LeftDirectionCommand(userPosXY);
        Command right = new RightDirectionCommand(userPosXY);
        Command previous = new NoCommand();

        char direction;

        do {
            displayMenu(userPosXY);
            direction = getDirection(keyboard);

            switch (direction) {
                case 'W':
                    up.execute();
                    previous = new UpDirectionCommand(userPosXY);
                    break;
                case 'A':
                    left.execute();
                    previous = new LeftDirectionCommand(userPosXY);
                    break;
                case 'S':
                    down.execute();
                    previous = new DownDirectionCommand(userPosXY);
                    break;
                case 'D':
                    right.execute();
                    previous = new RightDirectionCommand(userPosXY);
                    break;
                case 'F':
                    if (previous.getClass().getSimpleName()
                        .equals("NoCommand")) {
                        break; // PREVENTS UNDO ON FIRST RUN
                        }
                        previous.undo();
                        previous = new NoCommand();
                    break;
            }

            userPosXY.getCoordinates();
            System.out.println("\n\n\n\n");

        } while (direction != '*');
    }

    public static void displayMenu(Position userPosXY) {
        System.out.println("\n====================== Postion Tracker "
                + "======================");
        
        System.out.println("\tMove:\n\t\tW) Up\n\t\tA) Left\n\t\t" +
            "S) Down\n\t\tD) Right\n\t\tF) Go Back");
        
        System.out.println("======================================="
                + "======================");
        
        System.out.print("Current Position: ");
        userPosXY.getCoordinates();
        System.out.print("\nEnter Direction [W,A,S,D][* to Quit]: ");
    }

    public static char getDirection(Scanner keybo) {
        char entry = keybo.next().charAt(0);
        entry = Character.toUpperCase(entry);

        return entry;
    }
}
