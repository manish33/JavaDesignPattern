package LLDQuestions.SplitWiseMachineCoding.strategy;

import LLDQuestions.SplitWiseMachineCoding.split.Split;

import java.util.ArrayList;
import java.util.List;

public class PercentSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> split(double amount, List<String> userIds, List<Double> values) {
        List<Split> splits = new ArrayList<>();
        for (int i = 0; i < userIds.size(); i++) {
            double share = Math.round(amount * values.get(i)) / 100.0;
            splits.add(new Split(userIds.get(i), share));
        }
        return splits;
    }

    @Override
    public boolean validate(double amount, List<String> userIds, List<Double> values) {
        if (userIds == null || values == null || userIds.size() != values.size()) {
            return false;
        }
        double sum = values.stream().mapToDouble(Double::doubleValue).sum();
        return Math.abs(sum - 100.0) < 0.01;
    }
}
