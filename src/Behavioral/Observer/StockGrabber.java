package Behavioral.Observer;

import java.util.ArrayList;

public class StockGrabber implements Subject {
    ArrayList<Observer> listOfObserver;

    StockGrabber(){
        listOfObserver= new ArrayList<>();
    }


    public int getIbmPrice() {
        return ibmPrice;
    }

    public void setIbmPrice(int ibmPrice) {
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public int getAaplPrice() {
        return aaplPrice;
    }

    public void setAaplPrice(int aaplPrice) {
        this.aaplPrice = aaplPrice;
        notifyObserver();
    }

    public int getGoogPrice() {
        return googPrice;
    }

    public void setGoogPrice(int googPrice) {
        this.googPrice = googPrice;
        notifyObserver();
    }

    int ibmPrice;
    int aaplPrice;
    int googPrice;

    @Override
    public void register(Observer o) {
        listOfObserver.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int index = listOfObserver.indexOf(o);
        if(index!=-1){
            listOfObserver.remove(index);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer o: listOfObserver){
            o.update(ibmPrice,aaplPrice,googPrice);
        }

    }
}
