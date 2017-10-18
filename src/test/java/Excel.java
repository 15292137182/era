import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;

/**
 *
 * Created by Administrator on 2017/10/13.
 */
public class Excel {
    public static void main(String[] args) throws Exception {
        //需要解析的Excel文件
        File file = new File("E:/用户模板.xlsx");
        //创建Excel,读取文件
        XSSFWorkbook workbook = new XSSFWorkbook(FileUtils.openInputStream(file));
        //默认读取第一个工作表的sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取sheet中最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for ( int i = 0; i <=lastRowNum; i++ ) {
            XSSFRow row = sheet.getRow(i);
            //获取当前行最后一行的单元格列号
            int lastCellNum = row.getLastCellNum();
            for ( int j = 0; j < lastCellNum; j++ ) {
                XSSFCell cell = row.getCell(j);
                String cellValue = cell.getStringCellValue();
                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }


    }
}
