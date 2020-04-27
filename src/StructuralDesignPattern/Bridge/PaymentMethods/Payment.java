package StructuralDesignPattern.Bridge.PaymentMethods;

import StructuralDesignPattern.Bridge.PaymentGateways.Gateway;

public abstract class Payment {
    public Gateway paymentGatway;
   abstract public void makePayment();
}
