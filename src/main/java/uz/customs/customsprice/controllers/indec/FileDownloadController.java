package uz.customs.customsprice.controllers.indec;


import org.hibernate.engine.jdbc.internal.BinaryStreamImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.customs.customsprice.entity.earxiv.DBFile;

import uz.customs.customsprice.entity.earxiv.Earxiv;
import uz.customs.customsprice.service.earxiv.DBFileService;
import uz.customs.customsprice.service.earxiv.EarxivService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Decoder;
import javax.websocket.Encoder;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;


@Controller
@RequestMapping("/download")
public class FileDownloadController {
    private final DBFileService dbFileService;
    private final EarxivService earxivService;

    public FileDownloadController(DBFileService dbFileService, EarxivService earxivService) {
        this.dbFileService = dbFileService;
        this.earxivService = earxivService;
    }
//    @GetMapping
//    public void downloadFile(@Param("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
//
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");
//
//        Optional<Docs> docs = docsRepo.findById(id);
//        String docId = "";
//        String docName = "";
//        String docNameEx = "";
//        String docPath = "";
//        String docFormat = "";
//        if (docs.isPresent()) {
//            docName = docs.get().getDocName();
//            docNameEx = docs.get().getDocNameEx();
//            docPath = docs.get().getDocPath();
//            docFormat = docs.get().getDocFormat();
//
//            BufferedInputStream buf = null;
//            ServletOutputStream out = null;
//            String fileName = "";
//
//            try {
//                out = response.getOutputStream();
//                File zipFile = new File(docPath);
//                fileName = URLEncoder.encode(docNameEx.trim(), StandardCharsets.UTF_8);
//                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
//                FileInputStream input = new FileInputStream(zipFile);
//                buf = new BufferedInputStream(input);
//                byte[] bytes = new byte[buf.available()];
//                int readBytes = -1;
//                while ((readBytes = buf.read(bytes)) != -1) {
//                    out.write(bytes, 0, readBytes);
//                }
//                out.close();
//                buf.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            response.getWriter().println("<body onLoad=\"alert('Документ не найден!');window.opener=window.location.href;window.open('','_parent','');window.close()\">" +
//                    "<h1>Документ не найден!</h1>" +
//                    "</body>");
//        }
//    }

    @GetMapping("/{hash}/{fileId}/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String hash, @PathVariable String fileId, @PathVariable String id ) {
        DBFile dbFile = dbFileService.getByHash(hash);
        Earxiv earxiv = earxivService.getByHashAndFileId(hash, fileId, id);
        String fileName = earxiv.getDocname();
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(dbFile.getFiledata());
    }

}

