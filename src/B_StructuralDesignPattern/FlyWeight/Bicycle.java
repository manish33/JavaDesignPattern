package B_StructuralDesignPattern.FlyWeight;

public class Bicycle implements Vehicle {
    private String color;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    @Override
    public int getSpeed() {
        return 100;
    }

    @Override
    public int getTyres() {
        return 2;
    }
}
