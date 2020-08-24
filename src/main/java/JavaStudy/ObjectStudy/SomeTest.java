package JavaStudy.ObjectStudy;

public class SomeTest {

    private String myName;
    private int age;


    public SomeTest() {
        System.out.println("Constructor test");
        setName("sdf");
    }

    public SomeTest(int age) {
        this.age = age;
    }

    public SomeTest(String myName) {
         this.myName = myName;
    }

    public SomeTest setName(String name) {
        this.myName = name;
        return this;
    }

    public String getName() {
        return myName;
    }




}
