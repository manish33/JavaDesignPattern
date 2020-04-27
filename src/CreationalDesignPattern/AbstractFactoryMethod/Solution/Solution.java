package CreationalDesignPattern.AbstractFactoryMethod.Solution;

public class Solution {

    public static void main(String[] args) {
        BatchProcessor b1 = new TextBatchProcessor();
        b1.parse("abc","text");
        b1= new CsvBatchProcessor();
        b1.parse("cde","csv");
    }
}
