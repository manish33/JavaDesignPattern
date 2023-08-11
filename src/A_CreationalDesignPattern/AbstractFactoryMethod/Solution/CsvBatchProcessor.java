package A_CreationalDesignPattern.AbstractFactoryMethod.Solution;

public class CsvBatchProcessor extends BatchProcessor {
    @Override
    public Parser getParser(String fileName) {
        return new CsvParser(fileName);
    }
}
