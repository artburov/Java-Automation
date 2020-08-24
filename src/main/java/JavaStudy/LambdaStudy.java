package JavaStudy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaStudy {
    protected static final Logger log = LogManager.getLogger("Lamdba Study");

    @FunctionalInterface
    public interface IAdd {
        public int add(int a, int b);
    }

    @FunctionalInterface
    public interface IFactorial {
        public int sumarize(int a);
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("Example 1");
        IAdd summary = (a, b) -> a + b;
        System.out.println(summary.add(6, 3));

        System.out.println();
        System.out.println("Example 2");
        IFactorial factorial = value -> {
            int result = 1;

            for (int i = 1; i <= value; i++) {
                result = result * i;
            }
            return result;
        };

        System.out.println(factorial.sumarize(5));

        System.out.println();
        System.out.println("Example 3");
        IntStream.of(10, 20, 5, 33, 17).filter(x -> x > 20).map(x -> x + 10).limit(2).forEach(System.out::println);

        System.out.println();
        System.out.println("Example 4");
        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");
        list.add("Five");
        list.add("Six");
        list.add("Seven");
        list.add("Eight");
        list.add("Nine");
        list.add("Ten");
        Stream stream = list.stream();

        List<String> list2 = new ArrayList<>();
        Stream stream2 = list2.stream();

        stream.filter(x -> x.toString().length() == 3)
                .filter(x -> x != "Ten")
                .map(x -> "Element № " + x)
                .forEach(x -> list2.add((String) x));
        System.out.println("***");
        stream2.map(x -> x + "!").limit(1).forEach(System.out::println);

        System.out.println();
        System.out.println("Example 5");

        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("Art", 30);
        myMap.put("Susan", 33);
        myMap.put("John", 25);
        myMap.put("Daniela", 21);
        myMap.forEach((key, value) -> {

//            System.out.println(key + " : " + value);

            log.info(key + " : " + value);
        });








    }
}
