package LLDQuestions.SplitWiseMachineCoding.service;

import LLDQuestions.SplitWiseMachineCoding.model.User;
import LLDQuestions.SplitWiseMachineCoding.repository.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public User getUser(String userId) {
        return userRepository.getById(userId);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean userExists(String userId) {
        return userRepository.exists(userId);
    }
}
