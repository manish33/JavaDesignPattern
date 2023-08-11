package A_CreationalDesignPattern.AbstractFactory.Products;

public class MacOs implements OperatingSystem {
    String product;

    @Override
    public String getProduct() {

        System.out.println("Mac OS added");
        return this.product;
    }

    @Override
    public void setProduct(String product) {
        this.product=product;
    }
}
