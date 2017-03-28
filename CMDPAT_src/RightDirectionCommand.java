package CIS18B_Assignment06;

/**
 *
 * @author Johnathon Valles
 */
public class RightDirectionCommand implements Command {
    
    Position pos; 
    
    public RightDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        this.pos.rightDirectionPicked();
    }
}
