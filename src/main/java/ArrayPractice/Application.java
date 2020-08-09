package ArrayPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Application {
    private final static Logger LOGGER = LogManager.getLogger(Application.class);


    public static void main(String[] args) {

        ArrayOne oneArray = new ArrayOne();
        ArrayTwo twoArray = new ArrayTwo("Второй", 2);

        LOGGER.info(oneArray.returnArray(oneArray.stringArray));

        twoArray.getName();
        twoArray.returnOtherArray(twoArray.listArray);
        System.out.println("\n");

        //передается null в метод
        oneArray.splitList(new ArrayList() {
            {
                add(null);
            }
        });

        //вызов из экземпляра класса Б, передать массив из экземпляра класса А
        System.out.println();
        twoArray.splitList(oneArray.returnArray(oneArray.stringArray));

        //добавить вызов из экземпляра класса Б, передать массив new ArrayList<Stirng>
        System.out.println();
        twoArray.splitList(new ArrayList<String>() {
            {
                add("Kiev");
                add("Tokyo");
            }
        });
    }
}