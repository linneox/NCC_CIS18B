package pos;

/**
 *
 * @author JAV
 */
public abstract class Pizza {

    String description = "DESCRIPTION NOT SET";
    public String getDescription() {
        return description;
    }
    
    public abstract double cost();
}
