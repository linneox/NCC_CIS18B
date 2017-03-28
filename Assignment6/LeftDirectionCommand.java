/**
 *
 * @author Johnathon Valles
 */

/*  DESCRIPTION:
    
    - Object responsible for invoking 
    Position's decrement-x and undo
    method to increment-x. 

*/

public class LeftDirectionCommand implements Command {
    
    Position pos; 
    
    public LeftDirectionCommand(Position pos) {
        this.pos = pos; 
    } 
    
    @Override
    public void execute() {
        pos.leftDirectionPicked();
    }
    
    @Override
    public void undo() {
        pos.rightDirectionPicked(); 
    }
}
