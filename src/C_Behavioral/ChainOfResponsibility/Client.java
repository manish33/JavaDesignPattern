package C_Behavioral.ChainOfResponsibility;

public class Client {

    public static void main(String[] args) {
        Operation add = new Addition();
        Operation sub = new SubStraction();
        Operation mul = new Multiplication();
        Operation div = new Divison();
        add.NextChainOperation(sub);
        sub.NextChainOperation(mul);
        mul.NextChainOperation(div);

        System.out.println( add.performOperation(5,4,"Mul"));
    }
}
