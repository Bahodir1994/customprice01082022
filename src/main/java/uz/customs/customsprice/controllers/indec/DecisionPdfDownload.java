package uz.customs.customsprice.controllers.indec;


import com.itextpdf.text.BadElementException;
import com.lowagie.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import uz.customs.customsprice.entity.files.DecisionPdf;
import uz.customs.customsprice.repository.DecisionPdfRepo;
import uz.customs.customsprice.service.AppsService;
import uz.customs.customsprice.service.DecisionPdfService;
import uz.customs.customsprice.service.PdfService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@Controller
@RequestMapping("/decisionPdfDownload")
public class DecisionPdfDownload {
    private final String PDF_GENERATION = "/{cmdtId}";
    private final AppsService appsService;
    private final DecisionPdfService decisionPdfService;
    private final PdfService pdfService;


    @Autowired
    DecisionPdfRepo decisionPdfRepo;

    public DecisionPdfDownload(AppsService appsService, DecisionPdfService decisionPdfService, PdfService pdfService) {
        this.appsService = appsService;
        this.decisionPdfService = decisionPdfService;
        this.pdfService = pdfService;
    }

    @RequestMapping(value = PDF_GENERATION, method = RequestMethod.GET)
    public ResponseEntity downloadFile(HttpServletRequest request, HttpSession session, @PathVariable String cmdtId) {
        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
        String pdfId = "";
        String pdfName = "";
        String pdfPath = "";
        String pdfFormat = "";
        if (decisionPdf.isPresent()) {
            pdfId = decisionPdf.get().getId();
            pdfName = decisionPdf.get().getPdfName();
            pdfPath = decisionPdf.get().getPdfPath();
            pdfFormat = decisionPdf.get().getPdfFormat();
        }

        Resource resource = null;
        try {
            pdfService.createPdf(cmdtId);
            Date date = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String strDate = dateFormat.format(date);
            LocalDate currentDate = LocalDate.parse(strDate);
            String day = Integer.toString(currentDate.getDayOfMonth());
            String month = Integer.toString(currentDate.getMonthValue());
            String year = Integer.toString(currentDate.getYear());

            Path path = Paths.get(pdfPath);
            resource = new UrlResource(path.toUri());
            System.out.println("length = " + resource.contentLength());
            if (resource.contentLength() > 0) {
                return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfName + ".pdf" + "\"").body(resource);
            }
        } catch (DocumentException | IOException exception) {
        } catch (BadElementException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfName + ".pdf" + "\"").body("failed");
    }

    @GetMapping
    public void downloadFile1(@Param("cmdtId") String cmdtId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        pdfService.createPdf(cmdtId);

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
        String pdfId = "";
        String pdfName = "";
        String pdfPath = "";
        String pdfFormat = "";
        if (decisionPdf.isPresent()) {
            pdfId = decisionPdf.get().getId();
            pdfName = decisionPdf.get().getPdfName();
            pdfPath = decisionPdf.get().getPdfPath();
            pdfFormat = decisionPdf.get().getPdfFormat();


            BufferedInputStream buf = null;
            ServletOutputStream out = null;
            String fileName = "";

            try {
                out = response.getOutputStream();
                File zipFile = new File(pdfPath);
                fileName = URLEncoder.encode(pdfName.trim(), StandardCharsets.UTF_8);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                FileInputStream input = new FileInputStream(zipFile);
                buf = new BufferedInputStream(input);
                byte[] bytes = new byte[buf.available()];
                int readBytes = -1;
                while ((readBytes = buf.read(bytes)) != -1) {
                    out.write(bytes, 0, readBytes);
                }
                out.close();
                buf.close();

                /* todo Файлни щчириш командаси бошланди */
                File file = new File(pdfPath);
                if (file.delete())
                    System.out.println(pdfPath + " файл ўчирилди !!! ");
                decisionPdfRepo.deleteDecisionPdfById(pdfId);
                /* todo Файлни щчириш командаси тугади */


            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("<body onLoad=\"alert('Документ не найден!');window.opener=window.location.href;window.open('','_parent','');window.close()\">" +
                    "<h1>Документ не найден!</h1>" +
                    "</body>");
        }
    }


}

