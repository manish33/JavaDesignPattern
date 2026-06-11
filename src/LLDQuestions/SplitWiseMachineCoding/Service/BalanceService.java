package LLDQuestions.SplitWiseMachineCoding.service;

import LLDQuestions.SplitWiseMachineCoding.split.Split;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BalanceService {
    // userId -> {otherUserId -> amount}
    // positive = other owes you, negative = you owe other
    private final Map<String, Map<String, Double>> balances = new HashMap<>();

    // groupId -> userId -> {otherUserId -> amount}
    private final Map<String, Map<String, Map<String, Double>>> groupBalances = new HashMap<>();

    public void registerUser(String userId) {
        balances.putIfAbsent(userId, new HashMap<>());
    }

    public void recordExpense(String paidByUserId, java.util.List<Split> splits, String groupId) {
        for (Split split : splits) {
            if (split.getUserId().equals(paidByUserId)) {
                continue;
            }

            String owesUserId = split.getUserId();
            double amount = split.getAmount();

            // Update global balances
            updateBalance(balances, paidByUserId, owesUserId, amount);

            // Update group balances if applicable
            if (groupId != null) {
                groupBalances.putIfAbsent(groupId, new HashMap<>());
                Map<String, Map<String, Double>> gBalance = groupBalances.get(groupId);
                gBalance.putIfAbsent(paidByUserId, new HashMap<>());
                gBalance.putIfAbsent(owesUserId, new HashMap<>());
                updateBalance(gBalance, paidByUserId, owesUserId, amount);
            }
        }
    }

    private void updateBalance(Map<String, Map<String, Double>> sheet,
                               String paidBy, String owes, double amount) {
        sheet.putIfAbsent(paidBy, new HashMap<>());
        sheet.putIfAbsent(owes, new HashMap<>());

        sheet.get(paidBy).merge(owes, amount, Double::sum);
        sheet.get(owes).merge(paidBy, -amount, Double::sum);
    }

    public Map<String, Double> getUserBalance(String userId) {
        return Collections.unmodifiableMap(
                balances.getOrDefault(userId, Collections.emptyMap()));
    }

    public Map<String, Map<String, Double>> getAllBalances() {
        return Collections.unmodifiableMap(balances);
    }

    public Map<String, Map<String, Double>> getGroupBalances(String groupId) {
        return Collections.unmodifiableMap(
                groupBalances.getOrDefault(groupId, Collections.emptyMap()));
    }
}
