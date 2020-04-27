package StructuralDesignPattern.Adapter;

public class AdapterParser implements Parser {
     NewParser parser;
    AdapterParser(NewParser parser){
        this.parser=parser;
    }
    @Override
    public String parse() {

        return parser.dofun();
    }

    @Override
    public String destroy() {

        return parser.dodestroy();
    }
}
