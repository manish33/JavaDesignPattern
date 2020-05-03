package Behavioral.Mediator;

public class Client {
    public static void main(String[] args) {
        Mediator m = new ChatRoom();
        User user1 = new ChatUser(1,"Manish",m);
        User user2 = new ChatUser(2,"Divyesh",m);
        User user3 = new ChatUser(3,"Rohit",m);
        User user4 = new ChatUser(3,"Hetal",m);

        m.addUser(user1);
        m.addUser(user2);
        m.addUser(user3);
        m.addUser(user4);

        user1.send("hi Rohit",2);

    }
}
