package A_CreationalDesignPattern.Singleton.A_SingletonWithoutMultiThreading;

class SingleTon{

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
}

public class Solution {
    public static void main(String[] args) {
        SingleTon instance1= SingleTon.getInstance();
        SingleTon instance2= SingleTon.getInstance();
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());

    }
}
