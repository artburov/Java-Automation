package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelReader {
    private final static Logger log = LogManager.getLogger("Excel file reader helper");

    public static List<String> readColumnFromExcel(String filePath, String sheetName) {
        List<String> result = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = workbook.getSheet(sheetName);
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                result.add(sheet.getRow(i).getCell(0).getStringCellValue());
            }


        } catch (IOException e) {
            log.error(e);
        }

        return result;
    }


}
