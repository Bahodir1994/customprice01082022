//package uz.customs.customsprice.controllers.indec;
//
//
//import com.itextpdf.text.BadElementException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.repository.query.Param;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import uz.customs.customsprice.entity.files.DecisionPdf;
//import uz.customs.customsprice.repository.DecisionPdfRepo;
//import uz.customs.customsprice.service.*;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/decisionPdfDownload")
//public class DownloadGeneratedRollBackPdf {
//    private final AppsService appsService;
//    private final DecisionPdfService decisionPdfService;
//    private final PdfService pdfService;
//    private final InDecService inDecService;
//    private final PdfServiceCancelled pdfServiceCancelled;
//
//    @Autowired
//    DecisionPdfRepo decisionPdfRepo;
//
//    public DownloadGeneratedRollBackPdf(AppsService appsService, DecisionPdfService decisionPdfService, PdfService pdfService, InDecService inDecService, PdfServiceCancelled pdfServiceCancelled) {
//        this.appsService = appsService;
//        this.decisionPdfService = decisionPdfService;
//        this.pdfService = pdfService;
//        this.inDecService = inDecService;
//        this.pdfServiceCancelled = pdfServiceCancelled;
//    }
//
//
//    @GetMapping(produces = MediaType.APPLICATION_PDF_VALUE)
//    public void downloadPDFResource(HttpServletRequest request, HttpServletResponse response, @Param("stId") String stId, @Param("status") String status) throws BadElementException, IOException {
//
//        //If user is not authorized - he should be thrown out from here itself
//
//        //Authorized user will download the file
//        if (inDecService.getByCmtdId(cmdtId).getEndActiv() == 100){
//            pdfService.createPdf(cmdtId);
//        } else {
//            pdfServiceCancelled.createPdfCancelled(cmdtId);
//        }
//        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
//        String pdfName = decisionPdf.get().getPdfName();
//        String pdfPath = decisionPdf.get().getPdfPath();
//        String pdfId = decisionPdf.get().getId();
//        String dataDirectory = pdfPath;
//        Path file = Paths.get(dataDirectory, pdfName);
//        if (Files.exists(file))
//        {
//            response.setContentType("application/pdf");
//            response.addHeader("Content-Disposition", "attachment; filename="+pdfName);
//            try
//            {
//                Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            }
//            catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//
//        /* todo Файлни щчириш командаси бошланди */
//        File file2 = new File(pdfPath);
//        if (file2.delete())
//            System.out.println(pdfPath + " файл ўчирилди !!! ");
//        decisionPdfRepo.deleteDecisionPdfById(pdfId);
//        /* todo Файлни щчириш командаси тугади */
//    }
//}
//
//
