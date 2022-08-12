package uz.customs.customsprice.service.pdfGenerating;


import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.BaseFont;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InDec;
import uz.customs.customsprice.entity.InitialDecision.Payment;
import uz.customs.customsprice.entity.files.DecisionPdf;
import uz.customs.customsprice.entity.users.User;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.earxiv.EarxivService;
import uz.customs.customsprice.service.earxiv.EarxivServiceFrom;
import uz.customs.customsprice.service.payment.PaymentServise;

import java.io.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@Service
public class PdfService {
    public final String DATA_DIRECTORY = "D:\\IN_DEC_FILES\\DECISION_PDF\\";
    private final AppsService appsService;
    private final CommodityService commodityService;
    private final InDecService inDecService;
    private final DecisionPdfService decisionPdfService;
    private final PaymentServise paymentServise;
    private final DocsService docsService;
    private final UsersService usersService;
    private final forHtmlService htmlService;
    private final EarxivService earxivService;
    private final EarxivServiceFrom earxivServiceFrom;

    public PdfService(AppsService appsService, CommodityService commodityService, InDecService inDecService, DecisionPdfService decisionPdfService, PaymentServise paymentServise, DocsService docsService, UsersService usersService, forHtmlService htmlService, EarxivService earxivService, EarxivServiceFrom earxivServiceFrom) {
        this.appsService = appsService;
        this.commodityService = commodityService;
        this.inDecService = inDecService;
        this.decisionPdfService = decisionPdfService;
        this.paymentServise = paymentServise;
        this.docsService = docsService;
        this.usersService = usersService;
        this.htmlService = htmlService;
        this.earxivService = earxivService;
        this.earxivServiceFrom = earxivServiceFrom;
    }

    @Transactional
    public void createPdf(String cmdtId) throws IOException, BadElementException {
        Commodity commodityForApp = commodityService.findById(cmdtId);
        Apps apps = appsService.findById(commodityForApp.getAppId());
        InDec inDec2 = inDecService.getByCmtdId(cmdtId);
        String IdUser = inDec2.getInsUser();
        User userName = usersService.getById(IdUser);


        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        BarcodeQRCode qrCode = new BarcodeQRCode("https://new.customs.uz/", 150, 150, null);
        Image img = qrCode.getImage();
        String url_InsUsr = "https://new.customs.uz/";
        Date date1 = Calendar.getInstance().getTime();

        Context context = new Context();
        context.setVariable("apps", appsService.findById(commodityForApp.getAppId()));

        Commodity appsForCommodity = commodityService.findById(cmdtId);
        List<Commodity> commodityList = new ArrayList<>();
        commodityList = commodityService.getListById(appsForCommodity.getAppId());
        context.setVariable("cmdt", commodityList);

//        context.setVariable("cmdt", commodityService.getById(cmdtId));
        InDec inDecs = inDecService.getByCmtdId(cmdtId);
        context.setVariable("inDec", inDecs);
        context.setVariable("payment", paymentServise.getByCmdtId(cmdtId));
        BigDecimal BNSum = BigDecimal.valueOf(0.00);
        String g47Sp = "";
        g47Sp = "БН";
        List<Payment> paymentListBN = paymentServise.getByCmdtIdAndG47Sp(cmdtId, g47Sp);
        for (int i = 0; i < paymentServise.getByCmdtIdAndG47Sp(cmdtId, "БН").size(); i++) {
            BNSum = BNSum.add(paymentListBN.get(i).getG47Sum());
        }
        BigDecimal OOSum = BigDecimal.valueOf(0.00);
        g47Sp = "ОО";
        List<Payment> paymentListOO = paymentServise.getByCmdtIdAndG47Sp(cmdtId, g47Sp);
        for (int i = 0; i < paymentListOO.size(); i++) {
            OOSum = OOSum.add(paymentListOO.get(i).getG47Sum());
        }
        context.setVariable("paymentBN", BNSum);
        context.setVariable("paymentOO", OOSum);
        context.setVariable("docs", earxivServiceFrom.getAllByAppIdForPdf2(commodityForApp.getAppId()));
        context.setVariable("userName", userName.getFullname());
        context.setVariable("LocaleDate", inDecService.getByCmtdId(cmdtId).getInsTime());
        StringBuilder urlText = new StringBuilder("https://d-qaror.customs.uz/decisionPdfDownload?cmdtId=" + cmdtId);
        context.setVariable("url_qrCode", urlText);
        context.setVariable("url_InsUsr", url_InsUsr);
        context.setVariable("htmlData", htmlService.getforHtmlById("1"));

        String processHtml = templateEngine.process("templates/PdfGenerate.html", context);
        String urlTTF = "D:/FontStyle/TimesNewRoman.ttf";
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(date);
        LocalDate currentDate = LocalDate.parse(strDate);
        String day = String.valueOf(currentDate.getDayOfMonth());
        String month = String.valueOf(currentDate.getMonthValue());
        String year = String.valueOf(currentDate.getYear());
        String appFolder = apps.getAppNum();
        String hash256 = "";
        File folder = new File(DATA_DIRECTORY);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File sv_dir = new File(DATA_DIRECTORY + year);
        if (!sv_dir.exists()) sv_dir.mkdir();
        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month);
        if (!sv_dir.exists()) sv_dir.mkdir();
        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month + "\\" + day);
        if (!sv_dir.exists()) sv_dir.mkdir();
        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month + "\\" + day + "\\" + "resultInDecNum");
        if (!sv_dir.exists()) sv_dir.mkdir();

        DecisionPdf decisionPdf = new DecisionPdf();
        InDec inDec = inDecService.getByCmtdId(cmdtId);
        Optional<Commodity> commodity = commodityService.getById(cmdtId);
//        String FileName = ("ID" + commodity.get().getCmdtNum() + "-" + inDec.getInDecNum() + ".pdf");
        String FileName = ("ID" + commodity.get().getCmdtNum() + "_" + inDec.getInDecLocation() + inDec.getInDecDate().toString().replaceAll("-", "") + inDec.getInDecNumS() + ".pdf");
        OutputStream outputStream = new FileOutputStream(sv_dir.getPath() + "/" + FileName);

        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont(urlTTF, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String imgPathh = "template/gtk.jpg";
        renderer.setDocumentFromString(processHtml, imgPathh);
        renderer.layout();

        decisionPdf.setCmdtId(cmdtId);
        decisionPdf.setInDecId(inDec.getId());
        decisionPdf.setPdfPath(sv_dir.getPath());
        String pdfFormat = "application/pdf";
        decisionPdf.setPdfFormat(pdfFormat);
        decisionPdf.setPdfName(FileName);
        decisionPdfService.saveDecisionPdf(decisionPdf);

        renderer.createPDF(outputStream, false);
        renderer.finishPDF();
        renderer.getDocument();


        try {
            outputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }

    private static String GetHash2(InputStream fis) throws IOException, NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
//            FileInputStream fis = new FileInputStream(fileName);

            byte[] dataBytes = new byte[1024];

            int nread = 0;
            while ((nread = fis.read(dataBytes)) != -1) {
                md.update(dataBytes, 0, nread);
            }
            byte[] mdbytes = md.digest();

            //convert the byte to hex format
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            fis.close();
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }

    public static String format(double bytes, int digits) {
        String[] dictionary = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
        int index = 0;
        for (index = 0; index < dictionary.length; index++) {
            if (bytes < 1024) {
                break;
            }
            bytes = bytes / 1024;
        }
        return String.format("%." + digits + "f", bytes) + " " + dictionary[index];
    }

    private String str_prb(String par1) {
        int n = 1;
        String chck_fn = "qwertyuiopasdfghjklzxcvbnm1234567890-йцукенгшщзхъфывапролджэячсмитьбюёў. ~!@#$%^&*()_+=/|\\';:,№?<>[]{}";
        String par2 = "";
        for (n = 0; n < par1.length(); n++) {
            if (chck_fn.indexOf(par1.substring(n, n + 1).toLowerCase()) > -1) {
                par2 = par2 + par1.substring(n, n + 1);
            } else {
                par2 = par2 + "%";
            }
        }
        return par2;
    }

//        private final AppsService appsService;
//
//        public PdfService(AppsService appsService) {
//                this.appsService = appsService;
//        }
//
//        public void export(HttpServletResponse response, String arizaRaqam, String arizaId) throws IOException, DocumentException {
//
//                Apps apps = new Apps();
//                apps = appsService.findById(arizaId);
//                Document document =  new Document(PageSize.A4);
//                PdfWriter.getInstance(document, response.getOutputStream());
//                document.open();
//                Font fontTitle  = FontFactory.getFont("uz/customs/customsprice/fonts/DejaVuSans.ttf", "cp1251", 24);
//                Paragraph paragraph = new Paragraph("DASTLABKI QAROR", fontTitle);
//                paragraph.setAlignment(Paragraph.ALIGN_CENTER);
//
//                Image image = Image.getInstance("src/main/webapp/resources/images/gtk.jpg");
//                image.scaleAbsolute(50, 50);
//                image.setAbsolutePosition(70, 760);
//
//                BarcodeQRCode qrCode = new BarcodeQRCode("http://youtube.com", 150, 150, null);
//                Image img = qrCode.getImage();
//                img.setAbsolutePosition(100, 20);
//
//                PdfPTable table = new PdfPTable(3);
//                PdfPCell cell1 = new PdfPCell(new Paragraph(apps.getStatusNm()));
//                PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
//                PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
//                table.addCell(cell1);
//                table.addCell(cell2);
//                table.addCell(cell3);
//                table.setSpacingBefore(30f);
//                table.setSpacingAfter(10f);
//                document.add(image);
//                document.add(paragraph);
//                document.add(table);
//                document.add(img);
//                document.close();
//        }
}
