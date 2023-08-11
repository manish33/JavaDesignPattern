package C_Behavioral.Iterator;



public class Client {
    public static void main(String[] args) {
        NameRepository nr = new NameRepository();

        Iterator it = nr.getIterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
