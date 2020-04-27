package CreationalDesignPattern.Singleton.ProtectAgainstSerialization;

import java.io.*;

class SingleTon implements Serializable {

    private static SingleTon instance=null;

    private SingleTon(){
        System.out.println("instance created");
    }

    public static SingleTon getInstance(){
        if(instance==null){
            instance=new SingleTon();
        }
        return instance;
    }
    private Object readResolve() {
        return this.instance;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SingleTon instance1= SingleTon.getInstance();
        SingleTon instance2=null;

        OutputStream out;
        ObjectOutputStream Oo = new ObjectOutputStream(new FileOutputStream("abc.ser"));
        Oo.writeObject(instance1);
        ObjectInputStream Oi = new ObjectInputStream(new FileInputStream("abc.ser"));
        instance2= (SingleTon)Oi.readObject();


        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


    }
}
