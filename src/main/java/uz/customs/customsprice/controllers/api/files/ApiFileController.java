package uz.customs.customsprice.controllers.api.files;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import uz.customs.customsprice.controllers.api.helper.FileUploadHelper;
import uz.customs.customsprice.controllers.api.helper.ResponseHandler;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.service.AppsService;
import uz.customs.customsprice.service.DocsService;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Objects;

@Controller
public class ApiFileController {

    private final DocsService docsService;
    private final AppsService appsService;

    @Autowired
    private FileUploadHelper fileUploadHelper;

    public ApiFileController(DocsService docsService, AppsService appsService) {
        this.docsService = docsService;
        this.appsService = appsService;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<Object> uploadFile(@RequestParam("appId") String appId, @RequestParam("docType") String docType, @RequestParam("file") MultipartFile file, @RequestParam("docNumber") String docNumber, @RequestParam("docDate") String docDate) throws IOException, NoSuchAlgorithmException, FileUploadException {
        String AppNum = "";
        String hash256 = "";
        hash256 = GetHash2(file.getInputStream());
//        String appId = "";
//        String docNumber = "";
//        String docDate = "";
//        String docType = "";
        String docSrNo = "";
        String docName = "";
        String docNameEx = "";
        String docPath = "";
        String docFormat = "";
        String docSize = "";
        Docs docs = new Docs();
        Docs d = docsService.getByAppId(appId);
        Apps apps = new Apps();
        apps = appsService.findById(appId);
        AppNum = apps.getAppNum();
        docName = file.getOriginalFilename();
        docName = str_prb(docName);


        if (d != null) {
            docSrNo = Integer.toString(Integer.parseInt(d.getDocSrNo()) + 1);
        } else docSrNo = "1";

        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File ustuni bo'sh bo'lishi mumkun emas!");
            }
            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("application/pdf")&& !file.getContentType().equals("image/png") && !file.getContentType().equals("application/msword")) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Faqat PDF, JPG, WORD formatdagi faylni yuborishingiz mumkin!");
            }

            if (!Objects.equals(docs.getHash256(), hash256)) {
//                boolean f = fileUploadHelper.uploadFile(file, APP_NUM);
                String fileData = fileUploadHelper.uploadFile(file, AppNum);
                String[] fileDataArr = fileData.split("~~~");
                int isEmpty = Integer.parseInt(fileDataArr[0]);
                String filePath = fileDataArr[1];
                String timeStampS = fileDataArr[2];
                Date docDateS = null;
                if (docDate != null && !docDate.equals("")) docDateS = Date.valueOf(docDate.substring(0, 4) + "-" + docDate.substring(5, 7) + "-" + docDate.substring(8, 10));
                if (isEmpty == 1) {
                    docs.setHash256(hash256);
                    docs.setAppId(appId);
                    docs.setDocSrNo(docSrNo);
                    docs.setDocName(file.getOriginalFilename());
                    docs.setDocNameEx(timeStampS);
                    docs.setDocFormat(file.getContentType());
                    docs.setDocSize(String.valueOf(file.getSize()));
                    docs.setDocNumber(docNumber);
                    /*2022-02-13*/
                    if (docDate != null && !docDate.equals("")) docs.setDocDate(docDateS);
                    docs.setDocType(docType);
                    docs.setDocPath(filePath);
                    docsService.savedocs(docs);
                    return ResponseHandler.generateResponse("Fayl ma'lumot saqlandi", HttpStatus.OK, docs);
                }
            }
        } catch (Exception e) {e.printStackTrace();}
        return ResponseHandler.generateResponse("Docs ma`lumotlari saqlashda xatolik yuz berdi!", HttpStatus.BAD_REQUEST, docs.getId());
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
}