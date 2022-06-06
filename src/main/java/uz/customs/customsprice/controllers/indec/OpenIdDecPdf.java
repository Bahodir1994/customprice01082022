package uz.customs.customsprice.controllers.indec;

import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.files.DecisionPdf;
import uz.customs.customsprice.repository.DecisionPdfRepo;
import uz.customs.customsprice.service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Optional;

@Controller
@RequestMapping("/openInDecPdf")
public class OpenIdDecPdf {

    private final String OPENINDECPDF = "/resources/openInDecPdfOne";

    public final String DATA_DIRECTORY = "D:\\IN_DEC_FILES\\DECISION_PDF\\";
    private final AppsService appsService;
    private final CommodityService commodityService;
    private final InDecService inDecService;
    private final DecisionPdfService decisionPdfService;
    private final PaymentServise paymentServise;
    private final DocsService docsService;
    private final UsersService usersService;
    private final forHtmlService htmlService;
    private final PdfService pdfService;
    private final PdfServiceCancelled pdfServiceCancelled;

    @Autowired
    DecisionPdfRepo decisionPdfRepo;

    public OpenIdDecPdf(AppsService appsService, CommodityService commodityService, InDecService inDecService, DecisionPdfService decisionPdfService, PaymentServise paymentServise, DocsService docsService, UsersService usersService, forHtmlService htmlService, PdfService pdfService, PdfServiceCancelled pdfServiceCancelled) {
        this.appsService = appsService;
        this.commodityService = commodityService;
        this.inDecService = inDecService;
        this.decisionPdfService = decisionPdfService;
        this.paymentServise = paymentServise;
        this.docsService = docsService;
        this.usersService = usersService;
        this.htmlService = htmlService;
        this.pdfService = pdfService;
        this.pdfServiceCancelled = pdfServiceCancelled;
    }


    @PostMapping(value = OPENINDECPDF)
    public ModelAndView openIdDecPdf(HttpServletRequest request, HttpServletResponse response, @RequestParam String cmdtId) throws IOException, DocumentException {
        ModelAndView mav = new ModelAndView("resources/pages/InitialDecision/ListInDec/InDecPdf");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (inDecService.getByCmtdId(cmdtId).getEndActiv() == 100) {
            pdfService.createPdf(cmdtId);
        } else {
            pdfServiceCancelled.createPdfCancelled(cmdtId);
        }
        Optional<DecisionPdf> decisionPdf = Optional.ofNullable(decisionPdfService.getByCmdtId(cmdtId));
        String pdfName = decisionPdf.get().getPdfName();
        String pdfPath = decisionPdf.get().getPdfPath();
        String pdfId = decisionPdf.get().getId();
        String dataDirectory = pdfPath;
        Path file = Paths.get(dataDirectory, pdfName);
        if (Files.exists(file)) {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename=" + pdfName);

            Files.copy(file, baos);
            byte[] respons = baos.toByteArray();
            String base64 = Base64.getEncoder().encodeToString(respons);
            mav.addObject("pdfFiles", base64);
        }



        /* todo Файлни щчириш командаси бошланди */
        File file2 = new File(pdfPath);
        if (file2.delete())
            System.out.println(pdfPath + " файл ўчирилди !!! ");
        decisionPdfRepo.deleteDecisionPdfById(pdfId);
//        /* todo Файлни щчириш командаси тугади */
        return mav;
    }


}


//    String imageBase64 = "";
//    ByteArrayOutputStream boas = null;
//    /**************************************************************************************************************/
//    Commodity commodityForApp = commodityService.findById(cmdtId);
//    Apps apps = appsService.findById(commodityForApp.getAppId());
//    InDec inDec2 = inDecService.getByCmtdId(cmdtId);
//    String IdUser = inDec2.getInsUser();
//    User userName = usersService.getById(IdUser);
//
//
//    ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        templateResolver.setSuffix(".html");
//                templateResolver.setTemplateMode(TemplateMode.HTML);
//                TemplateEngine templateEngine = new TemplateEngine();
//                templateEngine.setTemplateResolver(templateResolver);
//
//                BarcodeQRCode qrCode = new BarcodeQRCode("https://new.customs.uz/", 150, 150, null);
//                Image img = qrCode.getImage();
//                String url_InsUsr = "https://new.customs.uz/";
//                Date date1 = Calendar.getInstance().getTime();
//
//                Context context = new Context();
//                context.setVariable("apps", appsService.findById(commodityForApp.getAppId()));
//                context.setVariable("cmdt", commodityService.getById(cmdtId));
//                context.setVariable("inDec", inDecService.getByCmtdId(cmdtId));
//                context.setVariable("payment", paymentServise.getByCmdtId(cmdtId));
//                context.setVariable("docs", docsService.getByAppIdForPdf(commodityForApp.getAppId()));
//                context.setVariable("userName", userName.getFullname());
//                context.setVariable("LocaleDate", date1);
//                StringBuilder urlText = new StringBuilder("https://d-qaror.customs.uz/decisionPdfDownload?cmdtId=" + cmdtId);
//                context.setVariable("url_qrCode", urlText);
//                context.setVariable("url_InsUsr", url_InsUsr);
//                context.setVariable("htmlData", htmlService.getforHtmlById("1"));
//
//                String processHtml = templateEngine.process("templates/PdfGenerate.html", context);
//                String urlTTF = "D:/FontStyle/TimesNewRoman.ttf";
//                Date date = Calendar.getInstance().getTime();
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//                String strDate = dateFormat.format(date);
//                LocalDate currentDate = LocalDate.parse(strDate);
//                String day = String.valueOf(currentDate.getDayOfMonth());
//                String month = String.valueOf(currentDate.getMonthValue());
//                String year = String.valueOf(currentDate.getYear());
//                String appFolder = apps.getAppNum();
//                String hash256 = "";
//
//
//                DecisionPdf decisionPdf = new DecisionPdf();
//                InDec inDec = inDecService.getByCmtdId(cmdtId);
//                Optional<Commodity> commodity = commodityService.getById(cmdtId);
//        String FileName = ("ID" + commodity.get().getCmdtNum() + "-" + inDec.getInDecNum() + ".pdf");
//        OutputStream outputStream = new FileOutputStream(FileName);
//
//        ITextRenderer renderer = new ITextRenderer();
//        renderer.getFontResolver().addFont(urlTTF, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
//        String imgPathh = "template/gtk.jpg";
//        renderer.setDocumentFromString(processHtml, imgPathh);
//        renderer.layout();
//
//
//        renderer.createPDF(outputStream, false);
//        renderer.finishPDF();
//        renderer.getDocument();
//        renderer.getDocument();
//
//        PdfReader reader = new PdfReader(FileName);
//        boas = new ByteArrayOutputStream();
//        PdfStamper stamper = new PdfStamper(reader, boas);
//
//
//        byte[] bytes = boas.toByteArray();
//        String base64 = Base64.getEncoder().encodeToString(bytes);
//
//        try {
//        outputStream.close();
//        } catch (java.io.IOException e) {
//        e.printStackTrace();
//        }
///**************************************************************************************************************/