package CreationalDesignPattern.AbstractFactoryMethod.Solution;

import java.util.List;

public class CsvParser implements Parser {
    String fileName;
    public CsvParser(String fileName) {
        this.fileName=fileName;
    }
    @Override
    public List<Records> parse() {
        System.out.println("parsed the  csv record");
        return null;
    }

}
