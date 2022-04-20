package uz.customs.customsprice.controllers.indec;


import com.itextpdf.text.BadElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.customs.customsprice.entity.files.DecisionPdf;
import uz.customs.customsprice.repository.DecisionPdfRepo;
import uz.customs.customsprice.service.AppsService;
import uz.customs.customsprice.service.DecisionPdfService;
import uz.customs.customsprice.service.PdfService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

//@Controller
//@RequestMapping("/decisionPdfDownload")
//public class DecisionPdfDownload {
//    private final AppsService appsService;
//    private final DecisionPdfService decisionPdfService;
//    private final PdfService pdfService;
//
//
//    @Autowired
//    DecisionPdfRepo decisionPdfRepo;
//
//    public DecisionPdfDownload(AppsService appsService, DecisionPdfService decisionPdfService, PdfService pdfService) {
//        this.appsService = appsService;
//        this.decisionPdfService = decisionPdfService;
//        this.pdfService = pdfService;
//    }
//
//    @GetMapping()
//    public @ResponseBody byte[] getPdfWithMediaType(@Param("cmdtId") String cmdtId) throws IOException, BadElementException {
//        pdfService.createPdf(cmdtId);
//        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
//        String pdfName = decisionPdf.get().getPdfName();
////        String pdfPath = decisionPdf.get().getPdfPath();
//        InputStream in = getClass().getResourceAsStream(pdfName);
//        return IOUtils.toByteArray(in);
//    }
//
////    @RequestMapping(value = "/decisionPdfDownload/{cmdtId}", method = RequestMethod.GET)
////    public void getPdf(@PathVariable("cmdtId") String cmdtId, HttpServletResponse response) throws IOException{
////        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
////        String pdfName = decisionPdf.get().getPdfName();
////        String pdfPath = decisionPdf.get().getPdfPath();
////        try {
////            File file = new File(pdfPath + pdfName+ ".pdf");
////
////            if (file.exists()) {
////                // here I use Commons IO API to copy this file to the response output stream, I don't know which API you use.
////                FileUtil.copyFile(file, response.getOutputStream());
////
////                // here we define the content of this file to tell the browser how to handle it
////                response.setContentType("application/pdf");
////                response.setHeader("Content-disposition", "attachment;filename=" + pdfName + ".pdf");
////                response.flushBuffer();
////            } else {
////                System.out.println("Contract Not Found");
////            }
////        } catch (IOException exception) {
////            System.out.println("Contract Not Found");
////            System.out.println(exception.getMessage());
////        }
////
////    }
//
//
////
////    public ResponseEntity downloadFile(HttpServletRequest request, HttpSession session, @PathVariable String cmdtId) {
////        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
////        String pdfId = "";
////        String pdfName = "";
////        String pdfPath = "";
////        String pdfFormat = "";
////        if (decisionPdf.isPresent()) {
////            pdfId = decisionPdf.get().getId();
////            pdfName = decisionPdf.get().getPdfName();
////            pdfPath = decisionPdf.get().getPdfPath();
////            pdfFormat = decisionPdf.get().getPdfFormat();
////        }
////
////        Resource resource = null;
////        try {
////            pdfService.createPdf(cmdtId);
////            Date date = Calendar.getInstance().getTime();
////            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
////            String strDate = dateFormat.format(date);
////            LocalDate currentDate = LocalDate.parse(strDate);
////            String day = Integer.toString(currentDate.getDayOfMonth());
////            String month = Integer.toString(currentDate.getMonthValue());
////            String year = Integer.toString(currentDate.getYear());
////
////            Path path = Paths.get(pdfPath);
////            resource = new UrlResource(path.toUri());
////            System.out.println("length = " + resource.contentLength());
////            if (resource.contentLength() > 0) {
////                return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfName + ".pdf" + "\"").body(resource);
////            }
////        } catch (DocumentException | IOException exception) {
////        } catch (BadElementException e) {
////            e.printStackTrace();
////        }
////        return ResponseEntity.ok().contentType(MediaType.parseMediaType("application/octet-stream")).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + pdfName + ".pdf" + "\"").body("failed");
////    }
//
////    @GetMapping
////    public void downloadFile1(@Param("cmdtId") String cmdtId, HttpServletRequest request, HttpServletResponse response) throws Exception {
////        pdfService.createPdf(cmdtId);
////
////        request.setCharacterEncoding("UTF-8");
////        response.setCharacterEncoding("utf-8");
////        response.setContentType("text/html;charset=UTF-8");
////
////        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
////        String pdfId = "";
////        String pdfName = "";
////        String pdfPath = "";
////        String pdfFormat = "";
////        if (decisionPdf.isPresent()) {
////            pdfId = decisionPdf.get().getId();
////            pdfName = decisionPdf.get().getPdfName();
////            pdfPath = decisionPdf.get().getPdfPath();
////            pdfFormat = decisionPdf.get().getPdfFormat();
////
////
////            BufferedInputStream buf = null;
////            ServletOutputStream out = null;
////            String fileName = "";
////
////            try {
////                out = response.getOutputStream();
////                File zipFile = new File(pdfPath);
////                fileName = URLEncoder.encode(pdfName.trim(), StandardCharsets.UTF_8);
////                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
////                FileInputStream input = new FileInputStream(zipFile);
////                buf = new BufferedInputStream(input);
////                byte[] bytes = new byte[buf.available()];
////                int readBytes = -1;
////                while ((readBytes = buf.read(bytes)) != -1) {
////                    out.write(bytes, 0, readBytes);
////                }
////                out.close();
////                buf.close();
////
////                /* todo Файлни щчириш командаси бошланди */
////                File file = new File(pdfPath);
////                if (file.delete())
////                    System.out.println(pdfPath + " файл ўчирилди !!! ");
////                decisionPdfRepo.deleteDecisionPdfById(pdfId);
////                /* todo Файлни щчириш командаси тугади */
////
////
////            } catch (Exception e) {
////                e.printStackTrace();
////            }
////        } else {
////            response.getWriter().println("<body onLoad=\"alert('Документ не найден!');window.opener=window.location.href;window.open('','_parent','');window.close()\">" +
////                    "<h1>Документ не найден!</h1>" +
////                    "</body>");
////        }
////    }
//
//
//}

@Controller
@RequestMapping("/decisionPdfDownload")
public class DecisionPdfDownload {
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

    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response, @Param("cmdtId") String cmdtId) throws BadElementException, IOException {

        //If user is not authorized - he should be thrown out from here itself

        //Authorized user will download the file
        pdfService.createPdf(cmdtId);
        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
        String pdfName = decisionPdf.get().getPdfName();
        String pdfPath = decisionPdf.get().getPdfPath();
        String pdfId = decisionPdf.get().getId();
        String dataDirectory = pdfPath;
        Path file = Paths.get(dataDirectory, pdfName);
        if (Files.exists(file))
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+pdfName);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }


        /* todo Файлни щчириш командаси бошланди */
        File file2 = new File(pdfPath);
        if (file2.delete())
            System.out.println(pdfPath + " файл ўчирилди !!! ");
        decisionPdfRepo.deleteDecisionPdfById(pdfId);
        /* todo Файлни щчириш командаси тугади */
    }
}

