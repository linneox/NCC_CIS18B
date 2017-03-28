/**
 *
 * @author Johnathon Valles
 */

public class Position {
    
    private int x_pos;
    private int y_pos;
    
    public Position() {
        this.x_pos = 0; 
        this.y_pos = 0;
    }

    // *****************************************
    // Methods invoked by a Command Object
    
    public void upDirectionPicked() {
        y_pos++;
    }
    
    public void downDirectionPicked() {
        y_pos--; 
    }
    
    public void leftDirectionPicked() {
        x_pos--; 
    } 
    
    public void rightDirectionPicked() {
        x_pos++;
    }  
    
    // *****************************************
    

    // Returns x-coordinate
    public final int getPosX() {
        return x_pos;
    }

    // Returns y-coordinate.
    public final int getPosY() {
        return y_pos;
    }

    // Prints in (x,y) format. 
    public final void getCoordinates() {
        System.out.print("(" + x_pos + ", " + y_pos + ")");
    }
}