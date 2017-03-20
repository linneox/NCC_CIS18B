package NatGeoCode;


public interface Subject {

    public void addObserver(String obs);

    public void removeObserver(String obs);

    public void notifyObservers();
    
    public boolean searchSubscriber(String address);

}
