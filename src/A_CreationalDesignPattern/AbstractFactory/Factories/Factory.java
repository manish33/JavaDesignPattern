package A_CreationalDesignPattern.AbstractFactory.Factories;

import A_CreationalDesignPattern.AbstractFactory.Products.HardWare;
import A_CreationalDesignPattern.AbstractFactory.Products.OperatingSystem;



public interface Factory {
    HardWare getHardware();
    OperatingSystem getOs();
}
