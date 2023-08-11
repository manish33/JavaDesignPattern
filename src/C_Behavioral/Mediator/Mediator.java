package C_Behavioral.Mediator;

public interface Mediator {
    public void sendMessage(String msg, int userId);

    void addUser(User user);
}
