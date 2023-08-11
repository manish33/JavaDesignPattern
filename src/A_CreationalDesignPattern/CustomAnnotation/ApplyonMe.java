package A_CreationalDesignPattern.CustomAnnotation;

public class ApplyonMe {
    String name;
    String age;

    @GetUserInfo(name = "changed", age = 25)
    @GetUserInfo2(name = "changed2", age = 29)
    public void applyOnme(){
        System.out.println("wow!");
    }

}
