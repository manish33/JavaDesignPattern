package B_StructuralDesignPattern.Bridge;

import B_StructuralDesignPattern.Bridge.PaymentGateways.CitiGateway;
import B_StructuralDesignPattern.Bridge.PaymentGateways.HSBCGateWay;
import B_StructuralDesignPattern.Bridge.PaymentMethods.CardPayment;
import B_StructuralDesignPattern.Bridge.PaymentMethods.NetBanking;
import B_StructuralDesignPattern.Bridge.PaymentMethods.Payment;

public class Client {
    public static void main(String[] args) {
        Payment p1 = new CardPayment();
        p1.paymentGatway= new CitiGateway();
       p1.makePayment();


        Payment p2 = new CardPayment();
        p2.paymentGatway= new HSBCGateWay();
        p2.makePayment();


        Payment p3 = new NetBanking();
        p3.paymentGatway= new CitiGateway();
        p3.makePayment();


        Payment p4 = new NetBanking();
        p4.paymentGatway= new HSBCGateWay();
        p4.makePayment();
    }
}
