package StructuralDesignPattern.Bridge.PaymentGateways;

public class CitiGateway implements Gateway {
    @Override
    public String processPayment() {
        return "citiway!";
    }
}
