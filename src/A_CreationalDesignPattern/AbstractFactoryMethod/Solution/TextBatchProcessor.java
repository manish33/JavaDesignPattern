package A_CreationalDesignPattern.AbstractFactoryMethod.Solution;

public class TextBatchProcessor extends BatchProcessor {
    @Override
    public Parser getParser(String fileName) {
        return new TextParser("");
    }
}
