package A_CreationalDesignPattern.AbstractFactory.Products;

public class WindowsOs implements OperatingSystem {
    String product;

    @Override
    public String getProduct() {


        return this.product;
    }

    @Override
    public void setProduct(String product) {
        this.product=product;
    }
}
