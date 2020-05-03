package Behavioral.ChainOfResponsibility;

public interface Operation {
    int performOperation(int a, int b,String operation);
    void NextChainOperation(Operation addme);
}
