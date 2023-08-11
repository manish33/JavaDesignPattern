package A_CreationalDesignPattern.AbstractFactory.Factories;

import A_CreationalDesignPattern.AbstractFactory.Products.HardWare;
import A_CreationalDesignPattern.AbstractFactory.Products.MacHardware;
import A_CreationalDesignPattern.AbstractFactory.Products.MacOs;
import A_CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;

public class MacFactory implements Factory {
    @Override
    public HardWare getHardware() {
        System.out.println("Mac Hardwre added");
        return new MacHardware();
    }

    @Override
    public OperatingSystem getOs() {
        System.out.println("Mac OS added");
        return new MacOs();
    }
}
