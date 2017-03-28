/**
 *
 * @author Johnathon Valles
 */

/*	DESCRIPTION: 

	- When implemented, Command provides two
	methods reposible for invoking the methods 
	responsible for incrementing/decrementing
	(X,Y) coordinates. 

	- Undo() executes the previous user input
	as long as it is not the first run. 
*/

public interface Command {
    
    public void execute(); 
    
    public void undo(); 
    
}