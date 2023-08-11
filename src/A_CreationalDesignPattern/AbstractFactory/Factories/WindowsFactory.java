package A_CreationalDesignPattern.AbstractFactory.Factories;

import A_CreationalDesignPattern.AbstractFactory.Products.HardWare;
import A_CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;
import A_CreationalDesignPattern.AbstractFactory.Products.WindowsHardware;
import A_CreationalDesignPattern.AbstractFactory.Products.WindowsOs;

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
