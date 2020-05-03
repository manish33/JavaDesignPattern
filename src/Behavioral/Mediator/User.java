package Behavioral.Mediator;

public abstract class User {

    int id;
    String name;
    Mediator mediator;

    public User(int id, String name, Mediator mediator) {
        this.id = id;
        this.name = name;
        this.mediator = mediator;


    }

    public Mediator getMediator(){
        return mediator;
    }

    public abstract void send(String msg,int userId);
    public abstract void receive(String msg);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
