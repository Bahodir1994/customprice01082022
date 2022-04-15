package uz.customs.customsprice.controllers.indec;


import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.customs.customsprice.entity.files.Docs;
import uz.customs.customsprice.repository.DocsRepo;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Controller
@RequestMapping("/download")
public class FileDownloadController {
    private final DocsRepo docsRepo;

    public FileDownloadController(DocsRepo docsRepo) {
        this.docsRepo = docsRepo;
    }

    @GetMapping
    public void downloadFile(@Param("id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Optional<Docs> docs = docsRepo.findById(id);
        String docId = "";
        String docName = "";
        String docNameEx = "";
        String docPath = "";
        String docFormat = "";
        if (docs.isPresent()) {
            docName = docs.get().getDocName();
            docNameEx = docs.get().getDocNameEx();
            docPath = docs.get().getDocPath();
            docFormat = docs.get().getDocFormat();

            BufferedInputStream buf = null;
            ServletOutputStream out = null;
            String fileName = "";

            try {
                out = response.getOutputStream();
                File zipFile = new File(docPath);
                fileName = URLEncoder.encode(docNameEx.trim(), StandardCharsets.UTF_8);
                response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
                FileInputStream input = new FileInputStream(zipFile);
                buf = new BufferedInputStream(input);
                byte[] bytes = new byte[buf.available()];
                int readBytes = -1;
                while ((readBytes = buf.read(bytes)) != -1) {
                    out.write(bytes, 0, readBytes);
                }
                out.close();
                buf.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            response.getWriter().println("<body onLoad=\"alert('Документ не найден!');window.opener=window.location.href;window.open('','_parent','');window.close()\">" +
                    "<h1>Документ не найден!</h1>" +
                    "</body>");
        }
    }
}

