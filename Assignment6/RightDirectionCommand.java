/**
 *
 * @author Johnathon Valles
 */

/*  DESCRIPTION:
    
    - Object responsible for invoking 
    Position's increment-x and undo
    method to decrement-x. 

*/

public class RightDirectionCommand implements Command {
    
    Position pos; 
    
    public RightDirectionCommand(Position pos) {
        this.pos = pos; 
    }
   
    
    @Override
    public void execute() {
        pos.rightDirectionPicked();
    }
    
    @Override
    public void undo() {
        pos.leftDirectionPicked();
    }
    
}
