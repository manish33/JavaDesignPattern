package C_Behavioral.Staretergy;
// Strategy design pattern is one of the behavioral design pattern.
// Strategy pattern is used when we have multiple algorithm for a specific task and client decides
// the actual implementation to be used at runtime.
public class Client {
    public static void main(String[] args) {

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFly());

        System.out.println("Bird: " + tweety.tryToFly());

        // This allows dynamic changes for flyingType

        sparky.setFlyingAbility(new ItFlys());

        System.out.println("Dog: " + sparky.tryToFly());
    }
}
