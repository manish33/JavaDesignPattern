package C_Behavioral.State;

//State is a behavioral design pattern that allows an object to change the behavior when its internal state changes.
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
