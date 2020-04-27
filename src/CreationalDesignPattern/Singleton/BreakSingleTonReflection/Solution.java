package CreationalDesignPattern.Singleton.BreakSingleTonReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        SingleTon instance2=null;
        Constructor[] con = SingleTon.class.getDeclaredConstructors();
        try {
        for(Constructor x: con) {
            x.setAccessible(true);

            instance2 = (SingleTon) x.newInstance();
            break;
        }

            }catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());


    }
}
