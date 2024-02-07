package LLDQuestions.SplitWiseMachineCoding.Split;

import LLDQuestions.SplitWiseMachineCoding.Split.Split;
import LLDQuestions.SplitWiseMachineCoding.User;

public class PercentSplit extends Split {
    double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}
