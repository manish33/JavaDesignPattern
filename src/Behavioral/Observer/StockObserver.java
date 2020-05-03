package Behavioral.Observer;

public class StockObserver implements Observer {

    StockObserver(StockGrabber sb){
        sb.register(this);
    }

    @Override
    public void update(double ibmPrice, double aaplPrice, double googPrice) {
        printStockPrice(ibmPrice,aaplPrice,googPrice);
    }

    private void printStockPrice(double ibmPrice, double aaplPrice, double googPrice) {
        System.out.println("ibm: "+ibmPrice+" applPrice: "+aaplPrice+" googPrice "+googPrice);
    }
}
