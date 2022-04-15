package uz.customs.customsprice.controllers.generatorPdf;

import org.springframework.boot.CommandLineRunner;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.service.PdfService;

import javax.servlet.http.HttpServletResponse;

@Controller
//@RequestMapping("/generate")
public class GeneratePdfController {

    private final String GENERATEPDF = "/resources/pages/InitialDecision/GeneratePdf";

    private final PdfService pdfService;

    public GeneratePdfController(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @GetMapping("/generate")
    public void generatePDF(@Param("appId") String id, HttpServletResponse response) throws Exception {
        System.out.println("Creating pdf");
//        pdfService.createPdf();
        System.out.println("Creating finished!");

    }

//
//    private final PdfService pdfService;
//    private final AppsService appsService;
//
//
//    public GeneratePdfController(PdfService pdfService, AppsService appsService) {
//        this.pdfService = pdfService;
//        this.appsService = appsService;
//    }
//
//    @GetMapping("/generate")
//    public void generatePDF(@Param("id") String id, HttpServletResponse response) throws Exception {
//        System.out.println(id);
//
//        Optional<Apps> result = Optional.ofNullable(appsService.findById(id));
//        if (result.isEmpty()) {
//            throw new Exception("Ушбу ариза бўйича маълумот етарли эмас!");
//        }
//        String ArizaRaqam = result.get().getAppNum();
//        String ArizaId = result.get().getAppNum();
//
//
//
//        response.setContentType("application/pdf");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
//        String currentDateTime = dateFormatter.format(new Date());
//
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filname=pdf_" + currentDateTime + ".pdf";
//        response.setHeader(headerKey, headerValue);
//
//        this.pdfService.export(response, ArizaRaqam, ArizaId);
//    }
//
////    @GetMapping("/generated")
////    public static org.jsoup.nodes.Document main(String[] args) throws IOException {
////        String inputHTML = "<h3>allo</h3>";
////        org.jsoup.nodes.Document document = Jsoup.parse(inputHTML, "UTF-8");
//////        document.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
////        return document;
////    }
//
//
}
