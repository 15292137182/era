import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.util.*;

/**
 *
 * Created by Administrator on 2017/10/14.
 */
public class ExcelUpload {
    public static void main(String[] args) throws Exception {
        try {
            //需要解析的Excel文件
            File file = new File("E:/用户模板.xls");
            //创建Excel,读取文件
            HSSFWorkbook workbook = new HSSFWorkbook(FileUtils.openInputStream(file));

            List list = new LinkedList();
            List rowNum = new ArrayList();
            //默认读取第一个工作表的sheet
            HSSFSheet sheet = workbook.getSheetAt(0);
            //获取sheet中最后一行的行号
            int lastRowNum = sheet.getLastRowNum();
            for ( int i = 0; i <= lastRowNum; i++ ) {
                HSSFRow row = sheet.getRow(i);
                //获取当前行最后一行的单元格列号
                int lastCellNum = row.getLastCellNum();
                Map<String, Object> map = new HashMap<>();
                for ( int j = 0; j < lastCellNum; j++ ) {
                    HSSFCell cell = row.getCell(j);
                    String cellValue = "";
                    int cellType = cell.getCellType();
                    switch (cellType) {
                        case HSSFCell.CELL_TYPE_STRING:
                            cellValue = String.valueOf(cell.getStringCellValue());
                            break;
                        case HSSFCell.CELL_TYPE_NUMERIC:
                            cellValue = String.valueOf(cell.getNumericCellValue());
                            break;
                    }
                    if (i == 0) rowNum.add(cellValue);
                    else {
                        String of = String.valueOf(rowNum.get(j));
                        String excelModuleVal = ExcelModule.getExcelModuleVal(of);
                        map.put(excelModuleVal, cellValue);
                    }
                    System.out.print(cellValue + "\t");
                }
                if (map.size()!=0) list.add(map);
                System.out.println();
            }
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
