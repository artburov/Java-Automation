package tests;

import helpers.FileReader;
import org.junit.Ignore;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Debug {

    @Ignore
    @Test
    public void createFile() {
        File testFile = new File(System.getProperty("user.dir") + "/pom1.xml");
        if (testFile.exists()) {
            System.out.println(testFile.getName());
        } else {
            try {
                testFile.createNewFile();
                System.out.format("New file %s was created ", testFile.getName());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void readFromFile() {
       /* ArrayList<List<String>> saveData = new ArrayList<>();
        List<String> readAll = FileReader.linesFromFile(System.getProperty("user.dir") +
                "/src/main/resources/data/authParameters.txt");
        if (readAll != null) {
            readAll.forEach(x -> {
                List<String> temp = Arrays.asList(x.split(":"));
                saveData.add(temp);
            });
            System.out.println(saveData);
        }*/

        Map<String, String> saveData = new TreeMap<>();
        List<String> readAll = FileReader.linesFromFile(System.getProperty("user.dir") +
                "/src/main/resources/data/authParameters.txt");
        if (readAll != null) {
            readAll.forEach(x -> {
                String[] temp = x.split(":");
                saveData.put(temp[0], temp[1]);
            });
            System.out.println(saveData);
        }
    }
}
