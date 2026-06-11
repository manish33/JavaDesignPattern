package LLDQuestions.SplitWiseMachineCoding.repository;

import LLDQuestions.SplitWiseMachineCoding.model.Expense;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ExpenseRepository {
    private final Map<String, Expense> expenses = new HashMap<>();

    public void save(Expense expense) {
        expenses.put(expense.getId(), expense);
    }

    public Optional<Expense> findById(String id) {
        return Optional.ofNullable(expenses.get(id));
    }

    public List<Expense> findAll() {
        return new ArrayList<>(expenses.values());
    }

    public List<Expense> findByGroup(String groupId) {
        List<Expense> result = new ArrayList<>();
        for (Expense expense : expenses.values()) {
            if (groupId.equals(expense.getGroupId())) {
                result.add(expense);
            }
        }
        return result;
    }
}
