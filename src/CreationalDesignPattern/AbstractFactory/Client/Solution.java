package CreationalDesignPattern.AbstractFactory.Client;

import CreationalDesignPattern.AbstractFactory.Factories.Factory;
import CreationalDesignPattern.AbstractFactory.Factories.MacFactory;
import CreationalDesignPattern.AbstractFactory.Factories.WindowsFactory;

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
