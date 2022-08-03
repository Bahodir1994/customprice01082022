package uz.customs.customsprice.service.internationalSurveyS;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserExelExport {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    private List<InternationalSurveyEntity> internationalSurveyEntityList;

    public UserExelExport(List<InternationalSurveyEntity> internationalSurveyEntityList) {
        this.internationalSurveyEntityList = internationalSurveyEntityList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Users");
    }
    private void  writeHeaderRow() {
        Row row =sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Йўналиш");
    }

    private void  writeDateRows() {

    }

    public  void  export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDateRows();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
