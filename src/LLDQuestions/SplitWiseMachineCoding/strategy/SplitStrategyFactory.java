package LLDQuestions.SplitWiseMachineCoding.strategy;

import LLDQuestions.SplitWiseMachineCoding.split.SplitType;

import java.util.EnumMap;
import java.util.Map;

public class SplitStrategyFactory {
    private static final Map<SplitType, SplitStrategy> STRATEGIES = new EnumMap<>(SplitType.class);

    static {
        STRATEGIES.put(SplitType.EQUAL, new EqualSplitStrategy());
        STRATEGIES.put(SplitType.EXACT, new ExactSplitStrategy());
        STRATEGIES.put(SplitType.PERCENT, new PercentSplitStrategy());
    }

    public static SplitStrategy getStrategy(SplitType type) {
        SplitStrategy strategy = STRATEGIES.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown split type: " + type);
        }
        return strategy;
    }
}
