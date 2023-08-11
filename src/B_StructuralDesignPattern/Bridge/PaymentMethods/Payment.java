package B_StructuralDesignPattern.Bridge.PaymentMethods;

import B_StructuralDesignPattern.Bridge.PaymentGateways.Gateway;

public abstract class Payment {
    public Gateway paymentGatway;
   abstract public void makePayment();
}
