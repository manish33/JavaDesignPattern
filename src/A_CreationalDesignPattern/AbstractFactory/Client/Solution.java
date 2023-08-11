package A_CreationalDesignPattern.AbstractFactory.Client;

import A_CreationalDesignPattern.AbstractFactory.Factories.Factory;
import A_CreationalDesignPattern.AbstractFactory.Factories.MacFactory;
import A_CreationalDesignPattern.AbstractFactory.Factories.WindowsFactory;
//Abstract Factory is a creational design pattern that lets you produce families of related objects
// without specifying their concrete classes.
public class Solution {
    public static void main(String[] args) {
        Factory f1 = new WindowsFactory();
        f1.getHardware();
        f1.getOs();
        f1= new MacFactory();
        f1.getHardware();
        f1.getOs();
    }
}
