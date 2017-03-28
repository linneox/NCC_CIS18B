package CIS18B_Assignment06;

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
    
    public void upDirectionPicked() {
        this.y_pos++;
    }
    
    public void downDirectionPicked() {
        this.y_pos--; 
    }
    
    public void leftDirectionPicked() {
        this.x_pos--; 
    } 
    
    public void rightDirectionPicked() {
        this.x_pos++;
    }  
    
    public final int getPosX() {
        return this.x_pos;
    }
    
    public final int getPosY() {
        return this.y_pos;
    }
    
    public final void getCoordinates() {
        System.out.print("(" + this.x_pos + ", " + this.y_pos + ")");
    }
}
