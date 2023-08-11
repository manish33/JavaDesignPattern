package B_StructuralDesignPattern.FlyWeight;

public class Client {

    public static void main(String[] args) throws Exception {
        VehicleFactory f = new VehicleFactory();
        Vehicle v1=f.getVehicle(Type.Bicycle,"red");
        System.out.println(v1.getColor());
        Vehicle v2= f.getVehicle(Type.Bicycle,"brown");
        System.out.println(v2.getColor());

        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());

    }
}
