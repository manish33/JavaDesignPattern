package A_CreationalDesignPattern.AbstractFactoryMethod.Solution;

import java.util.List;

public abstract class BatchProcessor {
    public abstract Parser getParser(String fileName);

    public List<Records> parse(String fileName, String fileType) {
        Parser p = getParser(fileName);
        //better
        return p.parse();

    }
}
