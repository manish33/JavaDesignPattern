package A_CreationalDesignPattern.AbstractFactoryMethod.Solution;

import java.util.List;

public class Solution {

    public static void main(String[] args) {
        BatchProcessor b1 = new TextBatchProcessor();
        b1.parse("abc","text");
        b1= new CsvBatchProcessor();
        List<Records> parse = b1.parse("cde", "csv");
    }
}
