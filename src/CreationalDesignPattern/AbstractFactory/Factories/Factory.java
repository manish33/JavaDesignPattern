package CreationalDesignPattern.AbstractFactory.Factories;

import CreationalDesignPattern.AbstractFactory.Products.HardWare;
import CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;



public interface Factory {
    HardWare getHardware();
    OperatingSystem getOs();
}
