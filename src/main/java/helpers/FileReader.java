package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReader {
    private final static Logger log = LogManager.getLogger("File reader helper");

    public static List<String> linesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public static List<Object[]> loadDataForAuthProvider() {
        String path = System.getProperty("user.dir") + "/src/main/resources/data/authParameters.txt";

        List<Object[]> result = new ArrayList<>();
        linesFromFile(path).forEach(line -> {
            String[] firstPart = line.split(":");
            Object[] temp = new Object[]{
                    firstPart[0].trim(), firstPart[1].trim()
            };

            result.add(temp);
        });
        return result;
    }

    public static List<Object[]> loadDataForCreateIssuesProvider() {
        String path = System.getProperty("user.dir") + "/src/main/resources/data/gitCreateIssues.txt";

        List<Object[]> result = new ArrayList<>();
        linesFromFile(path).forEach(value -> {
            String[] firstPart = value.split(", ");
            String[] secondPart = firstPart[2].split(";");
            Object[] temp = new Object[]{
                    firstPart[0].trim(), firstPart[1].trim(), Arrays.asList(secondPart)
            };
            result.add(temp);

        });
        return result;
    }
}