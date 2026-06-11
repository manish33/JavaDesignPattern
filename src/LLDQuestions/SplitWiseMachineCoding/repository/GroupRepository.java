package LLDQuestions.SplitWiseMachineCoding.repository;

import LLDQuestions.SplitWiseMachineCoding.model.Group;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GroupRepository {
    private final Map<String, Group> groups = new HashMap<>();

    public void save(Group group) {
        groups.put(group.getId(), group);
    }

    public Optional<Group> findById(String id) {
        return Optional.ofNullable(groups.get(id));
    }

    public Group getById(String id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Group not found: " + id));
    }

    public List<Group> findAll() {
        return new ArrayList<>(groups.values());
    }

    public List<Group> findByMember(String userId) {
        List<Group> result = new ArrayList<>();
        for (Group group : groups.values()) {
            if (group.hasMember(userId)) {
                result.add(group);
            }
        }
        return result;
    }
}
