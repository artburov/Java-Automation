package helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
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

    private static boolean isCellString(XSSFCell cell) {
        return cell.getCellType() == CellType.STRING;
    }

    public static List<Object[]> readProviderDataFromExcel() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/data/excelParam.xlsx";
        String sheetName = "Sheet1";

        List<Object[]> result = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
            XSSFSheet sheet = workbook.getSheet(sheetName);

            //loop for all rows
            for (int i = 0; i <= sheet.getLastRowNum(); i++) {

                Object[] temp = new Object[3];
                List<String> labels = new ArrayList<>();

                //loop for all columns
                for (int a = 0; a < sheet.getRow(i).getLastCellNum(); a++) {
                    XSSFCell cell = sheet.getRow(i).getCell(a);

                    //save data from first and second columns (title and comments) to the temporary array
                    if (a < 2) {
                        if (isCellString(cell)) {
                            temp[a] = cell.getStringCellValue();
                        } else {
                            temp[a] = (int) cell.getNumericCellValue();
                        }
                    } else {
                        //other data are saving to the temporary label array
                        labels.add(isCellString(cell)
                                ? cell.getStringCellValue()
                                : String.valueOf(cell.getNumericCellValue()));
                    }
                }
                //0 and 1 are title and comments data and 3 are the labels data
                temp[2] = labels;
                result.add(temp);
            }

        } catch (IOException e) {
            log.error(e);
        }
        return result;
    }
}
