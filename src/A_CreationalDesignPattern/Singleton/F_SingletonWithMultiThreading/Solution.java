package A_CreationalDesignPattern.Singleton.F_SingletonWithMultiThreading;

class SingleTon{

    private static SingleTon instance=null;

    private SingleTon(){

    }
    public static SingleTon getInstance(){
        if(instance==null){
            synchronized (SingleTon.class){
                if(instance==null){
                    instance=new SingleTon();
                }
            }

        }
        return instance;
    }
}

public class Solution {
    public static void main(String[] args) {

       Thread t1 = new Thread(()->{
           SingleTon   s1= SingleTon.getInstance();
           System.out.println(s1.hashCode());
       });
        Thread t2 = new Thread(()->{
            SingleTon   s2= SingleTon.getInstance();
            System.out.println(s2.hashCode());
        });

        t1.start();
        t2.start();
    }
}
