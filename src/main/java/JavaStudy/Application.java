package JavaStudy;

public class Application {

    private static String name;

    public static void main(String[] args) {

        try {
            System.out.println(name.length());
        } catch (Exception n) {
            System.out.println("Catch exception");
            n.printStackTrace();
        }

    }
}
