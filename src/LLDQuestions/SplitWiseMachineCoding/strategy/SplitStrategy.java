package LLDQuestions.SplitWiseMachineCoding.strategy;

import LLDQuestions.SplitWiseMachineCoding.split.Split;

import java.util.List;

public interface SplitStrategy {
    List<Split> split(double amount, List<String> userIds, List<Double> values);
    boolean validate(double amount, List<String> userIds, List<Double> values);
}
