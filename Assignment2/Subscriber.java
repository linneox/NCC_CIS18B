package NatGeoCode;

/**
 *
 * @author Johnathon Valles
 */
public class Subscriber implements Observer {
    private String subscriberAddress;
    private NatGeoMag magazine;
    
    public Subscriber(String address, NatGeoMag magazine) {
        this.subscriberAddress = address;
        this.magazine = magazine; 
        magazine.addObserver(address);
    }
    
    public void update(String address) {
        
    }
}
