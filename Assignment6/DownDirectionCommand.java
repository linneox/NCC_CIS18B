/**
 *
 * @author Johnathon Valles
 */

/*  DESCRIPTION:
    
    - Object responsible for invoking 
    Position's decrement-y and undo
    method to increment-y. 

*/

public class DownDirectionCommand implements Command {
    
    Position pos; 
    
    public DownDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        pos.downDirectionPicked();
    }
    
    @Override
    public void undo() {
        pos.upDirectionPicked();
    }
}
