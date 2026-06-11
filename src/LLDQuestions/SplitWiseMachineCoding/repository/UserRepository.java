package LLDQuestions.SplitWiseMachineCoding.repository;

import LLDQuestions.SplitWiseMachineCoding.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private final Map<String, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> findById(String id) {
        return Optional.ofNullable(users.get(id));
    }

    public User getById(String id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public boolean exists(String id) {
        return users.containsKey(id);
    }
}
