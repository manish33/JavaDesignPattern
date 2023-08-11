package C_Behavioral.Observer;

public class Clinet {

    public static void main(String[] args) {
        StockGrabber sg = new StockGrabber();
        StockObserver observer1= new StockObserver(sg);
        StockObserver observer2= new StockObserver(sg);
        sg.setAaplPrice(100);
        sg.setGoogPrice(200);
    }
}
