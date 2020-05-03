package Behavioral.ChainOfResponsibility;

public class SubStraction implements Operation {
    Operation nextop;
    @Override
    public int performOperation(int a, int b,String operation) {
        if(operation.toLowerCase()=="sub"){
            return a-b;
        }
        else {
          return   nextop.performOperation(a,b,operation);
        }

    }

    @Override
    public void NextChainOperation(Operation addme) {
        nextop=addme;
    }
}
