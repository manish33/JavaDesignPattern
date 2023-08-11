package B_StructuralDesignPattern.Adapter;

public class OldParser implements Parser {
    @Override
    public String parse() {
        System.out.println("parsed old way");
        return null;
    }

    @Override
    public String destroy() {
        System.out.println("destroyed old way");
        return null;
    }
}
