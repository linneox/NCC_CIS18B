/**
 *
 * @author Johnathon Valles
 */

/* DESCRIPTION:
	
	- Sole purpose of this class is to provide 
	a "null object". 
	
	- Usefull when checking whether to execute 
	undo() on first run. 
*/

public class NoCommand implements Command {

    @Override 
    public void execute() {}
    
    @Override
    public void undo() {}
   
}