package uz.customs.customsprice.service.InternationalSurveyS;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;


public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String TITLES = "да Халқаро сўровномалар йўналишида ҳисобот";
    static String[] HEADERs = { "Йўналиш", "Мамлакат", "Сўровнома сони", "Камомад", "Ундирилди", "Назоратда" };
    static String SHEET = "Tutorials";
    public static ByteArrayInputStream tutorialsToExcel(List<InternationalSurveyEntity> tutorials, String FromStart, String ToEnd) {
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
            Sheet sheet = workbook.createSheet(SHEET);
            // Header
            int firstRow = 0;
            int lastRow = 0;
            int firstCol = 0;
            int lastCol = 5;
            sheet.addMergedRegion(new CellRangeAddress(firstRow, lastRow, firstCol, lastCol));
            Row titleDate = sheet.createRow(0);
            Cell cells = titleDate.createCell(0);
            int date  = Calendar.getInstance().get(Calendar.YEAR);
            cells.setCellValue(date + " йил"+" (" + FromStart + " - " +ToEnd + ")" + TITLES);

            XSSFCellStyle myStyle = (XSSFCellStyle) workbook.createCellStyle();
            myStyle.setFillForegroundColor(new XSSFColor(new Color(255, 255, 255)));

            Row headerRow = sheet.createRow(1);
            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }
            int rowIdx = 2;
            for (int i = 0; i < tutorials.size(); i++) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(String.valueOf(tutorials.get(i).getDirectionTypeName()));
                row.createCell(1).setCellValue(String.valueOf(tutorials.get(i).getSendReqCountryNm()));
                row.createCell(2).setCellValue(String.valueOf(tutorials.get(i).getSendReqCountryCode()));
                row.createCell(3).setCellValue(String.valueOf(tutorials.get(i).getSum()));
                row.createCell(4).setCellValue(String.valueOf(tutorials.get(i).getSumАpproved()));
                row.createCell(5).setCellValue(String.valueOf(tutorials.get(i).getSumOnControl()));
                i++;
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}