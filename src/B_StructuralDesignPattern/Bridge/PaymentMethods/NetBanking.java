package B_StructuralDesignPattern.Bridge.PaymentMethods;

public class NetBanking extends Payment {
    @Override
    public void makePayment() {
        System.out.println("Make Netbanking payment through "+ paymentGatway.processPayment());
    }
}
