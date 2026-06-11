package LLDQuestions.SplitWiseMachineCoding.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group {
    private final String id;
    private final String name;
    private final String description;
    private final String createdBy;
    private final List<String> memberIds;
    private final List<String> expenseIds;

    public Group(String id, String name, String description, String createdBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createdBy = createdBy;
        this.memberIds = new ArrayList<>();
        this.expenseIds = new ArrayList<>();
        this.memberIds.add(createdBy);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCreatedBy() { return createdBy; }
    public List<String> getMemberIds() { return Collections.unmodifiableList(memberIds); }
    public List<String> getExpenseIds() { return Collections.unmodifiableList(expenseIds); }

    public void addMember(String userId) {
        if (!memberIds.contains(userId)) {
            memberIds.add(userId);
        }
    }

    public void removeMember(String userId) {
        memberIds.remove(userId);
    }

    public boolean hasMember(String userId) {
        return memberIds.contains(userId);
    }

    public void addExpense(String expenseId) {
        expenseIds.add(expenseId);
    }
}
