package StructuralDesignPattern.Bridge.PaymentGateways;

public class HSBCGateWay implements Gateway {
    @Override
    public String processPayment() {
        return "HSBCway!";
    }
}
