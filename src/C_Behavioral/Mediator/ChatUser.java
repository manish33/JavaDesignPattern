package C_Behavioral.Mediator;

public class ChatUser extends User {
    public ChatUser(int id, String name, Mediator mediator) {
        super(id, name, mediator);
    }

    @Override
    public void send(String msg, int userId) {
        System.out.println(this.name+" is sending msg ->"+msg);
        getMediator().sendMessage(msg,userId);
    }

    @Override
    public void receive(String msg) {
        System.out.println(this.id+ " has recived the message "+ msg);

    }
}
