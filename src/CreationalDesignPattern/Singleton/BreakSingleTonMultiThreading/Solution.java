package CreationalDesignPattern.Singleton.BreakSingleTonMultiThreading;

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
        System.out.println("------break it-------");
        Thread t1 = new Thread(()->{
            SingleTon s= SingleTon.getInstance();
            System.out.println(s.hashCode());
        });
        Thread t2 = new Thread(()->{
            SingleTon s= SingleTon.getInstance();
            System.out.println(s.hashCode());
        });
        Thread t3 = new Thread(()->{
            SingleTon s= SingleTon.getInstance();
            System.out.println(s.hashCode());
        });
        Thread t4 = new Thread(()->{
            SingleTon s= SingleTon.getInstance();
            System.out.println(s.hashCode());
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();



    }
}
