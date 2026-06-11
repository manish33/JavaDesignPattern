package LLDQuestions.SplitWiseMachineCoding.strategy;

import LLDQuestions.SplitWiseMachineCoding.split.Split;

import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(double amount, List<String> userIds, List<Double> values) {
        int n = userIds.size();
        double perHead = Math.round(amount * 100.0 / n) / 100.0;
        double remainder = Math.round((amount - perHead * n) * 100.0) / 100.0;

        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double share = (i == 0) ? perHead + remainder : perHead;
            splits.add(new Split(userIds.get(i), share));
        }
        return splits;
    }

    @Override
    public boolean validate(double amount, List<String> userIds, List<Double> values) {
        return userIds != null && !userIds.isEmpty() && amount > 0;
    }
}
