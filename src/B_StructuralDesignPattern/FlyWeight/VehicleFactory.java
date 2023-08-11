package B_StructuralDesignPattern.FlyWeight;

import java.util.HashMap;

public class VehicleFactory {

    HashMap<Type, Vehicle> objects = new HashMap<>();

    public Vehicle getVehicle(Type type,String color) throws Exception {

        Vehicle v=null;
        switch (type){
            case Bicycle :
                if(objects.containsKey(Type.Bicycle)){
                    v = objects.get(Type.Bicycle);
                    System.out.println("already found");
                }
                else {
                    System.out.println("not found");
                    v = new Bicycle();
                    objects.put(type, v);

                }
                v.setColor(color);

           break;
            case Truck:
                if(objects.containsKey(Type.Truck)){
                    v = objects.get(Type.Truck);
                }
                else {
                    v = new Bicycle();
                    objects.put(type, v);
                }
                v.setColor(color);
                break;

        }
        return v;

    }
}
