package CreationalDesignPattern.Singleton.UsingEnum;

enum  SingleTon{
    Instance;

    public void dosomething(){
        System.out.println("doind with instance");
    }
}

public class Solution {
    public static void main(String[] args) {

       Thread t1 = new Thread(()->{
           SingleTon s1= SingleTon.Instance;
           System.out.println(s1.hashCode());
       });
        Thread t2 = new Thread(()->{
            SingleTon s2= SingleTon.Instance;
            System.out.println(s2.hashCode());
        });

        t1.start();
        t2.start();
    }
}
