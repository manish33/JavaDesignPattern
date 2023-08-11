package A_CreationalDesignPattern.Singleton.G_UsingEnum;
// enum isntances are intialized before even single thread access it
// enum instances are immutable
enum  SingleTon{
    Instance;
    Integer x;
    public Integer dosomething(Integer x){
        this.x=x;
        System.out.println("doind with instance");
        return this.x;

    }
}

public class Solution {
    public static void main(String[] args) {

       Thread t1 = new Thread(()->{
           SingleTon s1= SingleTon.Instance;
           System.out.println(s1.dosomething(55));
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
