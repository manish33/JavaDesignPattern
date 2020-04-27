package CreationalDesignPattern.AbstractFactoryMethod.Solution;

public abstract class BatchProcessor {
    public abstract Parser getParser(String fileName);

    public void parse(String fileName, String fileType) {
        Parser p = getParser(fileName);
        //better
        p.parse();

    }
}
