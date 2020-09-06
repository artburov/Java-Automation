package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileReader {
    protected final static Logger log = LogManager.getLogger("Filer reader helper");


    public static List<String> linesFromFile(String filePath) {
        try {
            return Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }

    public static Map<String, String> loadDataForProvider() {
        String path = System.getProperty("user.dir") + "/src/main/resources/data/authParameters.txt";

        Map<String, String> result = new TreeMap<>();
        linesFromFile(path).forEach(line -> {
            String[] temp = line.split(":");
            result.put(temp[0], temp[1]);
        });
        return result;
    }
}
