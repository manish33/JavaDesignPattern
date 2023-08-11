package A_CreationalDesignPattern.AbstractFactory.Products;

public class WindowsHardware implements HardWare {
    String product;

    @Override
    public String getProduct() {
        System.out.println("windows Hardwre added");
        return this.product;
    }

    @Override
    public void setProduct(String product) {
        this.product=product;
    }
}
