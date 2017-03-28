package CIS18B_Assignment06;

/**
 *
 * @author Johnathon Valles
 */
public class DownDirectionCommand implements Command {
    
    Position pos; 
    
    public DownDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        this.pos.downDirectionPicked();
    }
}
