package StructuralDesignPattern.FlyWeight;

public class Truck implements Vehicle {
    private String color;
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public int getTyres() {
        return 0;
    }
}
