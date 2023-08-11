package A_CreationalDesignPattern.Singleton.D_ProtectAgainstReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingleTon{

    private static SingleTon instance=null;

    private SingleTon() throws Exception {
        if(instance!=null){
            throw new Exception("don't dare you break Sinleton");
        }
    }

    public static SingleTon getInstance() throws Exception {
        if(instance==null){
            instance=new SingleTon();
        }
        return instance;
    }
}

public class Solution {
    public static void main(String[] args) throws Exception {
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
              catch (Exception e){
                  System.out.println("i'm sorry!");
              }

        System.out.println(instance1.hashCode());
        if(instance2!=null)
        System.out.println(instance2.hashCode());


    }
}
