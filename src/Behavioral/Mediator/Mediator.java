package Behavioral.Mediator;

import java.util.HashMap;
import java.util.Map;

public interface Mediator {
    public void sendMessage(String msg, int userId);

    void addUser(User user);
}
