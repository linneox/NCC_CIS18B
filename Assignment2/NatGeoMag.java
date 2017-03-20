package NatGeoCode;

import java.util.*;

import java.util.ArrayList;

public class NatGeoMag implements Subject {

    private ArrayList observers;

    public NatGeoMag() {
        observers = new ArrayList();
    }

    @Override
    public void addObserver(String address) {
        observers.add(address);
    }

    @Override
    public void removeObserver(String address) {
        int i = observers.indexOf(address);

        if (i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public boolean searchSubscriber(String address) {
        boolean found = false; 
        
        if (observers.isEmpty()) {
            return found; 
        } 
        
        for (int i = 0; i < observers.size(); i++) {
            found = observers.get(i).equals(address);
            if (found == true) {
                break;
            }
        }
        return true;
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer;
            observer = (Observer) observers.get(i);
            observer.notify();
        }
    }
}
