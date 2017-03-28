package CIS18B_Assignment06;

/**
 *
 * @author Johnathon Valles
 */
public class UpDirectionCommand implements Command {
    
    Position pos; 
    
    public UpDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        this.pos.upDirectionPicked();
    }
    
}
