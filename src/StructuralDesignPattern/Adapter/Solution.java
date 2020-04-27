package StructuralDesignPattern.Adapter;

public class Solution {
    public static void main(String[] args) {
        Parser op = new OldParser();
        op.parse();
        op.destroy();
         op = new AdapterParser(new NewParser());
         op.parse();
         op.destroy();

    }
}
