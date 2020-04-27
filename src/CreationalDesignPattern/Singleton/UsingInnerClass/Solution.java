package CreationalDesignPattern.Singleton.UsingInnerClass;

class SingleTon{

    private SingleTon(){
    }

   private static  class Helperclass {
        private static final SingleTon instance= new SingleTon();
    }
    public static SingleTon getInstance(){
        return Helperclass.instance;
    }
}

public class Solution {
    public static void main(String[] args) {

       Thread t1 = new Thread(()->{
           SingleTon s1= SingleTon.getInstance();
           System.out.println(s1.hashCode());
       });
        Thread t2 = new Thread(()->{
            SingleTon s2= SingleTon.getInstance();
            System.out.println(s2.hashCode());
        });

        t1.start();
        t2.start();
    }
}
