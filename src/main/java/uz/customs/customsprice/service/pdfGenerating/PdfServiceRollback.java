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
import uz.customs.customsprice.entity.InitialDecision.*;
import uz.customs.customsprice.entity.files.DecisionPdfRollback;
import uz.customs.customsprice.entity.ForHtmlRollbackTemplate;
import uz.customs.customsprice.repository.ForHtmlRollbackTemplateRepo;
import uz.customs.customsprice.repository.RollBackAppRepo;
import uz.customs.customsprice.repository.StatusHRepo;
import uz.customs.customsprice.service.*;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.catalog.TransportTypeService;
import uz.customs.customsprice.service.commodity.CommodityService;
import uz.customs.customsprice.service.earxiv.EarxivServiceFrom;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


@Service
public class PdfServiceRollback {
    public final String DATA_DIRECTORY = "D:\\IN_DEC_FILES\\DECISION_PDF_ROLLBACK\\";
    private final AppsService appsService;
    private final CommodityService commodityService;
    private final DecisionPdfRollbackService decisionPdfRollbackService;
    private final ForHtmlCancelledService forHtmlCancelledService;
    private final forHtmlService htmlService;
    private final StatusHRepo statusHRepo;
    private final RollBackAppRepo rollBackAppRepo;
    private final ForHtmlRollbackTemplateRepo forHtmlRollbackTemplateRepo;
    private final UsersService usersService;
    private final TransportTypeService transportTypeService;
    private final EarxivServiceFrom earxivServiceFrom;

    public PdfServiceRollback(AppsService appsService, CommodityService commodityService, DecisionPdfRollbackService decisionPdfRollbackService, ForHtmlCancelledService forHtmlCancelledService, forHtmlService htmlService, StatusHRepo statusHRepo, RollBackAppRepo rollBackAppRepo, ForHtmlRollbackTemplateRepo forHtmlRollbackTemplateRepo, UsersService usersService, TransportTypeService transportTypeService, EarxivServiceFrom earxivServiceFrom) {
        this.appsService = appsService;
        this.commodityService = commodityService;
        this.decisionPdfRollbackService = decisionPdfRollbackService;
        this.forHtmlCancelledService = forHtmlCancelledService;
        this.htmlService = htmlService;
        this.statusHRepo = statusHRepo;
        this.rollBackAppRepo = rollBackAppRepo;
        this.forHtmlRollbackTemplateRepo = forHtmlRollbackTemplateRepo;
        this.usersService = usersService;
        this.transportTypeService = transportTypeService;
        this.earxivServiceFrom = earxivServiceFrom;
    }

    @Transactional
    public void createPdfCancelled(String stId, String status) throws IOException, BadElementException {
        Optional<StatusH> statusH = statusHRepo.findById(stId);

        StatusH statusHES = null;
        List<RollBackApp> rollBackApp = null;
        String user = null;
        if (Objects.equals(status, "120")) {
            statusHES = statusHRepo.findTop1ByAppIdAndStatusOrderByInsTimeDesc(statusH.get().getAppId(), "120");
            if (statusHES != null){
                rollBackApp = rollBackAppRepo.findByStatusHId(statusHES.getId());
            }
            user = usersService.getById(statusH.get().getInsUser()).getFullname();
        } else if (Objects.equals(status, "125")) {
            statusHES = statusHRepo.findTop1ByAppIdAndStatusOrderByInsTimeDesc(statusH.get().getAppId(), "125");
            rollBackApp = rollBackAppRepo.findByStatusHId(statusHES.getId());
            user = usersService.getById(statusH.get().getInsUser()).getFullname();
        }


        Apps apps = appsService.findById(statusH.get().getAppId());

        List<Commodity> commodityList = new ArrayList<>();
        commodityList = commodityService.getListById(apps.getId());


        List<RollbackHelperDTO> rollbackHelperDTOS = new ArrayList<RollbackHelperDTO>();
        String [] methodArr = new String[100];
        for (int i = 0; i < commodityList.size(); i++) {

//            Map<String, String> map = new HashMap<>();
//            Boolean lot = false;
//            for (int j = 0; j < commodityList.get(i).getMethodDescription().length(); j++) {
//                String txt = commodityList.get(i).getMethodDescription();
//                while (txt.charAt(j) == '~' && lot  == true){
//                    map.put(String.valueOf(1), commodityList.get(i).getMethodDescription().substring(0, j-1));
//                    lot = true;
//                }
//                if (txt.charAt(j) == '~' && txt.charAt(j+4) == '~'){
//                    map.put(j+1, commodityList.get(i).getMethodDescription().substring(j+5, ));
//                }
//            }
//            rollbackHelperDTOS.set(i, )
//            arrayList.add(commodityList.get(i).getMethodDescription());
        }

        List<TransportType> transportType = new ArrayList<>();
        transportType = transportTypeService.getAllByAppId(apps.getId());

        Optional<ForHtmlRollbackTemplate> forHtmlRollbackTemplate = forHtmlRollbackTemplateRepo.findById("1");

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
        context.setVariable("apps", apps);
        context.setVariable("transportType", transportType);
        context.setVariable("cmdt", commodityList);
        context.setVariable("docs", earxivServiceFrom.getAllByAppIdForPdf2(apps.getId()));
        context.setVariable("rollback", rollBackApp);
        context.setVariable("statusH", statusH);
        context.setVariable("statusHES", statusHES);
        context.setVariable("user", user);
        StringBuilder urlText = new StringBuilder("https://d-qaror.customs.uz/decisionPdfDownloadRollback?stId=" + stId);
        context.setVariable("url_qrCode", urlText);
        context.setVariable("url_InsUsr", url_InsUsr);
        context.setVariable("htmlData", forHtmlRollbackTemplate);
        context.setVariable("htmlData2", forHtmlCancelledService.getforHtmlById("1"));
        List<String> ject = new ArrayList<>();
        ject.add("Жисмоний шахс");
        ject.add("Юридик шахс");
        ject.add("БН");
        ject.add("НТ");
        context.setVariable("js", ject);


        String processHtml = "";

        if (Objects.equals(status, "120")) {
            processHtml = templateEngine.process("templates/PdfGenerateRollback.html", context);
        }
        if (Objects.equals(status, "110")) {
            processHtml = templateEngine.process("templates/PdfGenerateNewApp.html", context);
        } else if (Objects.equals(status, "125")) {
            processHtml = templateEngine.process("templates/PdfGenerateRollbackReturn.html", context);
        }
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
        String appNum = "";
        String ResultAppNum = "";
        File sv_dir = new File(DATA_DIRECTORY + year);
        if (!sv_dir.exists()) sv_dir.mkdir();
        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month);
        if (!sv_dir.exists()) sv_dir.mkdir();
        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month + "\\" + day);
        if (!sv_dir.exists()) sv_dir.mkdir();

        sv_dir = new File(DATA_DIRECTORY + year + "\\" + month + "\\" + day + "\\" + "resultAppNum");
        if (!sv_dir.exists()) sv_dir.mkdir();

        DecisionPdfRollback decisionPdf = new DecisionPdfRollback();
        String FileName = ("ID" + apps.getLocationId() + apps.getAppDate().toString().replaceAll("-", "") + apps.getAppNumS() + ".pdf");
        OutputStream outputStream = new FileOutputStream(sv_dir.getPath() + "/" + FileName);

        ITextRenderer renderer = new ITextRenderer();
        renderer.getFontResolver().addFont(urlTTF, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        String imgPathh = "template/gtk.jpg";
        renderer.setDocumentFromString(processHtml, imgPathh);
        renderer.layout();

        decisionPdf.setAppId(apps.getId());
        decisionPdf.setStId(stId);
        decisionPdf.setPdfPath(sv_dir.getPath());
        String pdfFormat = "application/pdf";
        decisionPdf.setPdfFormat(pdfFormat);
        decisionPdf.setPdfName(FileName);
        decisionPdfRollbackService.saveDecisionPdf(decisionPdf);

        renderer.createPDF(outputStream, false);
        renderer.finishPDF();
        renderer.getDocument();

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String GetHash2(InputStream fis) throws IOException, NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
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
