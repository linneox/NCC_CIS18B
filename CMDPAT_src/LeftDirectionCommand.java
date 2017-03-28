package CIS18B_Assignment06;

/**
 *
 * @author Johnathon Valles
 */
public class LeftDirectionCommand implements Command {
    
    Position pos; 
    
    public LeftDirectionCommand(Position pos) {
        this.pos = pos; 
    }
    
    @Override
    public void execute() {
        this.pos.leftDirectionPicked();
    }
}
