package Behavioral.Mediator;

import java.util.HashMap;

public class ChatRoom implements Mediator {
    HashMap<Integer, User> userMap = new HashMap<>();
    @Override
    public void sendMessage(String msg, int userId) {
            userMap.get(userId).receive(msg);
    }

    @Override
    public void addUser(User user) {
          userMap.put(user.id,user);
    }
}
