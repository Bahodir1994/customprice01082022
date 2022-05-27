package uz.customs.customsprice.controllers.logiccontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import uz.customs.customsprice.entity.logcontrol.CroscheckMainEntity;
import uz.customs.customsprice.entity.logcontrol.FileCrosCheckMain;
import uz.customs.customsprice.repository.FileCheckMainRepo;
import uz.customs.customsprice.repository.logcontrol.LogControlRepo;
import uz.customs.customsprice.service.FileCheckMainService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import static com.itextpdf.text.Utilities.convertToHex;

@Controller
@RequestMapping("/logicalcontrolss")
public class LogicControlController {
    private final String FILTERLC = "/resources/pages/LogicalControl/FilterLC";
    private final String RESULTLC = "/resources/pages/LogicalControl/ResultLC";
    private final String MODALPDFLC = "/resources/pages/LogicalControl/pdfModalLC";
    private final String SAVELCPDFMODAL = "/resources/pages/LogicalControl/savePdfFile";
    private final String EDITORDELETEPDF = "/resources/pages/LogicalControl/EditOrDeletePdf";
    private final FileCheckMainService fileCheckMainService;

    @Autowired
    LogControlRepo logControlRepo;

    @Autowired
    FileCheckMainRepo fileCheckMainRepo;

    public LogicControlController(FileCheckMainService fileCheckMainService) {
        this.fileCheckMainService = fileCheckMainService;
    }

    @PostMapping(value = FILTERLC)
    @ResponseBody
    public ModelAndView FilterLC(HttpSession session) {
        ModelAndView mav = new ModelAndView("resources/pages/LogicControl/FilterLC");
        return mav;
    }

    @GetMapping(value = RESULTLC)
    @ResponseBody
    public ModelAndView ResultLC(HttpServletRequest request, HttpSession session, @RequestParam(required = false)String flkNum, @RequestParam(required = false)String flkName, @RequestParam(required = false)String Dfrom, @RequestParam(required = false)String Dtoo) {
        ModelAndView mav = new ModelAndView("resources/pages/LogicControl/ResultLC");
        String userId = (String) request.getSession().getAttribute("userId");
        Date DfromRes = null;
        Date DtooRes = null;
        if (!Objects.equals(Dfrom, "") && Dfrom !=null){
            DfromRes = Date.valueOf(Dfrom);
        }
        if (!Objects.equals(Dtoo, "") && Dtoo !=null){
            DtooRes = Date.valueOf(Dtoo);
        }
        List<CroscheckMainEntity> croscheckMainEntity = logControlRepo.findByFlkNumAndFlkNameAndStatusAndFlkDepAndFlkDateBetween(flkNum, flkName, String.valueOf(1), "01308", DfromRes, DtooRes);
        mav.addObject("logContrlList", croscheckMainEntity);
        mav.addObject("userId", userId);
        return mav;
    }

    @PostMapping(value = MODALPDFLC)
    @ResponseBody
    public ModelAndView pdfModalLC(HttpServletRequest request, HttpSession session, @RequestParam()String id, @RequestParam()String flkNum){
        String userId = (String) request.getSession().getAttribute("userId");

        FileCrosCheckMain fileCrosCheckMain = new FileCrosCheckMain();
        fileCrosCheckMain = fileCheckMainService.getByFlkId(id);
        if (fileCrosCheckMain == null){
            ModelAndView modelAndView  = new ModelAndView("/resources/pages/LogicControl/pdfModalLC");
            modelAndView.addObject("flkNum", flkNum);
            modelAndView.addObject("id", id);
            modelAndView.addObject("userId", userId);
            return modelAndView;
        }else {
            ModelAndView modelAndView  = new ModelAndView("/resources/pages/LogicControl/OpenerPdfLc");
            String imageBase64 = "";
            imageBase64 = new String(Base64.getEncoder().encode(fileCrosCheckMain.getData()));
            modelAndView.addObject("pdfFile", imageBase64);
            modelAndView.addObject("logControlFile", fileCrosCheckMain.getContentType());
            return modelAndView;
        }

    }

    @PostMapping(value = SAVELCPDFMODAL)
    @ResponseBody
    public HttpStatus savePdf(@RequestParam("file") MultipartFile multipartFile, @RequestParam("flkId")String flkId) throws IOException, NoSuchAlgorithmException {
        FileCrosCheckMain fileCrosCheckMain = new FileCrosCheckMain();
        try {
            if (fileCheckMainRepo.findByFlkId(flkId) != null ){
                fileCheckMainRepo.deleteFileCrosCheckMainByFlkId(flkId);
                fileCrosCheckMain.setData(multipartFile.getBytes());
                fileCrosCheckMain.setFlkId(flkId);
                String hashtext = null;
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(multipartFile.getBytes());
                hashtext = convertToHex(messageDigest);
                fileCrosCheckMain.setHash(hashtext);
                fileCrosCheckMain.setContentType(multipartFile.getContentType());
                fileCheckMainRepo.save(fileCrosCheckMain);
                return HttpStatus.OK;
            }else {
                fileCrosCheckMain.setData(multipartFile.getBytes());
                fileCrosCheckMain.setFlkId(flkId);
                String hashtext = null;
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] messageDigest = md.digest(multipartFile.getBytes());
                hashtext = convertToHex(messageDigest);
                fileCrosCheckMain.setHash(hashtext);
                fileCrosCheckMain.setContentType(multipartFile.getContentType());
                fileCheckMainRepo.save(fileCrosCheckMain);
                return HttpStatus.OK;
            }
        }catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    @PostMapping(value = EDITORDELETEPDF)
    @ResponseBody
    public ModelAndView EditOrDeletePdf(HttpServletRequest request, HttpSession session, @RequestParam()String id, @RequestParam()String flkNum) {
        String userId = (String) request.getSession().getAttribute("userId");
        FileCrosCheckMain fileCrosCheckMain = new FileCrosCheckMain();
        fileCrosCheckMain = fileCheckMainService.getByFlkId(id);
        if (fileCrosCheckMain != null) {
            ModelAndView modelAndView = new ModelAndView("/resources/pages/LogicControl/EditOrDeletePdf");
            modelAndView.addObject("flkNum", flkNum);
            modelAndView.addObject("id", id);
            modelAndView.addObject("userId", userId);
            modelAndView.addObject("originalName", fileCrosCheckMain.getOrginialName());
            return modelAndView;
        }else {
            ModelAndView modelAndView  = new ModelAndView("/resources/pages/LogicControl/pdfModalLC");
            modelAndView.addObject("flkNum", flkNum);
            modelAndView.addObject("id", id);
            modelAndView.addObject("userId", userId);
            return modelAndView;
        }
    }

}