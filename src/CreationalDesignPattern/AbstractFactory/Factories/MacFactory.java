package CreationalDesignPattern.AbstractFactory.Factories;

import CreationalDesignPattern.AbstractFactory.Products.HardWare;
import CreationalDesignPattern.AbstractFactory.Products.MacHardware;
import CreationalDesignPattern.AbstractFactory.Products.MacOs;
import CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;

import java.lang.management.OperatingSystemMXBean;

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
