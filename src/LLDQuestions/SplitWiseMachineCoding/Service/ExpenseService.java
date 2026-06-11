package LLDQuestions.SplitWiseMachineCoding.service;

import LLDQuestions.SplitWiseMachineCoding.exception.InvalidExpenseException;
import LLDQuestions.SplitWiseMachineCoding.model.Expense;
import LLDQuestions.SplitWiseMachineCoding.model.ExpenseMetadata;
import LLDQuestions.SplitWiseMachineCoding.split.Split;
import LLDQuestions.SplitWiseMachineCoding.split.SplitType;
import LLDQuestions.SplitWiseMachineCoding.strategy.SplitStrategy;
import LLDQuestions.SplitWiseMachineCoding.strategy.SplitStrategyFactory;
import LLDQuestions.SplitWiseMachineCoding.repository.ExpenseRepository;

import java.util.List;
import java.util.UUID;

public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final BalanceService balanceService;

    public ExpenseService(ExpenseRepository expenseRepository, BalanceService balanceService) {
        this.expenseRepository = expenseRepository;
        this.balanceService = balanceService;
    }

    public Expense createExpense(double amount, String description, String paidByUserId,
                                 List<String> participantIds, List<Double> values,
                                 SplitType splitType, String groupId, ExpenseMetadata metadata) {

        SplitStrategy strategy = SplitStrategyFactory.getStrategy(splitType);

        if (!strategy.validate(amount, participantIds, values)) {
            throw new InvalidExpenseException(
                    "Invalid split for type " + splitType
                    + ": amount=" + amount
                    + ", participants=" + participantIds.size());
        }

        List<Split> splits = strategy.split(amount, participantIds, values);

        String expenseId = UUID.randomUUID().toString().substring(0, 8);
        Expense expense = new Expense(expenseId, amount, description, paidByUserId,
                splits, splitType, groupId, metadata);

        expenseRepository.save(expense);
        balanceService.recordExpense(paidByUserId, splits, groupId);

        return expense;
    }

    public List<Expense> getExpensesByGroup(String groupId) {
        return expenseRepository.findByGroup(groupId);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
