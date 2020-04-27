package CreationalDesignPattern.AbstractFactoryMethod.Solution;

import java.util.List;

public class TextParser implements Parser {

    String fileName;
    public TextParser(String fileName) {
        this.fileName=fileName;
    }

    @Override
    public List<Records> parse() {
        System.out.println("parsed the text records");
        return null;
    }
}
