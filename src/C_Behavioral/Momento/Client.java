package C_Behavioral.Momento;

public class Client {
    public static void main(String[] args) {
        Originator originator = new Originator(1, "name","Content1");
        CareTaker careTaker = new CareTaker();

        careTaker.add(originator.createMemento());

        originator.setContent(" Content 2");
        careTaker.add(originator.createMemento());

        originator.setContent("Content 3");
        System.out.println("Current State: " + originator.getContent());

        originator.restore(careTaker.get(0));
        System.out.println("First saved State: " + originator.getContent());
        originator.restore(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getContent());
    }
}
