package B_StructuralDesignPattern.Bridge.PaymentMethods;

public class CardPayment extends Payment {

    @Override
    public void makePayment() {
        System.out.println("making card payment through "+paymentGatway.processPayment());
    }
}
