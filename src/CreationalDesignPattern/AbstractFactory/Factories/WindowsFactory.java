package CreationalDesignPattern.AbstractFactory.Factories;

import CreationalDesignPattern.AbstractFactory.Products.HardWare;
import CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;
import CreationalDesignPattern.AbstractFactory.Products.WindowsHardware;
import CreationalDesignPattern.AbstractFactory.Products.WindowsOs;

public class WindowsFactory  implements Factory{
    @Override
    public HardWare getHardware() {
        System.out.println("Windows Hardwre added");
        return new WindowsHardware();
    }

    @Override
    public OperatingSystem getOs() {
        System.out.println("Windows OS added");
        return new WindowsOs();
    }
}
