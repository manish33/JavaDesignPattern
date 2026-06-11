package LLDQuestions.SplitWiseMachineCoding.service;

import LLDQuestions.SplitWiseMachineCoding.model.Group;
import LLDQuestions.SplitWiseMachineCoding.repository.GroupRepository;
import LLDQuestions.SplitWiseMachineCoding.repository.UserRepository;

import java.util.List;

public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }

    public Group createGroup(String groupId, String name, String description, String createdByUserId) {
        userRepository.getById(createdByUserId); // validate user exists
        Group group = new Group(groupId, name, description, createdByUserId);
        groupRepository.save(group);
        return group;
    }

    public void addMember(String groupId, String userId) {
        userRepository.getById(userId); // validate user exists
        Group group = groupRepository.getById(groupId);
        group.addMember(userId);
    }

    public void removeMember(String groupId, String userId) {
        Group group = groupRepository.getById(groupId);
        group.removeMember(userId);
    }

    public Group getGroup(String groupId) {
        return groupRepository.getById(groupId);
    }

    public List<Group> getGroupsForUser(String userId) {
        return groupRepository.findByMember(userId);
    }
}
