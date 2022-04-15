package uz.customs.customsprice.controllers.api.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class FileUploadHelper {
    public final String DATA_DIRECTORY = "D:\\IN_DEC_FILES\\";
    String instime = "", year = "", month = "", day = "";
    String idd = "a1379938-44a6-4f09-a19d-7f5727528233";
    String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    public String uploadFile(MultipartFile multipartFile, String APP_NUM) {
        boolean f = false;
        String isEmpty = "0";
        String fileData = "";
        String DOC_PATH = "";
        instime = date;
        if (instime != null || !instime.equals("")) {
            year = instime.substring(6);
            month = instime.substring(3, 5);
            day = instime.substring(0, 2);
        }

        try {
            if (DOC_PATH.equals("")) {
                String file_name = multipartFile.getOriginalFilename();
                String file_only_name = "";
                String file_extension = "";
                int i_ex = file_name.lastIndexOf('.');
                int p_ex = Math.max(file_name.lastIndexOf('/'), file_name.lastIndexOf('\\'));
                if (i_ex > p_ex) {
                    file_extension = file_name.substring(i_ex);
                }
                if (file_extension.equals("")) file_only_name = file_name;
                else file_only_name = file_name.substring(0, (file_name.length() - file_extension.length()));

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
                sv_dir = new File(DATA_DIRECTORY + year + "\\" + month + "\\" + day + "\\" + APP_NUM);
                if (!sv_dir.exists()) sv_dir.mkdir();

                String timeStampS = "";
                timeStampS = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss.SSS").format(new Timestamp(System.currentTimeMillis()));
                timeStampS = timeStampS.replaceAll("-", "").replaceAll(":", "").replaceAll(" ", "").replaceAll("\\.", "");
                timeStampS = timeStampS /*+ "_" + InputName*/ + file_extension;
                String filePath = sv_dir.getPath() + File.separator + timeStampS;
//                String put_file = sv_dir.getPath();
                Files.copy(multipartFile.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                f = true;
                isEmpty = "1";
                fileData = isEmpty + "~~~" + filePath + "~~~" + timeStampS;
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileData;
    }
}