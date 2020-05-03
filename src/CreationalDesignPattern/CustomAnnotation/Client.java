package CreationalDesignPattern.CustomAnnotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Client {

    public static void main(String[] args) {
        Class<ApplyonMe> iden = ApplyonMe.class;

      if(iden.isAnnotationPresent(GetUserInfo.class)){
          System.out.println("present!");
      }
      else{
          System.out.println("not present");
      }

      for(Method m : iden.getDeclaredMethods()){
          if(m.isAnnotationPresent(GetUserInfo.class)){
              System.out.println("present in method");
          }
          Annotation annotation = m.getAnnotation(GetUserInfo.class);
          Annotation annotation2 = m.getAnnotation(GetUserInfo2.class);
          GetUserInfo getUserInfo = (GetUserInfo)annotation;
          GetUserInfo2 getUserInfo2 = (GetUserInfo2)annotation2;
          System.out.println(getUserInfo.age());
          System.out.println(getUserInfo.name());
          System.out.println(getUserInfo2.age());
          System.out.println(getUserInfo2.name());

      }

    }
}
