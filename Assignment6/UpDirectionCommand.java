/**
 *
 * @author Johnathon Valles
 */

/*  DESCRIPTION:
    
    - Object responsible for invoking 
    Position's increment-y and undo
    method to decrement-y. 

*/

public class UpDirectionCommand implements Command {
    
    Position pos; 
    
    public UpDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        pos.upDirectionPicked();
    }
    
    @Override
    public void undo() {
        pos.downDirectionPicked();
    }   
}