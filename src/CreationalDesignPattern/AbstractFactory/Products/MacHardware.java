package CreationalDesignPattern.AbstractFactory.Products;

public class MacHardware implements HardWare {
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
