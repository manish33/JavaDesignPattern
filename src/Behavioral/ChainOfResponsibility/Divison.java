package Behavioral.ChainOfResponsibility;

public class Divison implements Operation {

    @Override
    public int performOperation(int a, int b,String operation) {

          return a/b;
    }

    @Override
    public void NextChainOperation(Operation addme) {

    };

}

