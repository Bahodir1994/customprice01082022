package uz.customs.customsprice.service.makerJasper;


import com.itextpdf.text.DocumentException;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import uz.customs.customsprice.entity.InitialDecision.Apps;
import uz.customs.customsprice.entity.InitialDecision.Commodity;
import uz.customs.customsprice.entity.InitialDecision.StatusH;
import uz.customs.customsprice.repository.AppsRepo;
import uz.customs.customsprice.repository.CommodityRepo;
import uz.customs.customsprice.repository.StatusHRepo;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

@Service
public class PdfGenerateService {

    @Autowired
    AppsRepo appsRepo;

    @Autowired
    CommodityRepo commodityRepo;

    @Autowired
    StatusHRepo statusHRepo;

    public Object exp(HttpServletRequest request, String stId, String status) throws IOException, DocumentException, FileNotFoundException, JRException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        Optional<StatusH> statusH = statusHRepo.findById(stId);
        Optional<Apps> apps = appsRepo.findById(statusH.get().getAppId());
        List<Commodity> commodity = commodityRepo.findByAppId(statusH.get().getAppId());

        File file = ResourceUtils.getFile("src/main/resources/appeal.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(Collections.singleton(statusH));
        Map<String, Object> parameters= new HashMap<>();
        parameters.put("Created 2022 year", "AjiVaji");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrBeanCollectionDataSource);
        JasperExportManager.exportReportToPdfStream(jasperPrint, baos);

        byte[] bytes = baos.toByteArray();
        String base64 = Base64.getEncoder().encodeToString(bytes);
        return base64;

    }

}
