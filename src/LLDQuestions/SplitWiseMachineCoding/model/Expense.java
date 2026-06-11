package LLDQuestions.SplitWiseMachineCoding.model;

import LLDQuestions.SplitWiseMachineCoding.split.Split;
import LLDQuestions.SplitWiseMachineCoding.split.SplitType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Expense {
    private final String id;
    private final double amount;
    private final String description;
    private final String paidByUserId;
    private final List<Split> splits;
    private final SplitType splitType;
    private final String groupId;
    private final ExpenseMetadata metadata;

    public Expense(String id, double amount, String description, String paidByUserId,
                   List<Split> splits, SplitType splitType, String groupId, ExpenseMetadata metadata) {
        this.id = id;
        this.amount = amount;
        this.description = description;
        this.paidByUserId = paidByUserId;
        this.splits = Collections.unmodifiableList(new ArrayList<>(splits));
        this.splitType = splitType;
        this.groupId = groupId;
        this.metadata = metadata;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getPaidByUserId() { return paidByUserId; }
    public List<Split> getSplits() { return splits; }
    public SplitType getSplitType() { return splitType; }
    public String getGroupId() { return groupId; }
    public ExpenseMetadata getMetadata() { return metadata; }

    public boolean isGroupExpense() {
        return groupId != null;
    }
}
