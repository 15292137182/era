import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/10/14.
 */
public class ExcelXLSX {
    public static void main(String[] args) throws Exception {
        InputStream is = new FileInputStream("E:/用户模板.xlsx");
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        // 获取每一个工作薄
        for ( int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++ ) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            // 获取当前工作薄的每一行
            for ( int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    XSSFCell one = xssfRow.getCell(0);
                    //读取第一列数据
                    XSSFCell two = xssfRow.getCell(1);
                    //读取第二列数据
                    XSSFCell three = xssfRow.getCell(2);
                    //读取第三列数据
                    System.out.println(one);
                    System.out.println(two);
                    System.out.println(three);

                }
            }
        }
    }

    //转换数据格式
    private String getValue(XSSFCell xssfRow) {

        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }
}
