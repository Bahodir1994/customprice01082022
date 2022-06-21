package uz.customs.customsprice.service.InternationalSurveyS;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import uz.customs.customsprice.entity.InternationalSurveyEntity.InternationalSurveyEntity;
import uz.customs.customsprice.repository.InternationalSurveyRepo.InternationalSurveyRepo;

import java.io.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InternationalSurveyReportXML {

    @Autowired
    InternationalSurveyRepo internationalSurveyRepo;

    private String reportPath = "C:\\Users\\User\\Documents\\docs";
    public String generateReport(String executiveTerritoryCode,
                                 Date FromStart,
                                 Date ToEnd) {
        List<InternationalSurveyEntity> employees = internationalSurveyRepo.queryInternationalSurveyEntityByExecutiveTerritoryCodeAndXbbMailDateBetween(executiveTerritoryCode, FromStart, ToEnd);


        try {
            File file = ResourceUtils.getFile("src/main/resources/templates/InterantionalSurveyReportJRXML/reportIS.jrxml");
            InputStream input = new FileInputStream(file);

            // Compile the Jasper report from .jrxml to .japser
            JasperReport jasperReport = JasperCompileManager.compileReport(input);

            // Get your data source
            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(employees);
            Collection<?> distinctSymbolRespCounts = null;
            JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(distinctSymbolRespCounts);

            // Add parameters
            Calendar calendar = new GregorianCalendar();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
            DateFormat dateFormatYear = new SimpleDateFormat("yyyy");

            String FrmS = dateFormat.format(FromStart);
            String ToE = dateFormat.format(ToEnd);
            String Yr = dateFormat.format(calendar.getTime().getYear());

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("FromStart", FrmS);
            parameters.put("ToEnd", ToE);
            parameters.put("Year", Yr);

            // Fill the report
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

            // Export the report to a PDF file
            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "\\Empployee.pdf");
            System.out.println("PDF File Generated !!");

            JasperExportManager.exportReportToXmlFile(jasperPrint, reportPath + "\\Employee.xml", true);
            System.out.println("XML File Generated !!");

            JasperExportManager.exportReportToHtmlFile(jasperPrint, reportPath + "\\Employee.html");
            System.out.println("HTML Generated");

            xlsx(jasperPrint);
            csv(jasperPrint);

            return "Report successfully generated @path= " + reportPath;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    private void csv(JasperPrint jasperPrint) throws JRException {
        JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(reportPath + "\\Employee.csv"));

        SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
        configuration.setFieldDelimiter(",");
        exporter.setConfiguration(configuration);
        exporter.exportReport();
    }

    // Ref: https://www.programcreek.com/java-api-examples/?class=net.sf.jasperreports.export.SimpleXlsxReportConfiguration&method=setOnePagePerSheet
    private void xlsx(JasperPrint jasperPrint) throws JRException {
        // Exports a JasperReports document to XLSX format. It has character output type and exports the document to a grid-based layout.
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(reportPath + "\\Employee.xlsx"));

        SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
        configuration.setOnePagePerSheet(true);
        configuration.setRemoveEmptySpaceBetweenColumns(true);
        configuration.setDetectCellType(true);
        configuration.getColumnWidthRatio();
        exporter.setConfiguration(configuration);

        exporter.exportReport();
    }
}
