package uz.customs.customsprice.controllers.api.files;

import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uz.customs.customsprice.controllers.api.helper.FileUploadHelper;
import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.service.apps.AppsService;
import uz.customs.customsprice.service.DocsService;
import uz.customs.customsprice.repository.EarxivRepo;
import uz.customs.customsprice.service.earxiv.EarxivService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class ApiFileController {

    private final DocsService docsService;
    private final AppsService appsService;
    private final EarxivService earxivService;
    private final EarxivRepo earxivRepo;


    @Autowired
    private FileUploadHelper fileUploadHelper;

    public ApiFileController(DocsService docsService, AppsService appsService, EarxivService earxivService, EarxivRepo earxivRepo) {
        this.docsService = docsService;
        this.appsService = appsService;
        this.earxivService = earxivService;
        this.earxivRepo = earxivRepo;
    }

    @PostMapping("/upload-file")
    public ResponseEntity<Object> fileDownload(HttpServletRequest request, @RequestParam String appId, @RequestParam String fileId) throws IOException, NoSuchAlgorithmException, FileUploadException {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        authentication.getPrincipal();
//        User user = (User) authentication;

        Earxiv earxiv = new Earxiv();
//        List<EarxivSearchResponse> earxivSearchResponse = earxivService.getFile(fileId);
        List<Object[]> fileList = earxivService.getFile1(fileId);
        if (fileList.size() > 0) {
            earxiv.setAppId(appId);
            earxiv.setFolderId(fileList.get(0)[0] != null ? fileList.get(0)[0].toString() : "");
            earxiv.setName(fileList.get(0)[1] != null ? fileList.get(0)[1].toString() : "");
            earxiv.setUserInn(fileList.get(0)[2] != null ? fileList.get(0)[2].toString() : "");
            earxiv.setUserPnfl(fileList.get(0)[3] != null ? fileList.get(0)[3].toString() : "");
            earxiv.setDocname(fileList.get(0)[4] != null ? fileList.get(0)[4].toString() : "");
            earxiv.setDocType(fileList.get(0)[5] != null ? fileList.get(0)[5].toString() : "");
            earxiv.setFileId(fileList.get(0)[6] != null ? fileList.get(0)[6].toString() : "");
            earxiv.setStatus(fileList.get(0)[7] != null ? fileList.get(0)[7].toString() : "");
            earxiv.setDocTypeName(fileList.get(0)[8] != null ? fileList.get(0)[8].toString() : "");
            earxiv.setHash(fileList.get(0)[9] != null ? fileList.get(0)[9].toString() : "");
        } else {
            earxiv.setAppId("");
            earxiv.setFolderId("");
            earxiv.setName("");
            earxiv.setUserInn("");
            earxiv.setUserPnfl("");
            earxiv.setDocname("");
            earxiv.setDocType("");
            earxiv.setDocTypeName("");
            earxiv.setFileId("");
            earxiv.setStatus("");
            earxiv.setHash("");
        }

        earxivService.create(earxiv);
        return null;

    }


//    @PostMapping("/upload-file")
//    public ResponseEntity<Object> uploadFile(@RequestParam("appId") String appId, @RequestParam("docType") String docType, @RequestParam("file") MultipartFile file, @RequestParam("docNumber") String docNumber, @RequestParam("docDate") String docDate) throws IOException, NoSuchAlgorithmException, FileUploadException {
//        String AppNum = "";
//        String hash256 = "";
//        hash256 = GetHash2(file.getInputStream());
////        String appId = "";
////        String docNumber = "";
////        String docDate = "";
////        String docType = "";
//        String docSrNo = "";
//        String docName = "";
//        String docNameEx = "";
//        String docPath = "";
//        String docFormat = "";
//        String docSize = "";
//        Docs docs = new Docs();
//        Docs d = docsService.getByAppId(appId);
//        Apps apps = new Apps();
//        apps = appsService.findById(appId);
//        AppNum = apps.getAppNum();
//        docName = file.getOriginalFilename();
//        docName = str_prb(docName);
//
//
//        if (d != null) {
//            docSrNo = Integer.toString(Integer.parseInt(d.getDocSrNo()) + 1);
//        } else docSrNo = "1";
//
//        try {
//            if (file.isEmpty()) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File ustuni bo'sh bo'lishi mumkun emas!");
//            }
//            if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("application/pdf")&& !file.getContentType().equals("image/png") && !file.getContentType().equals("application/msword")) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Faqat PDF, JPG, WORD formatdagi faylni yuborishingiz mumkin!");
//            }
//
//            if (!Objects.equals(docs.getHash256(), hash256)) {
////                boolean f = fileUploadHelper.uploadFile(file, APP_NUM);
//                String fileData = fileUploadHelper.uploadFile(file, AppNum);
//                String[] fileDataArr = fileData.split("~~~");
//                int isEmpty = Integer.parseInt(fileDataArr[0]);
//                String filePath = fileDataArr[1];
//                String timeStampS = fileDataArr[2];
//                Date docDateS = null;
//                if (docDate != null && !docDate.equals("")) docDateS = Date.valueOf(docDate.substring(0, 4) + "-" + docDate.substring(5, 7) + "-" + docDate.substring(8, 10));
//                if (isEmpty == 1) {
//                    docs.setHash256(hash256);
//                    docs.setAppId(appId);
//                    docs.setDocSrNo(docSrNo);
//                    docs.setDocName(file.getOriginalFilename());
//                    docs.setDocNameEx(timeStampS);
//                    docs.setDocFormat(file.getContentType());
//                    docs.setDocSize(String.valueOf(file.getSize()));
//                    docs.setDocNumber(docNumber);
//                    /*2022-02-13*/
//                    if (docDate != null && !docDate.equals("")) docs.setDocDate(docDateS);
//                    docs.setDocType(docType);
//                    docs.setDocPath(filePath);
//                    docsService.savedocs(docs);
//                    return ResponseHandler.generateResponse("Fayl ma'lumot saqlandi", HttpStatus.OK, docs);
//                }
//            }
//        } catch (Exception e) {e.printStackTrace();}
//        return ResponseHandler.generateResponse("Docs ma`lumotlari saqlashda xatolik yuz berdi!", HttpStatus.BAD_REQUEST, docs.getId());
//    }
//    private static String GetHash2(InputStream fis) throws IOException, NoSuchAlgorithmException {
//        try {
//            MessageDigest md = MessageDigest.getInstance("MD5");
////            FileInputStream fis = new FileInputStream(fileName);
//
//            byte[] dataBytes = new byte[1024];
//
//            int nread = 0;
//            while ((nread = fis.read(dataBytes)) != -1) {
//                md.update(dataBytes, 0, nread);
//            }
//            byte[] mdbytes = md.digest();
//
//            //convert the byte to hex format
//            StringBuffer sb = new StringBuffer();
//            for (int i = 0; i < mdbytes.length; i++) {
//                sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
//            }
//
//            fis.close();
//            return sb.toString();
//        } catch (Exception e) {
//            return "";
//        }
//    }
//
//    public static String format(double bytes, int digits) {
//        String[] dictionary = {"bytes", "KB", "MB", "GB", "TB", "PB", "EB", "ZB", "YB"};
//        int index = 0;
//        for (index = 0; index < dictionary.length; index++) {
//            if (bytes < 1024) {
//                break;
//            }
//            bytes = bytes / 1024;
//        }
//        return String.format("%." + digits + "f", bytes) + " " + dictionary[index];
//    }
//
//    private String str_prb(String par1) {
//        int n = 1;
//        String chck_fn = "qwertyuiopasdfghjklzxcvbnm1234567890-йцукенгшщзхъфывапролджэячсмитьбюёў. ~!@#$%^&*()_+=/|\\';:,№?<>[]{}";
//        String par2 = "";
//        for (n = 0; n < par1.length(); n++) {
//            if (chck_fn.indexOf(par1.substring(n, n + 1).toLowerCase()) > -1) {
//                par2 = par2 + par1.substring(n, n + 1);
//            } else {
//                par2 = par2 + "%";
//            }
//        }
//        return par2;
//    }
}