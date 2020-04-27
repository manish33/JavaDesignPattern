package CreationalDesignPattern.AbstractFactoryMethod.Problem;

public class BatchProcessor {
    public void parse(String fileName,String fileType) {
        Parser p=null;
        if(fileType=="text"){
           p = new TextParser(fileName);
        }
        else if(fileType=="csv"){
            p = new CsvParser(fileName);
        }

        //,,,,,,,,will you create new condition for each of this. shame on you. think better

        p.parse();
    }
}
