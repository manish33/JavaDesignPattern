package LLDQuestions.SplitWiseMachineCoding.ExpenseTypesClasses;
import LLDQuestions.SplitWiseMachineCoding.*;
import LLDQuestions.SplitWiseMachineCoding.Split.EqualSplit;
import LLDQuestions.SplitWiseMachineCoding.Split.Split;

import java.util.List;
public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits, ExpenseMetadata expenseMetadata) {
        super(amount, paidBy, splits, expenseMetadata);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}
